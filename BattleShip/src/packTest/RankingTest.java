<<<<<<< HEAD
package packTest;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import packGestores.GestorBD;
import packGestores.SGBD;
import packModelo.Battleship;
import packModelo.packJugador.Usuario;
import packVista.Ranking;

public class RankingTest {
	
	@Before
	public void init() {
		clean();
	}
	
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
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 'facil', 100);");
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
	
	//Test caso ventanas vacias
	@Test
	public void testVentanasVacias() {
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		try {
			Ranking vistaRanking = new Ranking("PersonalGeneral");
			vistaRanking.setVisible(true);
			Thread.sleep(2000);

			vistaRanking = new Ranking("PersonalPor Niveles");
			vistaRanking.setVisible(true);
			Thread.sleep(2000);

			vistaRanking = new Ranking("GlobalGeneral");
			vistaRanking.setVisible(true);
			Thread.sleep(2000);

			vistaRanking = new Ranking("GlobalPor Niveles");
			vistaRanking.setVisible(true);
			Thread.sleep(2000);
			vistaRanking.dispose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Test caso ranking usuario general
	@Test
	public void testVentanaRankingUsuGen() {
		insert2Table();
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		Ranking vistaRanking = new Ranking("PersonalGeneral");
		vistaRanking.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vistaRanking.setVisible(false);
		clean();
	}
	//Test ranking usuario por nivel
	@Test
	public void testVentanaRankingUsuPorNivel() {
		insert2Table();
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		Ranking vistaRanking = new Ranking("PersonalPor Niveles");
		vistaRanking.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vistaRanking.setVisible(false);
		clean();
	}
	//Test ranking global general
	@Test
	public void testVentanaRankingGloGen() {
		insert2Table();
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		Ranking vistaRanking = new Ranking("GlobalGeneral");
		vistaRanking.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vistaRanking.setVisible(false);
		clean();
	}
	//Test ranking global por nivel
	@Test
	public void testVentanaRankingGloPorNivel() {
		insert2Table();
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		Ranking vistaRanking = new Ranking("GlobalPor Niveles");
		vistaRanking.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vistaRanking.setVisible(false);
		clean();
	}
	
	
	
	
	
	
	
	public void insert2Table() {
		try {
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 'facil', 100);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 'normal', 98);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 'facil', 96);");
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test2');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test2', 'dificil', 96);");

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
			SGBD.getSGBD().execSQL("DELETE FROM Usuario WHERE nombreUsuario='test2';");
			SGBD.getSGBD().execSQL("DELETE FROM Partida WHERE nombreUsuario='test2';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
}
=======
package packTest;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import packGestores.GestorBD;
import packGestores.SGBD;
import packModelo.Battleship;
import packModelo.packJugador.Usuario;
import packVista.Ranking;

public class RankingTest {
	
	@Before
	public void init() {
		clean();
	}
	
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
	
	//Test caso ventanas vacias
	@Test
	public void testVentanasVacias() {
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		try {
			Ranking vistaRanking = new Ranking("PersonalGeneral");
			vistaRanking.setVisible(true);
			Thread.sleep(2000);

			vistaRanking = new Ranking("PersonalPor Niveles");
			vistaRanking.setVisible(true);
			Thread.sleep(2000);

			vistaRanking = new Ranking("GlobalGeneral");
			vistaRanking.setVisible(true);
			Thread.sleep(2000);

			vistaRanking = new Ranking("GlobalPor Niveles");
			vistaRanking.setVisible(true);
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Test caso ranking usuario general
	@Test
	public void testVentanaRankingUsuGen() {
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
		vistaRanking.setVisible(false);
		clean();
	}
	//Test ranking usuario por nivel
	@Test
	public void testVentanaRankingUsuPorNivel() {
		insert2Table();
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		Ranking vistaRanking = new Ranking("PersonalPor Niveles");
		vistaRanking.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vistaRanking.setVisible(false);
		clean();
	}
	//Test ranking global general
	@Test
	public void testVentanaRankingGloGen() {
		insert2Table();
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		Ranking vistaRanking = new Ranking("GlobalGeneral");
		vistaRanking.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vistaRanking.setVisible(false);
		clean();
	}
	//Test ranking global por nivel
	@Test
	public void testVentanaRankingGloPorNivel() {
		insert2Table();
		Usuario test=new Usuario();
		test.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(test);
		Ranking vistaRanking = new Ranking("GlobalPor Niveles");
		vistaRanking.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vistaRanking.setVisible(false);
		clean();
	}
	
	
	
	
	
	
	
	public void insert2Table() {
		try {
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 'facil', 100);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 'normal', 98);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 'facil', 96);");
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test2');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test2', 'dificil', 96);");

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
			SGBD.getSGBD().execSQL("DELETE FROM Usuario WHERE nombreUsuario='test2';");
			SGBD.getSGBD().execSQL("DELETE FROM Partida WHERE nombreUsuario='test2';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
}
>>>>>>> branch 'master' of https://github.com/Unru9/ADSIProyecto2019-2020.git
