package com.fga.bazar.services;

import com.fga.bazar.models.Categoria;
import com.fga.bazar.repositories.CategoriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria inserir(Categoria categoria) {

        return  categoriaRepository.save(categoria);
    }

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(
                () -> new ObjectNotFoundException("Categoria não encontrada! Id informado: " + id, null)
        );
    }

    public List<Categoria> buscarCidades() {
        return categoriaRepository.findAll();
    }




    public void atualizarCategoria(Integer id, Categoria categoria) {
        var categoriaAtualizada = buscarPorId(id);
        categoriaAtualizada.setNome(categoria.getNome());
        categoriaRepository.save(categoriaAtualizada);
    }


    public void excluirCategoria(Integer id) {
        buscarPorId(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir esta categoria");
        }
    }

}