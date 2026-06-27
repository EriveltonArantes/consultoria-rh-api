package com.consultoriarhapi.dto;

import jakarta.validation.constraints.*;

public class CandidatoRequestDTO {

    @NotNull(message = "EmpresaId é obrigatório")
    @Positive(message = "EmpresaId deve ser um ID válido (positivo)")
    private Long empresaId;
    @NotNull(message = "VagaId é obrigatório")
    @Positive(message = "VagaId deve ser um ID válido (positivo)")
    private Long vagaId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "formacao não pode estar em branco")
    private String formacao;
    @NotBlank(message = "experiencia não pode estar em branco")
    private String experiencia;
    @NotBlank(message = "pretensao não pode estar em branco")
    private String pretensao;
    @NotBlank(message = "disponibilidade não pode estar em branco")
    private String disponibilidade;

    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getFormacao() { return formacao; }
    public void setFormacao(String formacao) { this.formacao = formacao; }
    public String getExperiencia() { return experiencia; }
    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }
    public String getPretensao() { return pretensao; }
    public void setPretensao(String pretensao) { this.pretensao = pretensao; }
    public String getDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(String disponibilidade) { this.disponibilidade = disponibilidade; }
}
