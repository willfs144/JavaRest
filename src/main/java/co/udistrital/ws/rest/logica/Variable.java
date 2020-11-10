package co.udistrital.ws.rest.logica;

import java.util.List;

import co.udistrital.ws.rest.persistencia.LeerArchivo;
import co.udistrital.ws.rest.persistencia.VariableDAO;

public class Variable {
	
	private String nombre;
	private int [] forma;
	private String tipoDato;
	
	private Dimension dimension;
	private Atributo atributo;
	
	private LeerArchivo leerArchivo;
	private VariableDAO variableDAO;
			
	public Variable(String rutaArchivo) {
		this.leerArchivo = new LeerArchivo(rutaArchivo);
		this.variableDAO= new VariableDAO(leerArchivo.getNcfile());	
	}
	
	
	public Variable() {
	}

	public List consultar() {			
		return variableDAO.consultar();	
	}

	public String buscarDatos(String filtro) {
		return variableDAO.buscarDatos(filtro);
	}
	
	
	
	public int [] buscarForma(String nombre) {
		return  variableDAO.buscarForma(nombre);
	}
	
	public String buscarTipoDato(String nombre) {
		return  variableDAO.buscarTipoDato(nombre);
	}
	
	
	public String buscarDimension(String nombre) {
		return  variableDAO.buscarDimension(nombre);
	}
	
	public String buscarDescripcion(String nombre) {
		return  variableDAO.buscarDescripcion(nombre);
	}
	
	public String buscarGrupo(String nombre) {
		return  variableDAO.buscarGrupo(nombre);
	}
	
	public String buscarUnidades(String nombre) {
		return  variableDAO.buscarUnidades(nombre);
	}
	
	public String buscarDeclaracion(String nombre) {
		return variableDAO.buscarDeclaracion(nombre);
	}

	public String buscarNcML(String seleccion) {
		return variableDAO.buscarNcML(seleccion);
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getForma() {
		return forma;
	}

	public void setForma(int[] forma) {
		this.forma = forma;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
		
	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Atributo getAtributo() {
		return atributo;
	}


	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}


	

	

}
