package com.fga.bazar.services;

import com.fga.bazar.models.Estado;
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
    public Estado inserir(Estado estado) {
        var novoEstado = new Estado();

        novoEstado.setSigla(estado.getSigla());
        novoEstado.setNome(estado.getNome());

        novoEstado = estadoRepository.save(novoEstado);

        for ( var cidade : estado.getCidades() ){
            cidade.setEstado(novoEstado);
            var novaCidade = cidadeRepository.save(cidade);
            novoEstado.getCidades().add(novaCidade);
            System.out.println(cidade.getNome());
        }

        novoEstado = estadoRepository.save(novoEstado);


        return novoEstado;
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
