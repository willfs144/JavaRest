package  co.udistrital.ws.rest.persistencia;

import java.io.IOException;
import java.util.List;

import ucar.ma2.Array;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

public class VariableDAO {
	
	private NetcdfFile netcdArchivo;
	
	
	public VariableDAO(NetcdfFile ncfile) {
		this.netcdArchivo = ncfile;
	}

	public List<Variable> consultar() {
		return netcdArchivo.getVariables();
	}
	
	public String buscarDatos(String varName) {		
		try {
			this.netcdArchivo = NetcdfFile.open(this.netcdArchivo.getLocation());
			Variable v = netcdArchivo.findVariable(varName);
			 if (null == v) return null;
			 Array data = v.read();
			 return data.toString();
		} catch (IOException e) {
			 System.out.println(varName+"  "+e);
		}
		return "";
	}
	
	public int [] buscarForma(String nombre) {
		return  netcdArchivo.findVariable(nombre).getShapeAll();
	}
	
	public String buscarTipoDato(String nombre) {
		return  netcdArchivo.findVariable(nombre).getDataType().name();
	}
	
	
	public String buscarDimension(String nombre) {
		return  netcdArchivo.findVariable(nombre).getDimensionsString();
	}
	
	public String buscarDescripcion(String nombre) {
		return  netcdArchivo.findVariable(nombre).getDescription();
	}
	
	public String buscarGrupo(String nombre) {
		return  netcdArchivo.findVariable(nombre).getGroup().getDODSName();
	}
	
	public String buscarUnidades(String nombre) {
		return  netcdArchivo.findVariable(nombre).getUnitsString();
	}
	
	public String buscarDeclaracion(String nombre) {
		return  netcdArchivo.findVariable(nombre).toString();
	}
	
	public String buscarNcML(String nombre) {
		try {
			return netcdArchivo.toNcML(this.netcdArchivo.getLocation().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
