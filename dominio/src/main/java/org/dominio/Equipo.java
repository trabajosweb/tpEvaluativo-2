package org.dominio;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Equipo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	@Column(name="JUGADOR_ID")
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
