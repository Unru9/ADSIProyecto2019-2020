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

import packCompartirResultados.TwitterJ;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class VentanaJuegoGanador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuegoGanador frame = new VentanaJuegoGanador();
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
	public VentanaJuegoGanador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setTitle("Compartir Resultados");
		setSize(400, 200);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//TÍTULO PRINCIPAL
		JLabel título = new JLabel(" ¡ENHORABUENA, HAS GANADO ! ");
		título.setBounds(115, 23, 200, 14);
		
		//COMPARTIR TWITTER
		ImageIcon TwitterButtonIcon = new ImageIcon("./images/data/twitter.png");
		Image img1 = TwitterButtonIcon.getImage();
		Image img2= img1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon x= new ImageIcon(img2);
		
		JButton TwitterButton = new JButton("Twitter", x);
		
		TwitterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwitterJ twitter = TwitterJ.getTwitter();
				try {
					twitter.escribirTweet();
					Desktop.getDesktop().browse(new URI("https://www.twitter.com/adsi2019"));
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		TwitterButton.setBounds(47, 63, 150, 40);
		TwitterButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		
		//COMPARTIR FACEBOOK
		ImageIcon FacebookButtonIcon = new ImageIcon("./images/data/facebook.png");
		Image img3 = FacebookButtonIcon.getImage();
		Image img4= img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon y= new ImageIcon(img4);	
		JButton FacebookButton = new JButton("Facebook", y);
		
		FacebookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		FacebookButton.setBounds(224, 63, 150, 40);
		FacebookButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		getContentPane().add(título);
		getContentPane().add(TwitterButton);
		getContentPane().add(FacebookButton);
		
	}
}
