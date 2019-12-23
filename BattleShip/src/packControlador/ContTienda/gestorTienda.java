package packControlador.ContTienda;

import packModelo.Battleship;

public class gestorTienda {
	
	private static gestorTienda miGestorTienda;
	
	public static gestorTienda getMiGestorTeinda() {
		if(miGestorTienda == null) {
			miGestorTienda = new gestorTienda();
		}
		return miGestorTienda;
	}
	
	private gestorTienda() {
		
	}
	
	public String getEmail() {
		return Battleship.getBattleship().getUsuario().getEmail();
	}
	
	/*public int getPuntosUsuario() {
		
	}*/

}
