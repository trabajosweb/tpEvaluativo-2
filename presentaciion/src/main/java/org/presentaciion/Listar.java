package org.presentaciion;

import org.apache.wicket.markup.html.WebPage;
import org.servicio.ServicioEquipo;

public class Listar extends WebPage{

	ServicioEquipo servicio= new ServicioEquipo();
	public Listar() {
		add(new Navegacion("navegacion"));
		servicio.listar();
}


}