package com.federico.velector;

/**
 * Created by federico on 01/05/2017.
 */

public class lista_entrada {

    private int words;
    private String titulo, autor;

    public lista_entrada( int precio, String nombre, String descripcion) {
        this.words = precio;
        this.titulo = nombre;
        this.autor = descripcion;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
