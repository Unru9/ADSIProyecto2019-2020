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
			int numPremios=0;
			//CREACIÓN USUARIO
			Usuario u = new Usuario();
			u.setNombreUsuario("test");
			assertEquals(u.getNombreUsuario(), "test");
			assertEquals(u.getDinero(), 150);
			u.comprarArma(0);
			assertEquals(u.getDinero(), 125);
			
			//CREACIÓN USUARIO
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test');");
			
			//NUM PREMIOS
			SGBD.getSGBD().execSQL("INSERT INTO Logro(nombre,premio,completado) VALUES('nombreLogroEjemplo','3','true');");
			SGBD.getSGBD().execSQL("INSERT INTO LogrosJugador(nombreUsuario,nombreLogro) VALUES('test','nombreLogroEjemplo');");
			
			ResultSet rt= SGBD.getSGBD().execSQLSelect("SELECT premio FROM Logro INNER JOIN LogrosJugador WHERE Logro.nombre=LogrosJugador.nombreLogro AND LogrosJugador.nombreUsuario='test' AND Logro.completado='true'");
			while(rt.next()){
				numPremios= rt.getInt("premio");
				assertEquals(numPremios,3);
				//System.out.println("PUNTOS BD "+ puntosHistoricos);
				
			}
			rt.close();
			
			//PUNTOS HISTÓRICOS
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 150);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario, nivel,puntos) VALUES ('test', 1, 125);");
			ResultSet rt1= SGBD.getSGBD().execSQLSelect("SELECT SUM (puntos) as sumPuntos FROM Partida WHERE nombreUsuario='test'");
			while(rt1.next()){
				puntosHistoricos= rt1.getInt("sumPuntos");
				assertEquals(puntosHistoricos,275);
				//System.out.println("PUNTOS BD "+ puntosHistoricos);
				
			}
			rt.close();
			GCompartirResultadosRRSS.getcompartirResultadosRRSS().compartirTwitter(u.getNombreUsuario(), u.getDinero(),numPremios,puntosHistoricos);
			GCompartirResultadosRRSS.getcompartirResultadosRRSS().compartirWhatsApp(u.getNombreUsuario(), u.getDinero(),numPremios,puntosHistoricos);
			GCompartirResultadosRRSS.getcompartirResultadosRRSS().compartirReddit(u.getNombreUsuario(), u.getDinero(),numPremios,puntosHistoricos);
		
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
			SGBD.getSGBD().execSQL("DELETE FROM Logro WHERE nombre='nombreLogroEjemplo';");
			SGBD.getSGBD().execSQL("DELETE FROM LogrosJugador WHERE nombreUsuario='test';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
}
