package com.fga.bazar.services;

import com.fga.bazar.models.Usuario;
import com.fga.bazar.repositories.UsuarioRepository;
import com.fga.bazar.services.exceptions.ForbiddenException;
import com.fga.bazar.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorizacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Usuario obterUsuarioAutenticado() {
        try {
            var nomeDeUsuario = SecurityContextHolder.getContext()
                    .getAuthentication().getName();

            return usuarioRepository.findByEmail(nomeDeUsuario);
        } catch (Exception e) {
            throw new UnauthorizedException("Usuário não identificado.");
        }
    }

    public void verificarSeDonoDoRecursoOuAdmin(Integer usuarioId) {
        var usuario = this.obterUsuarioAutenticado();

        if (!usuario.getId().equals(usuarioId) || !usuario.hasPapel("ROLE_ADMIN")) {
            throw new ForbiddenException("Acesso negado! Você não tem permissão para acessar esse recurso");
        }
    }

}
