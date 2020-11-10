package co.udistrital.ws.rest.servicio;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.udistrital.ws.rest.logica.Sistema;
import co.udistrital.ws.rest.logica.Variable;

@Path("/NetCDF/{id}")
public class ServicioVariable {
	
	private Sistema sistema;	
	
	
	public ServicioVariable(@PathParam("id") int id) {		
		System.out.println(id);
		this.sistema = new Sistema("D:\\outN."+id);
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String RespuestaPorDefecto() {
		return "<html><title>Servicio REST</title>"
				+"<body align='center'>"
				+"<h1> Bienvenidos </h1>"
				+"<h2> Servicio REST </h2><body></html>" ;
	}

	@GET
	@Path("/listarVariables")
	@Produces({MediaType.APPLICATION_JSON})
	 public String[] listarVariables() {		
		 return sistema.consultarVariables();		 
	 }
	
	@GET
	@Path("/mostarTabla")
	@Produces({MediaType.APPLICATION_JSON})
	 public String[][] mostarTabla() {
		sistema.consultarVariables();
		return sistema.consultarDatosVariables();	 
	 }
	
	@GET
	@Path("/resultadoDeclaracion")
	@Produces({MediaType.APPLICATION_JSON})
	 public String mostrarResultadoDeclaracion(@QueryParam("seleccion")  String seleccion) {
		try {
			return sistema.consultarItemDeclaracion(seleccion);
		} catch (NullPointerException e) {
			return "No se encontraron resultados";
		}catch (Exception e) {
			return "Error "+e.toString();
		}
		
	 }
	
	@GET
	@Path("/resultadoNCML")
	@Produces({MediaType.APPLICATION_JSON})
	 public String mostrarResultadoNcML(@QueryParam("seleccion") String seleccion) {
		try {
		 return sistema.consultarItemNcML(seleccion);
		} catch (NullPointerException e) {
			return "No se encontraron resultados";
		}catch (Exception e) {
			return "Error "+e.toString();
		}
	 }
	
	@GET
	@Path("/resultadoDatos")
	@Produces({MediaType.APPLICATION_JSON})
	 public String mostrarResultadoDatos(@QueryParam("seleccion") String seleccion) {
		try {
		 return sistema.consultarItemDatosVariable(seleccion);
		} catch (NullPointerException e) {
			return "No se encontraron resultados";
		}catch (Exception e) {
			return "Error "+e.toString();
		}
	 }
	
	@GET
	@Path("/resultadoVariablesTodo")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Variable> variablesTodas(){
		sistema.consultarVariables();
		return sistema.getVariables();
	}



}
