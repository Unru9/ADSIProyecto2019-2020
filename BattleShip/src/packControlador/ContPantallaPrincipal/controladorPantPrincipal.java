package packControlador.ContPantallaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import packVista.Ranking;
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
			
		}else if(action.equals("ranking")){
			String[] options = {"Global", "Personal"};
			String[] options2 = {"General", "Por Niveles"};
			int selection = JOptionPane.showOptionDialog(null, null, "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
			int selection2=-1;
			if (selection==1) {
				selection2 = JOptionPane.showOptionDialog(null, "Elige ranking", "Ranking Personal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
			}else if(selection==0){
				selection2 = JOptionPane.showOptionDialog(null, "Elige ranking", "Ranking Global", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
			}
			Ranking ranking = new Ranking(options[selection]+options2[selection2]);
			ranking.setVisible(true);
		}
		
	}

}
