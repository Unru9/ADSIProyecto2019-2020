package packControlador.ContPantallaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packVista.menuTienda;
import packVista.pantallaPrincipal;

public class controladorPantPrincipal implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String action = e.getActionCommand();
		
		if(action.equals("tienda")) {
			try {
				menuTienda.getMiMenuTienda().setVisible(true);
				pantallaPrincipal.getMiPantallaPrincipal().setVisible(false);;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(action.equals("salir")) {
			pantallaPrincipal.getMiPantallaPrincipal().dispose();
		}
		
	}

}
