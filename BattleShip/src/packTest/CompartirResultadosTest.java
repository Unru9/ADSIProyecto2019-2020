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
	
	/*Test Caso Compartir Twitter*/
	@Test
	public void testCompartirResultadosTwitter() throws IOException, URISyntaxException, SQLException {
		insert();
		
		try {
			int puntosHistoricos=0;
			int numPremios=0;
			
			//CREACIÓN USUARIO
			Usuario u = new Usuario();
			u.setNombreUsuario("test1");
			assertEquals(u.getNombreUsuario(), "test1");
			assertEquals(u.getDinero(), 150);
			u.comprarArma(0);
			assertEquals(u.getDinero(), 125);
			u.comprarArma(1);
			assertEquals(u.getDinero(), 115);
			
			ResultSet rt= SGBD.getSGBD().execSQLSelect("SELECT COUNT(*) as numPremios FROM Logro INNER JOIN LogrosJugador WHERE Logro.nombre=LogrosJugador.nombreLogro AND LogrosJugador.nombreUsuario='test1' AND Logro.completado='true'");
			rt.next();
			numPremios= rt.getInt("numPremios");
			assertEquals(numPremios,1);

			rt.close();
			
			//PUNTOS HISTÓRICOS
			ResultSet rt1= SGBD.getSGBD().execSQLSelect("SELECT SUM(puntos) as sumPuntos FROM Partida where nombreUsuario='test1'");
			rt1.next();
			puntosHistoricos= rt1.getInt("sumPuntos");
			assertEquals(puntosHistoricos,250);
			rt1.close();
			clean();
			
			GCompartirResultadosRRSS.getcompartirResultadosRRSS().compartirTwitter(u.getNombreUsuario(), u.getDinero(),numPremios,puntosHistoricos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
	
	/*Test Caso Compartir WhatsApp*/
	@Test
	public void testCompartirResultadosWhatsApp() throws IOException, URISyntaxException, SQLException {
		insert();
		try {
			int puntosHistoricos=0;
			int numPremios=0;
			
			//CREACIÓN USUARIO
			Usuario u = new Usuario();
			u.setNombreUsuario("test2");
			assertEquals(u.getNombreUsuario(), "test2");
			assertEquals(u.getDinero(), 150);
			u.comprarArma(0);
			assertEquals(u.getDinero(), 125);	
			
			ResultSet rt= SGBD.getSGBD().execSQLSelect("SELECT COUNT(*) as numPremios FROM Logro INNER JOIN LogrosJugador WHERE Logro.nombre=LogrosJugador.nombreLogro AND LogrosJugador.nombreUsuario='test2' AND Logro.completado='true'");
			rt.next();
			numPremios= rt.getInt("numPremios");
			assertEquals(numPremios,3);
			rt.close();
			
			//PUNTOS HISTÓRICOS
			ResultSet rt1= SGBD.getSGBD().execSQLSelect("SELECT SUM(puntos) as sumPuntos FROM Partida where nombreUsuario='test2'");
			rt1.next();
			puntosHistoricos= rt1.getInt("sumPuntos");
			assertEquals(puntosHistoricos,300);
			rt1.close();
			clean();
			
			GCompartirResultadosRRSS.getcompartirResultadosRRSS().compartirWhatsApp(u.getNombreUsuario(), u.getDinero(),numPremios,puntosHistoricos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
	
	/*Test Caso Compartir Reddit*/
	@Test
	public void testCompartirResultadosReddit() throws IOException, URISyntaxException, SQLException {
		insert();
		
		try {
			int puntosHistoricos=0;
			int numPremios=0;
			
			//CREACIÓN USUARIO
			Usuario u = new Usuario();
			u.setNombreUsuario("test3");
			assertEquals(u.getNombreUsuario(), "test3");
			assertEquals(u.getDinero(), 150);
			u.comprarArma(0);
			assertEquals(u.getDinero(), 125);
			u.comprarArma(1);
			assertEquals(u.getDinero(), 115);
			u.comprarArma(2);
			assertEquals(u.getDinero(), 70);
			u.comprarArma(3);
			assertEquals(u.getDinero(), 25);
			
			ResultSet rt= SGBD.getSGBD().execSQLSelect("SELECT COUNT(*) as numPremios FROM Logro INNER JOIN LogrosJugador WHERE Logro.nombre=LogrosJugador.nombreLogro AND LogrosJugador.nombreUsuario='test3' AND Logro.completado='true'");
			rt.next();
			numPremios= rt.getInt("numPremios");
			assertEquals(numPremios,2);
			rt.close();
			
			//PUNTOS HISTÓRICOS
			ResultSet rt1= SGBD.getSGBD().execSQLSelect("SELECT SUM(puntos) as sumPuntos FROM Partida where nombreUsuario='test3'");
			rt1.next();
			puntosHistoricos= rt1.getInt("sumPuntos");
			assertEquals(puntosHistoricos,100);
			rt1.close();
			clean();
			
			GCompartirResultadosRRSS.getcompartirResultadosRRSS().compartirReddit(u.getNombreUsuario(), u.getDinero(),numPremios,puntosHistoricos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
	
	
	public void clean() {
		try {
			
			//BORRAR DATOS TWITTER
			SGBD.getSGBD().execSQL("DELETE FROM Usuario WHERE nombreUsuario='test1';");
			SGBD.getSGBD().execSQL("DELETE FROM Partida WHERE nombreUsuario='test1';");
			SGBD.getSGBD().execSQL("DELETE FROM Logro WHERE nombre='nombreLogroEjemplo1';");
			SGBD.getSGBD().execSQL("DELETE FROM LogrosJugador WHERE nombreUsuario='test1';");
			
			//BORRAR DATOS WHATSAPP
			SGBD.getSGBD().execSQL("DELETE FROM Usuario WHERE nombreUsuario='test2';");
			SGBD.getSGBD().execSQL("DELETE FROM Partida WHERE nombreUsuario='test2';");
			SGBD.getSGBD().execSQL("DELETE FROM Logro WHERE nombre='nombreLogroEjemplo2';");
			SGBD.getSGBD().execSQL("DELETE FROM LogrosJugador WHERE nombreUsuario='test2';");
			
			//BORRAR DATOS REDDIT
			SGBD.getSGBD().execSQL("DELETE FROM Usuario WHERE nombreUsuario='test3';");
			SGBD.getSGBD().execSQL("DELETE FROM Partida WHERE nombreUsuario='test3';");
			SGBD.getSGBD().execSQL("DELETE FROM Logro WHERE nombre='nombreLogroEjemplo3';");
			SGBD.getSGBD().execSQL("DELETE FROM LogrosJugador WHERE nombreUsuario='test3';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
	
	//INSERCIÓN Y CREACIÓN DE TABLAS
	public void insert() {
		try {
			//INSERCIÓN Y CREACIÓN DE TABLAS TWITTER
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test1');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario,nivel,puntos) VALUES('test1',1,100);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario,nivel,puntos) VALUES('test1',1,150);");
			SGBD.getSGBD().execSQL("INSERT INTO Logro(nombre,premio,completado) VALUES('nombreLogroEjemplo1','2','true');");
			SGBD.getSGBD().execSQL("INSERT INTO LogrosJugador(nombreUsuario,nombreLogro) VALUES('test1','nombreLogroEjemplo1');");
			
			//INSERCIÓN Y CREACIÓN DE TABLAS WHATSAPP
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test2');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario,nivel,puntos) VALUES('test2',1,100);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario,nivel,puntos) VALUES('test2',1,150);");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario,nivel,puntos) VALUES('test2',1,50);");
			SGBD.getSGBD().execSQL("INSERT INTO Logro(nombre,premio,completado) VALUES('nombreLogroEjemplo2','1','true');");
			SGBD.getSGBD().execSQL("INSERT INTO Logro(nombre,premio,completado) VALUES('nombreLogroEjemplo2','2','true');");
			SGBD.getSGBD().execSQL("INSERT INTO Logro(nombre,premio,completado) VALUES('nombreLogroEjemplo2','3','true');");
			SGBD.getSGBD().execSQL("INSERT INTO LogrosJugador(nombreUsuario,nombreLogro) VALUES('test2','nombreLogroEjemplo2');");
			
			//INSERCIÓN Y CREACIÓN DE TABLAS REDDIT
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombreUsuario) VALUES('test3');");
			SGBD.getSGBD().execSQL("INSERT INTO Partida(nombreUsuario,nivel,puntos) VALUES('test3',3,100);");
			SGBD.getSGBD().execSQL("INSERT INTO Logro(nombre,premio,completado) VALUES('nombreLogroEjemplo3','1','true');");
			SGBD.getSGBD().execSQL("INSERT INTO Logro(nombre,premio,completado) VALUES('nombreLogroEjemplo3','2','true');");
			SGBD.getSGBD().execSQL("INSERT INTO LogrosJugador(nombreUsuario,nombreLogro) VALUES('test3','nombreLogroEjemplo3');");
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar datos en bd");
			e.printStackTrace();
		}
	}
}
