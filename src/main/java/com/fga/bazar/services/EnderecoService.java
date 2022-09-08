package com.fga.bazar.services;

import com.fga.bazar.models.Endereco;
import com.fga.bazar.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AutorizacaoService autorizacaoService;

    @Transactional(readOnly = true)
    public List<Endereco> obterTodosOsEnderecosDoUsuarioLogado() {
        var usuario = autorizacaoService.obterUsuarioAutenticado();
        return enderecoRepository.findByUsuarioId(usuario.getId());
    }

}
