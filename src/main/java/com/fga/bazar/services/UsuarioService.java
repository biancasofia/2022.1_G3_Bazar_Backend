package com.fga.bazar.services;

import com.fga.bazar.models.Endereco;
import com.fga.bazar.models.Usuario;
import com.fga.bazar.models.dtos.NovoUsuarioDto;
import com.fga.bazar.models.dtos.UsuarioDto;
import com.fga.bazar.models.enums.Papeis;
import com.fga.bazar.repositories.CidadeRepository;
import com.fga.bazar.repositories.EnderecoRepository;
import com.fga.bazar.repositories.PapelRepository;
import com.fga.bazar.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements UserDetailsService {

    private Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findByEmail(username);

        if (usuario == null) {
            LOG.error("Usuário não encontrado! Usuário: " + username);
            throw new UsernameNotFoundException("Usuário não encontrado! Usuário: " + username);
        }

        LOG.info("Usuário encontrado! Usuário: " + username);

        return usuario;
    }

    @Transactional
    public UsuarioDto cadastrarCliente(NovoUsuarioDto usuarioDto) {
        var novoUsuario = new Usuario();

        novoUsuario.setId(null);
        novoUsuario.setNome(usuarioDto.getNome());
        novoUsuario.setCpf(usuarioDto.getCpf());
        novoUsuario.setEmail(usuarioDto.getEmail());
        novoUsuario.setSenha(encoder.encode(usuarioDto.getSenha()));

        var papel = papelRepository.findById(Papeis.CLIENTE.value()).orElseThrow();

        novoUsuario.getPapeis().add(papel);

        novoUsuario = usuarioRepository.save(novoUsuario);

        for (var enderecoDto : usuarioDto.getEnderecos()) {
            var cidade = cidadeRepository.getReferenceById(enderecoDto.cidadeId());
            var endereco = new Endereco(null, enderecoDto.cep(), enderecoDto.numero(), enderecoDto.bairro(), enderecoDto.complemento(), cidade, novoUsuario);

            enderecoRepository.save(endereco);
        }

        return new UsuarioDto(novoUsuario);
    }

}
