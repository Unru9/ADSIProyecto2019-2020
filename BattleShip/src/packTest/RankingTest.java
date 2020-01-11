package packTest;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import packGestores.GestorBD;
import packGestores.SGBD;
import packModelo.Battleship;
import packModelo.packJugador.Usuario;
import packVista.Ranking;

public class RankingTest {
	
	@Test
	public void testNoResultados() {
		try {
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT nombreUsuario,puntos FROM Partida WHERE nombreUsuario='test';");
			Boolean next = rs.next();
			assertEquals(next, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Test Caso 1 elemento*/
	@Test
	public void testUnResultado() {
		try {
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 100);");
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT nombreUsuario,puntos FROM Partida WHERE nombreUsuario='test';");
			rs.next();
			String nameTest = rs.getString("nombreUsuario");
			int points = rs.getInt("puntos");
			assertEquals(nameTest,"test");
			assertEquals(points, 100);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clean();
	}
	
	/*Test Caso multiples elemento*/
	@Test
	public void testMulResultado() {
		insert2Table();
		try {
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT nombreUsuario,puntos FROM Partida WHERE nombreUsuario='test';");
			Boolean next = rs.next();
			while(next) {
				String nameTest = rs.getString("nombreUsuario");
				int points = rs.getInt("puntos");
				assertEquals(nameTest,"test");
				assertEquals(next, true);
				next = rs.next();
			}
			assertEquals(next, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clean();
	}
	//Test caso usuario no existe ventana
	@Test
	public void testVentanaRanking() {
		insert2Table();
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		Ranking vistaRanking = new Ranking("PersonalGeneral");
		vistaRanking.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clean();
	}
	
	
	
	
	
	
	
	
	public void insert2Table() {
		try {
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 100);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 98);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 96);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
	
	public void clean() {
		try {
			SGBD.getSGBD().execSQL("DELETE FROM Usuario WHERE nombreUsuario='test';");
			SGBD.getSGBD().execSQL("DELETE FROM Partida WHERE nombreUsuario='test';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
}
