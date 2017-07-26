package com.example.avelino.firebaseapp;

import java.util.Date;

/**
 * Created by avelino on 25/07/2017.
 */

public class Anuncio {

    private String id;
    private String titulo;
    private String descricao;
    private Long produtoId;
    private Double preco;
    private Date dataAnuncio;

    public Anuncio() {
    }

    public Anuncio(String id, String titulo, String descricao, Long produtoId, Double preco, Date dataAnuncio) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.produtoId = produtoId;
        this.preco = preco;
        this.dataAnuncio = dataAnuncio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDataAnuncio() {
        return dataAnuncio;
    }

    public void setDataAnuncio(Date dataAnuncio) {
        this.dataAnuncio = dataAnuncio;
    }
}
