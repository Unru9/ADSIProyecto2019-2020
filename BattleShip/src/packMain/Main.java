package packMain;

import java.sql.SQLException;

import packGestores.GestorBD;
import packModelo.Battleship;
import packVista.Inicio;

public class Main {

	public static void main(String[] args) throws SQLException {
		Battleship.getBattleship().inicializar();
		Inicio.getInicio().empezar();
	}
}
