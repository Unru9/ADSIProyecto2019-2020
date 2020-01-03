
package packVista;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;

import packControlador.ContTienda.controladorTienda;
import packGestores.gestorTienda;

public class menuTienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static menuTienda miMenuTienda;
	private JLabel escudo;
	private JLabel misil;
	private JLabel misilEO;
	private JLabel misilNS;
	private JLabel misilBOOM;
	private JLabel puntosJug;
	
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	
	public static menuTienda getMiMenuTienda() throws Exception {
		// TODO Auto-generated constructor stub
		if(miMenuTienda == null) {
			miMenuTienda = new menuTienda();
		}
		return miMenuTienda;
	}
	
	private menuTienda() throws Exception {
		
		JSONArray pDatos = gestorTienda.getMiGestorTeinda().getPuntosUsuarioYStock();
		setTitle("Tienda");
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("TIENDA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTipoDeArma = new JLabel("Tipo de Arma");
		lblTipoDeArma.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPrecioDeArma = new JLabel("Precio de Arma");
		lblPrecioDeArma.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioDeArma.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCantidadEnTu = new JLabel("Cantidad en tu Stock");
		lblCantidadEnTu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadEnTu.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JSeparator separator = new JSeparator();
		
		JButton btnEscudo = new JButton("ESCUDO");
		btnEscudo.addActionListener(new controladorTienda());
		btnEscudo.setActionCommand("escudo");
		
		JLabel lblNewLabel_1 = new JLabel("25");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		escudo = new JLabel("");
		escudo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		escudo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator_1 = new JSeparator();
		
		JButton btnMisil = new JButton("MISIL");
		btnMisil.addActionListener(new controladorTienda());
		btnMisil.setActionCommand("misil");
		
		JLabel label = new JLabel("10");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		misil = new JLabel("");
		misil.setHorizontalAlignment(SwingConstants.CENTER);
		misil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSeparator separator_2 = new JSeparator();
		
		JButton btnMisilEo = new JButton("MISIL EO");
		btnMisilEo.addActionListener(new controladorTienda());
		btnMisilEo.setActionCommand("misilEO");
		
		JLabel label_1 = new JLabel("45");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		misilEO = new JLabel("");
		misilEO.setHorizontalAlignment(SwingConstants.CENTER);
		misilEO.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSeparator separator_3 = new JSeparator();
		
		JButton btnMisilNs = new JButton("MISIL NS");
		btnMisilNs.addActionListener(new controladorTienda());
		btnMisilNs.setActionCommand("misilNS");
		
		JLabel label_2 = new JLabel("45");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		misilNS = new JLabel("");
		misilNS.setHorizontalAlignment(SwingConstants.CENTER);
		misilNS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSeparator separator_4 = new JSeparator();
		
		JButton btnMisilBoom = new JButton("MISIL BOOM");
		btnMisilBoom.addActionListener(new controladorTienda());
		btnMisilBoom.setActionCommand("misilBOOM");
		
		btnMisilBoom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_3 = new JLabel("90");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		misilBOOM = new JLabel("");
		misilBOOM.setHorizontalAlignment(SwingConstants.CENTER);
		misilBOOM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSeparator separator_5 = new JSeparator();
		
		JLabel lblNewLabel_2 = new JLabel("PUNTOS DEL JUGADOR");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		puntosJug = new JLabel("");
		puntosJug.setHorizontalAlignment(SwingConstants.CENTER);
		puntosJug.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new controladorTienda());
		btnAtras.setActionCommand("atras");
		
		
		for (int i = 0; i < pDatos.length(); i++) 
		{
			org.json.JSONObject one = pDatos.getJSONObject(i);
			int puntos = one.getInt("puntos");
			int escudos = one.getInt("escudos");
			int misiles = one.getInt("misiles");
			int misilesEO = one.getInt("misileseo");
			int misilesNS = one.getInt("misilesns");
			int misilesBOOM = one.getInt("misilesboom");
			
			puntosJug.setText(""+puntos);
			escudo.setText(""+escudos);
			misil.setText(""+misiles);
			misilEO.setText(""+misilesEO);
			misilNS.setText(""+misilesNS);
			misilBOOM.setText(""+misilesBOOM);
			
		}
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnMisilBoom, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(100)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addGap(146)
								.addComponent(misilBOOM, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(97))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnMisilNs, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
										.addGap(99)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addGap(151)
										.addComponent(misilNS, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addGap(94))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnMisilEo, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
												.addGap(100)
												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
												.addGap(153)
												.addComponent(misilEO, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addGap(92))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
													.addContainerGap())
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnMisil, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
														.addGap(100)
														.addComponent(label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
														.addComponent(misil, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
														.addGap(93))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnEscudo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addGap(102)
														.addComponent(lblNewLabel_1)
														.addGap(151)
														.addComponent(escudo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(separator, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblTipoDeArma)
														.addGap(74)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblNewLabel)
																.addContainerGap())
															.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblPrecioDeArma, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
																.addGap(37)
																.addComponent(lblCantidadEnTu, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
																.addGap(35)))))))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(puntosJug, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeArma)
						.addComponent(lblPrecioDeArma, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidadEnTu, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(escudo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEscudo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnMisil)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(misil, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMisilEo)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(misilEO, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMisilNs)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(misilNS, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnMisilBoom, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(misilBOOM, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(puntosJug, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(btnAtras)))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		
	}
	

	public void actualizarDatos() throws Exception {
		
		JSONArray pData = gestorTienda.getMiGestorTeinda().getPuntosUsuarioYStock();
		
		for (int i = 0; i < pData.length(); i++) 
		{
			org.json.JSONObject one = pData.getJSONObject(i);
			int puntos = one.getInt("puntos");
			int escudos = one.getInt("escudos");
			int misiles = one.getInt("misiles");
			int misilesEO = one.getInt("misileseo");
			int misilesNS = one.getInt("misilesns");
			int misilesBOOM = one.getInt("misilesboom");
			
			puntosJug.setText(""+puntos);
			escudo.setText(""+escudos);
			misil.setText(""+misiles);
			misilEO.setText(""+misilesEO);
			misilNS.setText(""+misilesNS);
			misilBOOM.setText(""+misilesBOOM);
			
		}
	}
}
