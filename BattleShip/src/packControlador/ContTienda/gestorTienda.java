package packControlador.ContTienda;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import packGestores.GestorBD;
import packModelo.Battleship;

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
	
	public String getEmail() {
		return Battleship.getBattleship().getUsuario().getEmail();
	}
	
	public ResultSet getPuntosUsuario() throws SQLException {
		String email = getEmail();
		String url = "SELECT puntos FROM Usuario WHERE emailUsuario = "+email+"";
		ResultSet rs = GestorBD.getMiGestorBD().execSQLSelect(url);
		return rs;
	}

}
