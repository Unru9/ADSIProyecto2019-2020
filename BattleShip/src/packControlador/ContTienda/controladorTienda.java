package packControlador.ContTienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packVista.menuTienda;
import packVista.pantallaPrincipal;

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
			
			
		}
		
	}

}
