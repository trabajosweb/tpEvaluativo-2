package org.dominio;

import java.io.Serializable;


public class Equipo implements Serializable{
	String nombre;
	Jugador jugador;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", jugador=" + jugador + "]";
	}
	public Equipo(String nombre, Jugador jugador) {
		super();
		this.nombre = nombre;
		this.jugador = jugador;
	}
	public Equipo() {
		// TODO Auto-generated constructor stub
	}
	
	
	}
