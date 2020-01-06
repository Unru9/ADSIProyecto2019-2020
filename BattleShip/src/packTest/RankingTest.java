package packTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import packGestores.GestorBD;
import packGestores.SGBD;

public class RankingTest {

	@Test
	public void test() {
		insert2Table();
		clean();
	}
	
	public void insert2Table() {
		try {
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 100);");
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
