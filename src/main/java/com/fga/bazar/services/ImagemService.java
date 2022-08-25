package com.fga.bazar.services;

import com.fga.bazar.models.Imagem;
import com.fga.bazar.repositories.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImagemService {
    @Autowired
    private ImagemRepository imagemRepository ;

    public Imagem inserir(Imagem imagem) {

        return imagemRepository.save(imagem);
    }

    @Transactional(readOnly = true)
    public List<Imagem> listarImagens() {
        return imagemRepository.findAll();
    }
    public void excluirImagem(Integer id) {
        try {
            imagemRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException(e);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(e);
        }
    }


}
