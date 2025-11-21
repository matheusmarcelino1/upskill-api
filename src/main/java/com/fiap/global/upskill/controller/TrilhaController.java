package com.fiap.global.upskill.controller;

import com.fiap.global.upskill.dto.TrilhaDTO;
import com.fiap.global.upskill.entity.Trilha;
import com.fiap.global.upskill.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {
    private final TrilhaService service;

    public TrilhaController(TrilhaService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<TrilhaDTO>> all() {
        List<TrilhaDTO> list = service.findAll().stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(toDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<TrilhaDTO> create(@Valid @RequestBody TrilhaDTO dto) {
        Trilha t = toEntity(dto);
        Trilha saved = service.create(t);
        return ResponseEntity.created(URI.create("/api/trilhas/" + saved.getId())).body(toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDTO> update(@PathVariable Long id, @Valid @RequestBody TrilhaDTO dto) {
        Trilha updated = toEntity(dto);
        Trilha res = service.update(id, updated);
        return ResponseEntity.ok(toDTO(res));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private TrilhaDTO toDTO(Trilha t) {
        TrilhaDTO d = new TrilhaDTO();
        d.setId(t.getId());
        d.setNome(t.getNome());
        d.setDescricao(t.getDescricao());
        d.setNivel(t.getNivel());
        d.setCargaHoraria(t.getCargaHoraria());
        d.setFocoPrincipal(t.getFocoPrincipal());
        return d;
    }

    private Trilha toEntity(TrilhaDTO d) {
        Trilha t = new Trilha();
        t.setNome(d.getNome());
        t.setDescricao(d.getDescricao());
        t.setNivel(d.getNivel());
        t.setCargaHoraria(d.getCargaHoraria());
        t.setFocoPrincipal(d.getFocoPrincipal());
        return t;
    }
}
