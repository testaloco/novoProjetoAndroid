package com.example.myapplication.model;

import java.util.Date;

public class CovidBrasil {
    private Integer uId;
    private String uF;
    private String estado;
    private Integer casos;
    private Integer mortes;
    private Integer suspeitos;
    private Integer recusados;
    private String  comentarios;
    private Date  dataFiltragem;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuF() {
        return uF;
    }

    public void setuF(String uF) {
        this.uF = uF;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCasos() {
        return casos;
    }

    public void setCasos(Integer casos) {
        this.casos = casos;
    }

    public Integer getMortes() {
        return mortes;
    }

    public void setMortes(Integer mortes) {
        this.mortes = mortes;
    }

    public Integer getSuspeitos() {
        return suspeitos;
    }

    public void setSuspeitos(Integer suspeitos) {
        this.suspeitos = suspeitos;
    }

    public Integer getRecusados() {
        return recusados;
    }

    public void setRecusados(Integer recusados) {
        this.recusados = recusados;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getDataFiltragem() {
        return dataFiltragem;
    }

    public void setDataFiltragem(Date dataFiltragem) {
        this.dataFiltragem = dataFiltragem;
    }
}
