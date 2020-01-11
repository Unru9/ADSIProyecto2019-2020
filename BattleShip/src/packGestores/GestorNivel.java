package packGestores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import packModelo.DatosJuego;

public class GestorNivel {

	private static GestorNivel miGestorNivel;

	private GestorNivel() {
	}

	public static GestorNivel getGestorNivel() {
		if (miGestorNivel == null)
			miGestorNivel = new GestorNivel();
		return miGestorNivel;
	}
	
	/*public void insertarDatos() {
		try {
			GestorBD.getMiGestorBD().execSQL("INSERT INTO nivel VALUES nivel=facil, tamanoTablero=8, dinero=180;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	public void modificarDatosNivel(int pNivel) {
		String nivel;
		if (pNivel == 0)
			nivel = "facil";
		else if (pNivel == 1)
			nivel = "normal";
		else
			nivel = "dificil";

		try {
			
			HashMap<String, Integer> armas = new HashMap<String, Integer>();
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT "
					 + "tamanioTablero, dinero, nombreArma, cuantos "
					 + "FROM Nivel NATURAL JOIN ArmamentoNivel "
					 + "WHERE nivel='" + nivel + "';");
			
			int tablero = 0;
			int dinero = 0;
			
			while (rs.next()) {
				/*System.out.println(rs.getString("tamanioTablero"));
				System.out.println(rs.getString("dinero"));
				System.out.println(rs.getString("nombreArma"));
				System.out.println(rs.getInt("cuantos"));
				*/
				
				armas.put(rs.getString("nombreArma"), rs.getInt("cuantos"));
				tablero = rs.getInt("tamanioTablero");
				dinero = rs.getInt("dinero");
			}
			
			DatosJuego.modificarDatosJuego(armas, tablero, dinero);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void actualizarFacil() {
		try {
			
			SGBD.getSGBD().execSQL("UPDATE Nivel SET tamanioTablero=9 WHERE nivel='facil';");
	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
