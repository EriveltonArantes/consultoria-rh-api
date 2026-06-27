package com.consultoriarhapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidaturas")
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;
    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;
    @Column(nullable = false)
    private String fase;
    private java.time.LocalDateTime dataInscricao;
    @Column(nullable = false)
    private String status;
    private Double pontuacao;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vaga getVaga() { return vaga; }
    public void setVaga(Vaga vaga) { this.vaga = vaga; }
    public Candidato getCandidato() { return candidato; }
    public void setCandidato(Candidato candidato) { this.candidato = candidato; }
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
