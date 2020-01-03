package packGestores;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

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
		//AQUI FALTA EL EMAIL XK NO ESTA IDENTIFICADO String email = getEmail();
		ResultSet rs = GestorBD.getMiGestorBD().execSQLSelect("SELECT precio, escudos, misiles, misilesEO, misilesBOOM, misilesNS FROM armamento WHERE emailUsuario = 'lerulolu@gmail.com'");
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
}
