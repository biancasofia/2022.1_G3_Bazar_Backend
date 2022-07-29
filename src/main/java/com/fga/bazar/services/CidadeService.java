package com.fga.bazar.services;

import com.fga.bazar.models.Cidade;
import com.fga.bazar.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = true)
    public Cidade buscarPorId(Integer id) {
        return cidadeRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Cidade> listarCidades() {
        return cidadeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Cidade> buscarCidadesPorSiglaDoEstado(String sigla) {
        return cidadeRepository.buscarCidadesPorSiglaDoEstado(sigla);
    }

    @Transactional
    public Cidade inserir(Cidade cidade) {
        var novaCidade = new Cidade();

        novaCidade.setNome(cidade.getNome());

        novaCidade = cidadeRepository.save(cidade);

        return novaCidade;
    }

    @Transactional
    public void atualizarCidade(Integer id, Cidade cidade) {
        try {
            var cidadeSalva = cidadeRepository.getReferenceById(id);

            cidadeSalva.setNome(cidade.getNome());

            cidadeRepository.save(cidadeSalva);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirCidade(Integer id) {
        try {
            cidadeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException(e);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(e);
        }
    }

}
