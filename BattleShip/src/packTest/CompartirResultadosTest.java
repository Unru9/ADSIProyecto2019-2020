package packTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import packGestores.GCompartirResultadosRRSS;
import packGestores.GestorBD;
import packGestores.SGBD;
import packModelo.packJugador.Jugador;
import packModelo.packJugador.Usuario;

public class CompartirResultadosTest {

	@Test
	public void test() throws IOException, URISyntaxException {
		testCompartirResultados();
		clean();
	}
	
	public void testCompartirResultados() throws IOException, URISyntaxException {
		try {
			int puntosHistoricos=0;
			Usuario u = new Usuario();
			u.setNombreUsuario("test");
			assertEquals(u.getNombreUsuario(), "test");
			assertEquals(u.getDinero(), 150);
			u.comprarArma(0);
			assertEquals(u.getDinero(), 125);
			
			
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 150);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 125);");
			ResultSet rt= SGBD.getSGBD().execSQLSelect("SELECT SUM (puntos) as sumPuntos FROM Partida WHERE nombreUsuario='test'");
			while(rt.next()){
				puntosHistoricos= rt.getInt("sumPuntos");
				assertEquals(puntosHistoricos,275);
				//System.out.println("PUNTOS BD "+ puntosHistoricos);
				
			}
			rt.close();
			GCompartirResultadosRRSS.getcompartirResultadosRRSS().compartirTwitter(u.getNombreUsuario(), u.getDinero(),puntosHistoricos);
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
