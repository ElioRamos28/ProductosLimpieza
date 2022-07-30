package com.edutecno.model;

public class Categoria {
	
	//atributos
	private int id;
	private String nombre;
	
	//constructor vacio
	public Categoria() {
	}
	
	//constructor usando parametros
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	//getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
