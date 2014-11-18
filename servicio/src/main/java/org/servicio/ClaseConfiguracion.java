package org.servicio;

import org.repositorio.IRepositorio;
import org.repositorio.RepositorioEquipo;
import org.springframework.context.annotation.Bean;
public class ClaseConfiguracion {
	@Bean(name = "RepositorioEquipo")
	public IRepositorio repoIRepositorio() {
		return new RepositorioEquipo();
	}

}
