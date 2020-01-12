package packTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.junit.Test;

import packGestores.SGBD;
import packModelo.Battleship;
import packModelo.packJugador.Usuario;

public class TestGuardarPuntos {

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		String ts = sdf.format(timestamp);
		try {
			SGBD.getSGBD().execSQL("INSERT INTO Partida VALUES('test','facil','"+ts+"',100);");
			SGBD.getSGBD().execSQL("DELETE FROM Partida WHERE nombreUsuario='test';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Usuario us = new Usuario();
		us.setNombreUsuario("test");
		Battleship.getBattleship().setUsuario(us);
		Battleship.getBattleship().guardarPuntos();
		try {
			SGBD.getSGBD().execSQL("DELETE FROM Partida WHERE nombreUsuario='test';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
