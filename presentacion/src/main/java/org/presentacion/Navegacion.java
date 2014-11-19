package org.presentacion;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.servicio.ServicioEquipo;


public class Navegacion extends Panel {
		   public ServicioEquipo servicio= new ServicioEquipo();
	       public Navegacion(String id) {

			super(id);
			
			Link inicio = new Link("inicio") {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					this.setResponsePage(new HomePage());
				}			
			};
			
			Link cargar = new Link("cargar") {
				@Override
				public void onClick() {
					this.setResponsePage(new Cargar());
				}	
			};
			
			Link listar = new Link("listar") {
				@Override
				public void onClick() {
					this.setResponsePage(new Listar());
					
				}			
			};
			
			add(inicio);
			add(cargar);
			add(listar);
		}
}
