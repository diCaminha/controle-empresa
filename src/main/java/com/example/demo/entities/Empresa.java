package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 314134234252424524L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    private String cnpj;

    private Date dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private Date dataAtualizacao;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
