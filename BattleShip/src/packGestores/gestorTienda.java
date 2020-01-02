package packGestores;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import packModelo.Battleship;
import packVista.menuTienda;
import packVista.ventanaErrorPuntosInsuficintes;

public class gestorTienda {
	
	private static gestorTienda miGestorTienda;
	
	public static gestorTienda getMiGestorTeinda() {
		if(miGestorTienda == null) {
			miGestorTienda = new gestorTienda();
		}
		return miGestorTienda;
	}
	
	private gestorTienda() {
		
	}
	
	
	/*public String getEmail() {
		return Battleship.getBattleship().getUsuario().getEmail();
	}*/
	
	
	public JSONArray getPuntosUsuarioYStock() throws Exception {
		
		JSONArray datos = null;
		GestorBD.getMiGestorBD().conectar();
		String email = Battleship.getBattleship().getEmail();
		//AQUI FALTA EL EMAIL XK NO ESTA IDENTIFICADO String email = getEmail();
		ResultSet rs = GestorBD.getMiGestorBD().execSQLSelect("SELECT puntos, escudos, misiles, misilesEO, misilesBOOM, misilesNS FROM armamento WHERE emailUsuario = '"+email+"'");
		if(!rs.next()) {
			JOptionPane.showMessageDialog(null, "No tienes puntos acumulados", "Error", JOptionPane.ERROR_MESSAGE);
    		return null;
		}
		else {

			datos = crearJSON(rs);
			System.out.println("AQUI"+datos.length());
    		
        	GestorBD.getMiGestorBD().cerrarConexion();
 
        	return datos;
		}
	}
		
    //CREACION DEL JSON PARA ENVIAR LOS DATOS A LA INTERFAZ
    private JSONArray crearJSON (ResultSet resultSet) throws Exception{
		 
    	JSONArray jsonArray = new JSONArray();
    	int total_columns = resultSet.getMetaData().getColumnCount();
    	JSONObject objFirst = new JSONObject();
    	
    	for (int i = 0; i < total_columns; i++) {
    		objFirst.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
		}
    	
    	jsonArray.put(objFirst);
    	
    	while (resultSet.next()) {
    		
    		JSONObject obj = new JSONObject();
    		for (int i = 0; i < total_columns; i++) {
    			obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
			}
    		jsonArray.put(obj);
		}
    	return jsonArray;
	 }
    
    public int getPuntosUsuario() throws Exception {
		
		JSONArray datos = null;
		int puntos = 0;
		String email = Battleship.getBattleship().getEmail();
		GestorBD.getMiGestorBD().conectar();
		//AQUI FALTA EL EMAIL XK NO ESTA IDENTIFICADO String email = getEmail();
		ResultSet rs = GestorBD.getMiGestorBD().execSQLSelect("SELECT puntos FROM armamento WHERE emailUsuario = '"+email+"'");
		if(!rs.next()) {
			JOptionPane.showMessageDialog(null, "No tienes puntos acumulados", "Error", JOptionPane.ERROR_MESSAGE);
    		return 0;
		}
		else {

			datos = crearJSON(rs);
			
			for (int i = 0; i < datos.length(); i++) 
			{
				org.json.JSONObject one = datos.getJSONObject(i);
				puntos = one.getInt("puntos");
			}
    		
		}

		return puntos;
		
	}
    
    public void comprarArma(String pArma) throws Exception {
    	
    	GestorBD.getMiGestorBD().conectar();
    	int puntos = getPuntosUsuario();
    	String email = Battleship.getBattleship().getEmail();
    	if(pArma == "escudo") {
    		if(puntos >= 25) {
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET escudos = escudos + 1 WHERE emailUsuario = '"+email+"'");
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET puntos = puntos - 25 WHERE emailUsuario = '"+email+"'");
   
    		}
    		else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
    	}else if(pArma == "misil") {
    		if(puntos >= 10) {
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET misiles = misiles + 1 WHERE emailUsuario = '"+email+"'");
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET puntos = puntos - 10 WHERE emailUsuario = '"+email+"'");
    		}else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
    	}else if(pArma == "misilEO") {
    		if(puntos >= 45) {
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET misilesEO = misilesEO + 1 WHERE emailUsuario = '"+email+"'");
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET puntos = puntos - 45 WHERE emailUsuario = 'lerulolu@gmail.com'");
    		}else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
    	}else if(pArma == "misilNS") {
    		if(puntos >= 45) {
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET misilesNS = misilesNS + 1 WHERE emailUsuario = '"+email+"'");
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET puntos = puntos - 45 WHERE emailUsuario = '"+email+"'");
    		}else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
 
    	}else if(pArma == "misilBOOM") {
    		if(puntos >= 90) {
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET misilesBOOM = misilesBOOM + 1 WHERE emailUsuario = '"+email+"'");
    			GestorBD.getMiGestorBD().execSQL("UPDATE armamento SET puntos = puntos - 90 WHERE emailUsuario = '"+email+"'");
    		}else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
    	}
    	GestorBD.getMiGestorBD().cerrarConexion();
    	
    }
    
}