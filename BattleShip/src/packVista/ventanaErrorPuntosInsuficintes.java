package packVista;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import packControlador.ContTienda.controladorTienda;

public class ventanaErrorPuntosInsuficintes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ventanaErrorPuntosInsuficintes miVentana;
	
	public static ventanaErrorPuntosInsuficintes getMiVentana() {
		if(miVentana == null) {
			miVentana = new ventanaErrorPuntosInsuficintes();
		}
		return miVentana;
	}

	/**
	 * Create the frame.
	 */
	private ventanaErrorPuntosInsuficintes() {
		setTitle("Error");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventanaErrorPuntosInsuficintes.class.getResource("/packImages/Error.PNG")));
		
		JLabel lblNewLabel_1 = new JLabel("Lo sentimos.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new controladorTienda());
		btnAceptar.setActionCommand("aceptarNP");
		
		JLabel lblNoTienesPuntos = new JLabel("No tienes puntos suficientes para comprar este arma");
		lblNoTienesPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoTienesPuntos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(lblNewLabel)
							.addGap(39)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNoTienesPuntos, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(btnAceptar)))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(24, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(7))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblNewLabel_1)
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNoTienesPuntos, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAceptar)
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
	}

}