package com.fiap.global.upskill.service;

import com.fiap.global.upskill.entity.Usuario;
import com.fiap.global.upskill.exception.ResourceNotFoundException;
import com.fiap.global.upskill.repository.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario create(Usuario u) {
        repo.findByEmail(u.getEmail()).ifPresent(existing -> {
            throw new DataIntegrityViolationException("Email já existe");
        });
        return repo.save(u);
    }

    public List<Usuario> findAll() {
        return repo.findAll();
    }

    public Usuario findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
    }

    public Usuario update(Long id, Usuario updated) {
        Usuario exist = findById(id);
        exist.setNome(updated.getNome());
        exist.setAreaAtuacao(updated.getAreaAtuacao());
        exist.setNivelCarreira(updated.getNivelCarreira());
        // if email changed, check uniqueness
        if (updated.getEmail() != null && !updated.getEmail().equals(exist.getEmail())) {
            repo.findByEmail(updated.getEmail()).ifPresent(e -> { throw new DataIntegrityViolationException("Email já existe"); });
            exist.setEmail(updated.getEmail());
        }
        return repo.save(exist);
    }

    public void delete(Long id) {
        Usuario u = findById(id);
        repo.delete(u);
    }
}
