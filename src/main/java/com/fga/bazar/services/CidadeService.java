package com.fga.bazar.services;

import com.fga.bazar.models.Cidade;
import com.fga.bazar.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade buscarPorId(Integer id) {
        return cidadeRepository.findById(id).orElseThrow();
    }

    public List<Cidade> listarCidades() {
        return cidadeRepository.findAll();
    }

    public Cidade inserir(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void atualizarCidade(Integer id, Cidade cidade) {
        var cidadeSalva = this.buscarPorId(id);

        cidadeSalva.setNome(cidade.getNome());

        cidadeRepository.save(cidadeSalva);
    }

    public void excluirCidade(Integer id) {
        cidadeRepository.deleteById(id);
    }

}
