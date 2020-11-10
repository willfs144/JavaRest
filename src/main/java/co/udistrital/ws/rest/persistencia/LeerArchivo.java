package  co.udistrital.ws.rest.persistencia;

import java.io.IOException;
import ucar.nc2.NetcdfFile;

public class LeerArchivo {
	NetcdfFile netcdArchivo;;
	
	
	public LeerArchivo(String nombreArchivo) {	
		System.out.println(nombreArchivo);
		  this.netcdArchivo = null;
		  try {
		    netcdArchivo = NetcdfFile.open(nombreArchivo);
		    }
		  catch (IOException ioe) {
		    System.out.println("trying to open " + nombreArchivo.toString()+"  "+ioe);}
		  finally { 
		    if (null != netcdArchivo) { 
		    	try {
		    		netcdArchivo.close();}
		    	catch (IOException ioe) {
		    		System.out.println("trying to close " + nombreArchivo.toString()+"  "+ioe);}
		    }
		  }		
	}
	
	public NetcdfFile getNcfile() {
		return netcdArchivo;
	}

}
