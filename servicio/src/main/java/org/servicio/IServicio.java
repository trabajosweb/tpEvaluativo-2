package org.servicio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface IServicio {
	ApplicationContext context = new AnnotationConfigApplicationContext(
	ClaseConfiguracion.class);
	public void guardar();	
	public void listar();
}
