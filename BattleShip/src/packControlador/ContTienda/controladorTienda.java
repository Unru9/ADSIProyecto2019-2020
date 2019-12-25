package packControlador.ContTienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packGestores.gestorTienda;
import packVista.menuTienda;
import packVista.pantallaPrincipal;
import packVista.ventanaErrorPuntosInsuficintes;

public class controladorTienda implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String action = e.getActionCommand();
		
		if(action.equals("atras")) {
			try {
				menuTienda.getMiMenuTienda().dispose();
				pantallaPrincipal.getMiPantallaPrincipal().setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(action.equals("escudo")) {
			try {
				gestorTienda.getMiGestorTeinda().comprarArma("escudo");
				menuTienda.getMiMenuTienda().actualizarDatos();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(action.equals("misil")) {
			try {
				gestorTienda.getMiGestorTeinda().comprarArma("misil");
				menuTienda.getMiMenuTienda().actualizarDatos();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(action.equals("misilEO")) {
			try {
				gestorTienda.getMiGestorTeinda().comprarArma("misilEO");
				menuTienda.getMiMenuTienda().actualizarDatos();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}else if(action.equals("misilNS")) {
			try {
				gestorTienda.getMiGestorTeinda().comprarArma("misilNS");
				menuTienda.getMiMenuTienda().actualizarDatos();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(action.equals("misilBOOM")) {
			try {
				gestorTienda.getMiGestorTeinda().comprarArma("misilBOOM");
				menuTienda.getMiMenuTienda().actualizarDatos();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(action.equals("aceptarNP")) {
			ventanaErrorPuntosInsuficintes.getMiVentana().dispose();
			try {
				menuTienda.getMiMenuTienda().setVisible(true);
				menuTienda.getMiMenuTienda().actualizarDatos();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
