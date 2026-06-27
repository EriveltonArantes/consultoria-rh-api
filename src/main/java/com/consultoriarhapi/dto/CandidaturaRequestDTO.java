package com.consultoriarhapi.dto;

import jakarta.validation.constraints.*;

public class CandidaturaRequestDTO {

    @NotNull(message = "VagaId é obrigatório")
    @Positive(message = "VagaId deve ser um ID válido (positivo)")
    private Long vagaId;
    @NotNull(message = "CandidatoId é obrigatório")
    @Positive(message = "CandidatoId deve ser um ID válido (positivo)")
    private Long candidatoId;
    @NotBlank(message = "fase não pode estar em branco")
    private String fase;
    @NotNull(message = "data inscricao não pode ser nulo")
    private java.time.LocalDateTime dataInscricao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @NotNull(message = "pontuacao não pode ser nulo")
    private Double pontuacao;

    private String observacoes;

    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }
    public Long getCandidatoId() { return candidatoId; }
    public void setCandidatoId(Long candidatoId) { this.candidatoId = candidatoId; }
    public String getFase() { return fase; }
    public void setFase(String fase) { this.fase = fase; }
    public java.time.LocalDateTime getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(java.time.LocalDateTime dataInscricao) { this.dataInscricao = dataInscricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getPontuacao() { return pontuacao; }
    public void setPontuacao(Double pontuacao) { this.pontuacao = pontuacao; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
