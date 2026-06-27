package com.consultoriarhapi.dto;

public class CandidaturaResponseDTO {

    private Long id;
    private Long vagaId;
    private Long candidatoId;
    private String fase;
    private java.time.LocalDateTime dataInscricao;
    private String status;
    private Double pontuacao;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
