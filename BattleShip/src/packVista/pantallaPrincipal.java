package packVista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import packControlador.ContPantallaPrincipal.controladorPantPrincipal;
import packGestores.GestorNivel;
import packModelo.Battleship;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pantallaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static pantallaPrincipal miPantallaPrincipal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaPrincipal frame = new pantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static pantallaPrincipal getMiPantallaPrincipal() {
		if(miPantallaPrincipal == null) {
			miPantallaPrincipal = new pantallaPrincipal();
		}
		return miPantallaPrincipal;
	}

	/**
	 * Create the frame.
	 */
	private pantallaPrincipal() {
		setTitle("Menu Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 8, 610, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(pantallaPrincipal.class.getResource("/packImages/Battleship.jpeg")));
		
		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Battleship.getBattleship().inicializar();
				String[] options = {"F\u00e1cil", "Normal", "Dif\u00edcil"};
				int option = JOptionPane.showOptionDialog(contentPane, "Elija la opci\u00f3n deseada:", "Nivel de dificultad", JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE, new ImageIcon(), options, options[0]);
				GestorNivel.getGestorNivel().modificarDatosNivel(option);
				
				Inicio.getInicio().setVisible(true);
				Inicio.getInicio().empezar();
				dispose();
			}
		});
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.addActionListener(new controladorPantPrincipal());
		btnTienda.setActionCommand("tienda");
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new controladorPantPrincipal());
		btnRanking.setActionCommand("ranking");
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new controladorPantPrincipal());
		btnSalir.setActionCommand("salir");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(btnNuevaPartida)
							.addGap(30)
							.addComponent(btnTienda, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(btnRanking, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTienda)
						.addComponent(btnSalir)
						.addComponent(btnNuevaPartida)
						.addComponent(btnRanking))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
