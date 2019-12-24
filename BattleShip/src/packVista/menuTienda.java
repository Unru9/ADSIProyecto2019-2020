
package packVista;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONException;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class menuTienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	
	public menuTienda(JSONArray pDatos) throws SQLException, JSONException {
		
		for (int i = 0; i < pDatos.length(); i++) 
		{
			org.json.JSONObject one = pDatos.getJSONObject(i);
			int puntos = one.getInt("puntos");
			System.out.println("AQUI"+puntos);
			
			if(puntos <= 0) {
				ventanaErrorNoPuntos vt = new ventanaErrorNoPuntos();
				vt.setVisible(true);
				dispose();
			}
			else {
				
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				setTitle("Tienda");
				setBounds(100, 100, 564, 479);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				
				JLabel lblNewLabel = new JLabel("TIENDA");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
				
				JLabel lblNombreDelArma = new JLabel("Nombre del Arma");
				lblNombreDelArma.setForeground(Color.BLACK);
				lblNombreDelArma.setBackground(Color.WHITE);
				lblNombreDelArma.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JLabel lblNewLabel_1 = new JLabel("Precio del Arma");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JLabel lblNewLabel_2 = new JLabel("Cantidad en tu Stock");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JButton btnNewButton = new JButton("ESCUDO");
				
				JLabel lblNewLabel_3 = new JLabel("25 Puntos");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				
				JSeparator separator = new JSeparator();
				
				JButton btnNewButton_1 = new JButton("MISIL");
				
				JLabel lblNewLabel_5 = new JLabel("10 Puntos");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel lblNewLabel_6 = new JLabel("");
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
				
				JSeparator separator_1 = new JSeparator();
				
				JSeparator separator_2 = new JSeparator();
				
				JButton btnNewButton_2 = new JButton("MISIL EO");
				
				JSeparator separator_3 = new JSeparator();
				
				JButton btnNewButton_3 = new JButton("MISIL NS");
				
				JSeparator separator_4 = new JSeparator();
				
				JButton btnNewButton_4 = new JButton("MISIL BOOM");
				
				JSeparator separator_5 = new JSeparator();
				
				JLabel lblNewLabel_7 = new JLabel("PUNTOS DEL JUGADOR");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel ptosJugador = new JLabel("");
				ptosJugador.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				//METER EL JSON DE LOS PUNTOS EN LA PANTALLA
				String ptos = ""+puntos;
				ptosJugador.setText(ptos);
				
				JButton btnAtras = new JButton("ATRAS");
				btnAtras.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {

						pantallaPrincipal.getMiPantallaPrincipal().setVisible(true);
						dispose();
					}
				});
				
				JLabel lblPuntos = new JLabel("45 Puntos");
				lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
				lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel label = new JLabel("45 Puntos");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel lblPuntos_1 = new JLabel("90 Puntos");
				lblPuntos_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblPuntos_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel label_1 = new JLabel("");
				label_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel label_2 = new JLabel("");
				label_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel label_3 = new JLabel("");
				label_3.setHorizontalAlignment(SwingConstants.CENTER);
				label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				GroupLayout groupLayout = new GroupLayout(getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNombreDelArma, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(47)
													.addComponent(lblNewLabel_1))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(40)
													.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
												.addComponent(lblNewLabel_2)))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(separator, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
											.addGap(46)
											.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
											.addGap(40)
											.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
										.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
										.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
											.addGap(44)
											.addComponent(lblPuntos_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
											.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
											.addGap(45)
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
											.addGap(46)
											.addComponent(lblPuntos, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(ptosJugador, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
											.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(186)
									.addComponent(lblNewLabel)))
							.addGap(24))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel)
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreDelArma)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(10)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnNewButton)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnNewButton_2)
									.addComponent(lblPuntos, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnNewButton_3)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnNewButton_4)
									.addComponent(lblPuntos_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(ptosJugador, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(26)
									.addComponent(btnAtras)))
							.addContainerGap(35, Short.MAX_VALUE))
				);
				getContentPane().setLayout(groupLayout);
				
				
			}
				
		}
		
		
	}
}
