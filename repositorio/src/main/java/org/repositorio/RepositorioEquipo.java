package org.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.dominio.Equipo;
import org.dominio.Jugador;

public class RepositorioEquipo implements IRepositorio{
	
	public void guardar(Equipo equipo) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			pm.makePersistent(equipo);
			tx.commit();
		}
		finally {
			if (tx.isActive())
		    {
		        tx.rollback();
		    }
			pm.close();
		}
	}
	
	public List listar() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		
		List<Equipo> equipos = new ArrayList<Equipo>();
		
		try {
			tx.begin();
			
			Extent ex = pm.getExtent(Equipo.class);
		    
		    Query q = (Query) pm.newQuery(ex);
		
			List<Equipo> listaEquipos;
		    
		    listaEquipos = (List<Equipo>) q.execute();
		    
		    for(Equipo e : listaEquipos) {
		    	Equipo equipo= new Equipo();
		    	Jugador jugador= new Jugador();
		    	jugador.setNombre(e.getJugador().getNombre());
		    	jugador.setApellido(e.getJugador().getApellido());
		    	equipo.setNombre(e.getNombre());
		    	equipo.setJugador(jugador);
		    	equipos.add(equipo);
		    }
		    
			tx.commit();
		}
		finally {
			if (tx.isActive())
		    {
		        tx.rollback();
		    }
			pm.close();
		}
		
		return equipos;
}
}