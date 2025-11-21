package com.fiap.global.upskill.service;

import com.fiap.global.upskill.entity.Trilha;
import com.fiap.global.upskill.exception.ResourceNotFoundException;
import com.fiap.global.upskill.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {
    private final TrilhaRepository repo;

    public TrilhaService(TrilhaRepository repo) { this.repo = repo; }

    public Trilha create(Trilha t) { return repo.save(t); }
    public List<Trilha> findAll() { return repo.findAll(); }
    public Trilha findById(Long id) { return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada")); }
    public Trilha update(Long id, Trilha updated) {
        Trilha exist = findById(id);
        exist.setNome(updated.getNome());
        exist.setDescricao(updated.getDescricao());
        exist.setNivel(updated.getNivel());
        exist.setCargaHoraria(updated.getCargaHoraria());
        exist.setFocoPrincipal(updated.getFocoPrincipal());
        return repo.save(exist);
    }
    public void delete(Long id) {
        Trilha t = findById(id);
        repo.delete(t);
    }
}
