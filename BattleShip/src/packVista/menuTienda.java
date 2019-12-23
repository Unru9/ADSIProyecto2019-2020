
package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packControlador.ContTienda.gestorTienda;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class menuTienda extends JFrame {

	private JPanel contentPane;
	private static menuTienda miMenuTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuTienda frame = new menuTienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static menuTienda getMenuTienda() throws SQLException {
		if(miMenuTienda == null) {
			miMenuTienda = new menuTienda();
		}
		return miMenuTienda;
	}
	
	public String getEmail() {
		return gestorTienda.getMiGestorTeinda().getEmail();
	}
	
	public ResultSet getPuntosUsuario() throws SQLException {		
		ResultSet rs = gestorTienda.getMiGestorTeinda().getPuntosUsuario();
		return rs;
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	private menuTienda() throws SQLException {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPuntosJugador = new JLabel("PUNTOS JUGADOR: ");
		
		
		JLabel lblX = new JLabel("");
		
		lblX.setText(getPuntosUsuario().toString());
				
		
		JButton btnNewButton = new JButton("ESCUDO");
		
		JButton btnMisil = new JButton("MISIL");
		
		JButton btnMisilEo = new JButton("MISIL EO");
		
		JButton btnMisilNs = new JButton("MISIL NS");
		
		JButton btnMisilBoom = new JButton("MISIL BOOM");
		
		JLabel lblPt = new JLabel("25 PT");
		
		JLabel lblPt_1 = new JLabel("10 PT");
		
		JLabel lblPt_2 = new JLabel("45 PT");
		
		JLabel lblPt_3 = new JLabel("45 PT");
		
		JLabel lblPt_4 = new JLabel("90 PT");
		
		JLabel lblTienda = new JLabel("TIENDA");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
			
		
				
		JButton btnSalir = new JButton("ATRAS");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPrincipal.getMiPantallaPrincipal().setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addComponent(lblTienda, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(btnMisilEo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(btnMisilNs, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(btnMisilBoom, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(btnMisil, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPt_4)
								.addComponent(lblPt_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPt_2))
							.addGap(83)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPuntosJugador)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblPt_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTienda, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPt))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMisil)
						.addComponent(lblPt_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPuntosJugador, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMisilEo)
								.addComponent(lblPt_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSalir)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMisilNs)
								.addComponent(lblPt_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMisilBoom)
								.addComponent(lblPt_4))))
					.addGap(42))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
