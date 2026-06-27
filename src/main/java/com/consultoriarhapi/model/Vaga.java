package com.consultoriarhapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vagas")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String nivel;
    @Column(nullable = false)
    private String area;
    private java.math.BigDecimal salario;
    @Column(nullable = false)
    private String beneficios;
    @Column(nullable = false)
    private String modalidade;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public java.math.BigDecimal getSalario() { return salario; }
    public void setSalario(java.math.BigDecimal salario) { this.salario = salario; }
    public String getBeneficios() { return beneficios; }
    public void setBeneficios(String beneficios) { this.beneficios = beneficios; }
    public String getModalidade() { return modalidade; }
    public void setModalidade(String modalidade) { this.modalidade = modalidade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
