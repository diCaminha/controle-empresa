package com.example.demo.entities;

import com.example.demo.enums.TipoEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "lancamento")
public class Lancamento {

    public static final long serialVersionUID = -43534545666632234L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Date data;

    private String descricao;

    private String localizacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoEnum tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

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
}
