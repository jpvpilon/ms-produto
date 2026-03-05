package com.github.jpvpilon.ms.produto.service;

import com.github.jpvpilon.ms.produto.dto.CategoriaDTO;
import com.github.jpvpilon.ms.produto.dto.ProdutoDTO;
import com.github.jpvpilon.ms.produto.entities.Categoria;
import com.github.jpvpilon.ms.produto.entities.Produto;
import com.github.jpvpilon.ms.produto.exception.ResourceNotFoundException;
import com.github.jpvpilon.ms.produto.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<CategoriaDTO> findAllCategorias() {

        return categoriaRepository.findAll()
                .stream().map(CategoriaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoriaDTO findCategoriaById(Long id) {

        Categoria categoria = categoriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );

        return new CategoriaDTO(categoria);
    }

    @Transactional
    public CategoriaDTO saveCategoria(CategoriaDTO inputDTO) {
        Categoria categoria = new Categoria();
        copyDtoCategoria(inputDTO, categoria);
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria);
    }

    private void copyDtoCategoria(CategoriaDTO inputDTO, Categoria categoria) {

        categoria.setNome(inputDTO.getNome());
    }

    @Transactional
    public CategoriaDTO updateCategoria(Long id, CategoriaDTO inputDTO) {

        try {
            Categoria categoria = categoriaRepository.getReferenceById(id);
            copyDtoCategoria(inputDTO, categoria);
            categoria = categoriaRepository.save(categoria);
            return new CategoriaDTO(categoria);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado ID: " + id);

        }
    }

    @Transactional
    public void deleteCategoriaById(Long id) {

        if(!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);

        }

        categoriaRepository.deleteById(id);
    }
}
