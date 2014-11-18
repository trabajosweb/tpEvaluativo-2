package org.repositorio;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.dominio.Equipo;

public interface IRepositorio {

	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SQLite");
	
	public void guardar(Equipo equipo);
	public List listar();
}