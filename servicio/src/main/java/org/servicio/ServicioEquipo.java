package org.servicio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.PropertyModel;
import org.dominio.Equipo;
import org.repositorio.IRepositorio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServicioEquipo extends WebPage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ApplicationContext context = new AnnotationConfigApplicationContext(
			ClaseConfiguracion.class);
	IRepositorio repositorio = (IRepositorio) context.getBean("RepositorioEquipo");
	
	private TextField nombre;
	private TextField apellido;
	private List listaPosiciones = Arrays.asList(new String[] {"Arquero","Defensor","Medio Campista","Delantero"});
	private DropDownChoice posicion;
	private List listaEquipos = Arrays.asList(new String[] {"Boca","River","Independiente","Racing"});
	private DropDownChoice nombresEquipos;
	
	private PropertyModel nombreModelo;
	private PropertyModel apellidoModelo;
	private PropertyModel posicionModelo;
	private PropertyModel nombreEquipoModelo;
	
	public void guardar(){
		
		final Equipo equipo = new Equipo();
		nombreModelo = new PropertyModel(equipo,"jugador.nombre");
		apellidoModelo = new PropertyModel(equipo,"jugador.apellido");
		posicionModelo= new PropertyModel(equipo,"jugador.posicion");
		nombreEquipoModelo = new PropertyModel(equipo, "nombre");
		 
		nombre = new TextField<String>("nombre",nombreModelo);
		apellido = new TextField<String>("apellido",apellidoModelo);
		posicion = new DropDownChoice("posicion",posicionModelo,listaPosiciones);
		nombresEquipos= new DropDownChoice("nombresEquipos",nombreEquipoModelo,listaEquipos);
		
		Form formulario = new Form("formCargar") {
			@Override
			public void onSubmit() {
				
				repositorio.guardar(equipo);
			}
		};
		
		formulario.add(nombre);
		formulario.add(apellido);
		formulario.add(posicion);
		formulario.add(nombresEquipos);
		add(formulario);
	}
	public void listar(){
		List<Equipo> equipos = repositorio.listar();
		
		ListDataProvider<Equipo> listDataProvider = new ListDataProvider<Equipo>(equipos);
		DataView<Equipo> dataView = new DataView<Equipo>("filas", listDataProvider) {

		  @Override
		  protected void populateItem(Item<Equipo> item) {
		   Equipo equipo = item.getModelObject();
		    RepeatingView repeatingView = new RepeatingView("datosFila");

		    repeatingView.add(new Label(repeatingView.newChildId(), equipo.getNombre()));
		    repeatingView.add(new Label(repeatingView.newChildId(), equipo.getJugador().getNombre()));
		    repeatingView.add(new Label(repeatingView.newChildId(), equipo.getJugador().getApellido()));    
		    repeatingView.add(new Label(repeatingView.newChildId(), equipo.getJugador().getPosicion()));
		    item.add(repeatingView); 
		  }
		};
		add(dataView);
	}
	}
