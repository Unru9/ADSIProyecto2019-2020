package packVista;


import java.awt.Desktop;
import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import org.json.JSONObject;

import packGestores.GCompartirResultadosRRSS;
import packModelo.Battleship;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaJuegoPerdedor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuegoPerdedor frame = new VentanaJuegoPerdedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaJuegoPerdedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setTitle("Compartir Resultados");
		setSize(600, 200);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//TÍTULO PRINCIPAL
		JLabel título = new JLabel(" ¡INTÉNTALO OTRA VEZ, HAS PERDIDO ! ");
		título.setBounds(190, 23, 250, 14);
		
		//COMPARTIR TWITTER
		ImageIcon TwitterButtonIcon = new ImageIcon(VentanaJuegoPerdedor.class.getResource("/packImages/twitter.png"));
		Image img1 = TwitterButtonIcon.getImage();
		Image img2= img1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon x= new ImageIcon(img2);
		
		JButton TwitterButton = new JButton("Twitter", x);
		
		TwitterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCompartirResultadosRRSS RRSS=GCompartirResultadosRRSS.getcompartirResultadosRRSS();
				Battleship BattleShip= Battleship.getBattleship();
				JSONObject res;
				try {
					res=BattleShip.obtDatos();
					RRSS.compartirTwitter(res.getString("nombreUsuario"), res.getInt("puntos"),150);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		TwitterButton.setBounds(47, 63, 150, 40);
		TwitterButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		
		//COMPARTIR WHATSAPPS
		ImageIcon WhastAppButtonIcon = new ImageIcon(VentanaJuegoPerdedor.class.getResource("/packImages/whatsapp.png"));
		Image img3 = WhastAppButtonIcon.getImage();
		Image img4= img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon y= new ImageIcon(img4);	
		JButton WhatsAppButton = new JButton("WhatsApp", y);
		
		WhatsAppButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCompartirResultadosRRSS RRSS=GCompartirResultadosRRSS.getcompartirResultadosRRSS();
				Battleship BattleShip= Battleship.getBattleship();
				JSONObject res;
				try {
					res=BattleShip.obtDatos();
					RRSS.compartirWhatsApp(res.getString("nombreUsuario"), res.getInt("puntos"));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		WhatsAppButton.setBounds(224, 63, 150, 40);
		WhatsAppButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		
		
		//COMPARTIR REDDIT
		ImageIcon RedditButtonIcon = new ImageIcon(VentanaJuegoPerdedor.class.getResource("/packImages/reddit.png"));
		Image img5 = RedditButtonIcon.getImage();
		Image img6= img5.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon z= new ImageIcon(img6);	
		JButton RedditButton = new JButton("Reddit", z);
				
		RedditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCompartirResultadosRRSS RRSS=GCompartirResultadosRRSS.getcompartirResultadosRRSS();
				Battleship BattleShip= Battleship.getBattleship();
				JSONObject res;
				try {
					res=BattleShip.obtDatos();
					RRSS.compartirReddit(res.getString("nombreUsuario"), res.getInt("puntos"));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		RedditButton.setBounds(401, 63, 150, 40);
		RedditButton.setHorizontalTextPosition(SwingConstants.RIGHT);
				
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		getContentPane().add(título);
		getContentPane().add(TwitterButton);
		getContentPane().add(WhatsAppButton);
		getContentPane().add(RedditButton);
		
	}
}