package org.dominio;

import java.io.Serializable;

public class Jugador implements Serializable{
	String nombre;
	String apellido;
	String posicion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido
				+ ", posicion=" + posicion + "]";
	}
	public Jugador(String nombre, String apellido, String posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.posicion = posicion;
	}
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	
}
