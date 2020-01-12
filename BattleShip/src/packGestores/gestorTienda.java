package packGestores;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import packModelo.Battleship;
import packModelo.packJugador.Usuario;
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
	
	
	public JSONArray getPuntosUsuarioYStock() throws Exception {
		
		JSONArray datos = null;
		SGBD.getSGBD().conectar();
		Battleship.getBattleship().inicializar();
		String nombre = Battleship.getBattleship().getUsuario().getNombreUsuario();
		System.out.println("NOMRBE"+nombre);
		ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT `puntos`, `cuantos`, `nombreArma` FROM partida NATURAL JOIN armamentoJugador WHERE nombreJugador = '"+nombre+"'");
		if(!rs.next()) {
			JOptionPane.showMessageDialog(null, "No tienes puntos acumulados", "Error", JOptionPane.ERROR_MESSAGE);
    		return null;
		}
		else {
			
			datos = crearJSON(rs);
    		
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
		SGBD.getSGBD().conectar();
		Battleship.getBattleship().inicializar();
		String nombre = Battleship.getBattleship().getUsuario().getNombreUsuario();
		System.out.println(nombre);
		ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT puntos FROM partida WHERE nombreUsuario ='"+nombre+"'");
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
    	
    	SGBD.getSGBD().conectar();
    	int puntos = getPuntosUsuario();
    	Battleship.getBattleship().inicializar();
    	Usuario usu = Battleship.getBattleship().getUsuario();
    	String nombre = usu.getNombreUsuario();
    	if(pArma == "escudo") {
    		if(puntos >= 25) {
    			SGBD.getSGBD().execSQL("UPDATE armamentoJugador SET cuantos = cuantos + 1 WHERE nombreJugador = '"+nombre+"' AND nombreArma = 'escudos'");
    			SGBD.getSGBD().execSQL("UPDATE partida SET puntos = puntos - 25 WHERE nombreUsuario = '"+nombre+"'");
    		}
    		else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
    	}else if(pArma == "misil") {
    		if(puntos >= 10) {
    			SGBD.getSGBD().execSQL("UPDATE armamentoJugador SET cuantos = cuantos + 1 WHERE nombreJugador = '"+nombre+"' AND nombreArma = 'misiles'");
    			SGBD.getSGBD().execSQL("UPDATE partida SET puntos = puntos - 10 WHERE nombreUsuario = '"+nombre+"'");
    		}else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
    	}else if(pArma == "misilEO") {
    		if(puntos >= 45) {
    			SGBD.getSGBD().execSQL("UPDATE armamentoJugador SET cuantos = cuantos + 1 WHERE nombreJugador = '"+nombre+"' AND nombreArma = 'misilesEO'");
    			SGBD.getSGBD().execSQL("UPDATE partida SET puntos = puntos - 45 WHERE nombreUsuario = '"+nombre+"'");
    		}else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
    	}else if(pArma == "misilNS") {
    		if(puntos >= 45) {
    			SGBD.getSGBD().execSQL("UPDATE armamentoJugador SET cuantos = cuantos + 1 WHERE nombreJugador = '"+nombre+"' AND nombreArma = 'misilesNS'");
    			SGBD.getSGBD().execSQL("UPDATE partida SET puntos = puntos - 45 WHERE nombreUsuario = '"+nombre+"'");
    		}else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
 
    	}else if(pArma == "misilBOOM") {
    		if(puntos >= 90) {
    			SGBD.getSGBD().execSQL("UPDATE armamentoJugador SET cuantos = cuantos + 1 WHERE nombreJugador = '"+nombre+"' AND nombreArma = 'misilesBOOM'");
    			SGBD.getSGBD().execSQL("UPDATE partida SET puntos = puntos - 90 WHERE nombreUsuario = '"+nombre+"'");
    		}else {
    			ventanaErrorPuntosInsuficintes.getMiVentana().setVisible(true);
    			menuTienda.getMiMenuTienda().dispose();
    		}
    	}
    	SGBD.getSGBD().cerrarConexion();
    	
    }
}
