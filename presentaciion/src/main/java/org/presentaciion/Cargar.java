package org.presentaciion;

import org.apache.wicket.markup.html.WebPage;
import org.servicio.ServicioEquipo;

public class Cargar extends WebPage {
	ServicioEquipo servicio= new ServicioEquipo();
	public Cargar() {
		add(new Navegacion("navegacion"));
		servicio.cargar();
		setResponsePage(new HomePage());
}
}
