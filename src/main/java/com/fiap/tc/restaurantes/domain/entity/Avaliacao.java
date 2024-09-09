package com.fiap.tc.restaurantes.domain.entity;

public class Avaliacao {

    private Long avaliacaoId;
    private Restaurante restaurante;
    private Usuario usuario;
    private Integer nota;
    private String comentario;

    public Avaliacao(Long avaliacaoId, Restaurante restaurante, Usuario usuario, Integer nota, String comentario) {
        this.avaliacaoId = avaliacaoId;
        this.restaurante = restaurante;
        this.usuario = usuario;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Avaliacao() {
    }

    public Long getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(Long avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
