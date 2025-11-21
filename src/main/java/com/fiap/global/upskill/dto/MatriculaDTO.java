package com.fiap.global.upskill.dto;

import jakarta.validation.constraints.NotNull;

public class MatriculaDTO {
    private Long id;

    @NotNull(message = "usuarioId obrigatório")
    private Long usuarioId;

    @NotNull(message = "trilhaId obrigatório")
    private Long trilhaId;

    private String status;

    public MatriculaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getTrilhaId() { return trilhaId; }
    public void setTrilhaId(Long trilhaId) { this.trilhaId = trilhaId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
