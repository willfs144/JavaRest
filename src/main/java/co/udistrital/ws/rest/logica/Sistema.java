package co.udistrital.ws.rest.logica;

import java.util.ArrayList;
import java.util.Arrays;

public class Sistema {
	
	private Variable variable;
	private ArrayList<Variable> variables;	
	
	public Sistema(String rutaArchivo) {
		this.variable = new Variable(rutaArchivo);
	}
	
		
	public String[] consultarVariables() {		
		ArrayList<ucar.nc2.Variable> lista = new ArrayList<ucar.nc2.Variable>(variable.consultar());
		String [] listaVariables = new String[lista.size()];
		this.variables = new ArrayList<Variable>();
		int index = 0;
		for (ucar.nc2.Variable elemento : lista) {
			listaVariables[index]= elemento.getFullName();
			
			Variable variable = crearRegistroVariable(elemento);			
			this.variables.add(variable);
			index++;			
		}
		return listaVariables;
	}


	private Variable crearRegistroVariable(ucar.nc2.Variable elemento) {
		
		Variable variableObj = new Variable();
		variableObj.setNombre(elemento.getFullName());
		variableObj.setForma(elemento.getShape());
		variableObj.setTipoDato(elemento.getDataType().toString());
		
		Dimension dimension = new Dimension();
		dimension.setLongitud(elemento.getDimensions().size());
		dimension.setNombre(elemento.getDimensionsString());
		
		Atributo atributo = new Atributo();
		atributo.setNombre(elemento.getAttributes().toString());
		atributo.setUnidades(variable.buscarUnidades(elemento.getFullName()));
		atributo.setDescripcion(variable.buscarDescripcion(elemento.getFullName()));
		atributo.setGrupo(variable.buscarGrupo(elemento.getFullName()));
		//atributo.setDatos(variable.buscarDatosIniciales(elemento.getFullName()));
		
		variableObj.setDimension(dimension);
		variableObj.setAtributo(atributo);
		
		return variableObj;
	}
	
	public String[][] consultarDatosVariables() {
		
		String [][] tabla = new String[this.variables.size()][7];
		
		for (int i = 0; i < tabla.length; i++) {
			Variable fila = this.variables.get(i);
			tabla[i][0] = fila.getNombre();
			tabla[i][1] = fila.getAtributo().getDescripcion();
			tabla[i][2] = fila.getDimension().getNombre();			
			tabla[i][3] = fila.getTipoDato();
			tabla[i][4] = fila.getAtributo().getGrupo();
			tabla[i][5] = Arrays.toString(fila.getForma());
			tabla[i][6] = fila.getAtributo().getUnidades();
		}
		return tabla;
	}


	public String consultarItemDeclaracion(String seleccion) {		
		return variable.buscarDeclaracion(seleccion);
	}
	public String consultarItemNcML(String seleccion) {
		return variable.buscarNcML(seleccion);
	}
	
	public String consultarItemDatosVariable(String seleccion) {		
		return variable.buscarDatos(seleccion).toString();		
	}
	
	public Variable getVariable() {
		return variable;
	}
	public void setVariable(Variable variable) {
		this.variable = variable;
	}
	public ArrayList<Variable> getVariables() {		
		return variables;
	}
	public void setVariables(ArrayList<Variable> variables) {
		this.variables = variables;
	}
	




	
	
	

}
