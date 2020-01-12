package packTest;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import packGestores.SGBD;

public class TiendaTest {

	@Test
	public void getPuntosUsuario() {
		try {
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELEC `puntos` FROM Partida WHERE nombreUsuario = 'test'");
			int puntos = rs.getInt("puntos");
			assertEquals(puntos, 5);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void getEscudos() {
		try {
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT `puntos`, `cuantos`, `nombreArma` FROM partida NATURAL JOIN armamentoJugador WHERE nombreJugador = 'test' AND nombreArma = 'escudos'");
			int armas = rs.getInt("cuantos");
			assertEquals(armas, 14);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getMisiles() {
		try {
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT `puntos`, `cuantos`, `nombreArma` FROM partida NATURAL JOIN armamentoJugador WHERE nombreJugador = 'test' AND nombreArma = 'misiles'");
			int armas = rs.getInt("cuantos");
			assertEquals(armas, 17);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void getMisilesEO() {
		try {
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT `puntos`, `cuantos`, `nombreArma` FROM partida NATURAL JOIN armamentoJugador WHERE nombreJugador = 'test' AND nombreArma = 'misilesEO'");
			int armas = rs.getInt("cuantos");
			assertEquals(armas, 9);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getMisilesNS() {
		try {
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT `puntos`, `cuantos`, `nombreArma` FROM partida NATURAL JOIN armamentoJugador WHERE nombreJugador = 'test' AND nombreArma = 'misilesNS'");
			int armas = rs.getInt("cuantos");
			assertEquals(armas, 8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getMisilesBOOM() {
		try {
			ResultSet rs = SGBD.getSGBD().execSQLSelect("SELECT `puntos`, `cuantos`, `nombreArma` FROM partida NATURAL JOIN armamentoJugador WHERE nombreJugador = 'test' AND nombreArma = 'misilesBOOM'");
			int armas = rs.getInt("cuantos");
			assertEquals(armas, 9);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
