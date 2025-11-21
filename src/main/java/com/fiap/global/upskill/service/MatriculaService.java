package com.fiap.global.upskill.service;

import com.fiap.global.upskill.entity.Matricula;
import com.fiap.global.upskill.entity.Trilha;
import com.fiap.global.upskill.entity.Usuario;
import com.fiap.global.upskill.exception.ResourceNotFoundException;
import com.fiap.global.upskill.repository.MatriculaRepository;
import com.fiap.global.upskill.repository.TrilhaRepository;
import com.fiap.global.upskill.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatriculaService {
    private final MatriculaRepository repo;
    private final UsuarioRepository usuarioRepo;
    private final TrilhaRepository trilhaRepo;

    public MatriculaService(MatriculaRepository repo, UsuarioRepository usuarioRepo, TrilhaRepository trilhaRepo) {
        this.repo = repo;
        this.usuarioRepo = usuarioRepo;
        this.trilhaRepo = trilhaRepo;
    }

    public Matricula create(Long usuarioId, Long trilhaId) {
        Usuario u = usuarioRepo.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
        Trilha t = trilhaRepo.findById(trilhaId).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada"));
        Matricula m = new Matricula();
        m.setUsuario(u);
        m.setTrilha(t);
        m.setDataInscricao(LocalDate.now());
        m.setStatus("ATIVA");
        return repo.save(m);
    }

    public List<Matricula> findAll() { return repo.findAll(); }
}
