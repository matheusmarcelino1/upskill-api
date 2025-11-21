package com.fiap.global.upskill.controller;

import com.fiap.global.upskill.dto.UsuarioDTO;
import com.fiap.global.upskill.entity.Usuario;
import com.fiap.global.upskill.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> all() {
        List<UsuarioDTO> list = service.findAll().stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(toDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto) {
        Usuario u = toEntity(dto);
        Usuario saved = service.create(u);
        return ResponseEntity.created(URI.create("/api/usuarios/" + saved.getId())).body(toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto) {
        Usuario updated = toEntity(dto);
        Usuario res = service.update(id, updated);
        return ResponseEntity.ok(toDTO(res));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private UsuarioDTO toDTO(Usuario u) {
        UsuarioDTO d = new UsuarioDTO();
        d.setId(u.getId());
        d.setNome(u.getNome());
        d.setEmail(u.getEmail());
        d.setAreaAtuacao(u.getAreaAtuacao());
        d.setNivelCarreira(u.getNivelCarreira());
        return d;
    }

    private Usuario toEntity(UsuarioDTO d) {
        Usuario u = new Usuario();
        u.setNome(d.getNome());
        u.setEmail(d.getEmail());
        u.setAreaAtuacao(d.getAreaAtuacao());
        u.setNivelCarreira(d.getNivelCarreira());
        return u;
    }
}
