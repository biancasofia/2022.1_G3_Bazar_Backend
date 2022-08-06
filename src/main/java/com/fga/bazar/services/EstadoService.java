package com.fga.bazar.services;

import com.fga.bazar.models.Cidade;
import com.fga.bazar.models.Estado;
import com.fga.bazar.models.dtos.EstadoDto;
import com.fga.bazar.repositories.CidadeRepository;
import com.fga.bazar.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = true)
    public Estado buscarPorId(Integer id) {
        return estadoRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Transactional(readOnly = true)
    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    @Transactional
    public EstadoDto inserir(EstadoDto estadoDto) {
        var novoEstado = new Estado();

        novoEstado.setSigla(estadoDto.getSigla());
        novoEstado.setNome(estadoDto.getNome());

        novoEstado = estadoRepository.save(novoEstado);

        for ( var cidade : estadoDto.getCidades() ){
            var novaCidade = new Cidade(null, cidade.getNome(), novoEstado);
            novaCidade = cidadeRepository.save(novaCidade);

            novoEstado.getCidades().add(novaCidade);
        }

        return new EstadoDto(novoEstado);
    }

    @Transactional
    public void atualizarEstado(Integer id, Estado estado) {
        try {
            var estadoSalvo = estadoRepository.getReferenceById(id);

            estadoSalvo.setSigla(estado.getSigla());
            estadoSalvo.setNome(estado.getNome());

            estadoRepository.save(estadoSalvo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirEstado(Integer id) {
        try {
            estadoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException(e);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(e);
        }
    }

}
