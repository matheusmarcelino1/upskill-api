package com.fiap.global.upskill.controller;

import com.fiap.global.upskill.dto.MatriculaDTO;
import com.fiap.global.upskill.entity.Matricula;
import com.fiap.global.upskill.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    private final MatriculaService service;

    public MatriculaController(MatriculaService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> all() {
        List<MatriculaDTO> list = service.findAll().stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> create(@Valid @RequestBody MatriculaDTO dto) {
        Matricula saved = service.create(dto.getUsuarioId(), dto.getTrilhaId());
        return ResponseEntity.created(URI.create("/api/matriculas/" + saved.getId())).body(toDTO(saved));
    }

    private MatriculaDTO toDTO(Matricula m) {
        MatriculaDTO d = new MatriculaDTO();
        d.setId(m.getId());
        d.setUsuarioId(m.getUsuario().getId());
        d.setTrilhaId(m.getTrilha().getId());
        d.setStatus(m.getStatus());
        return d;
    }
}
