package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Rankings extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnPersonal;
	private JButton btnGlobal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rankings frame = new Rankings();
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
	public Rankings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnGlobal = new JButton("Global");
		btnGlobal.setBounds(185, 85, 114, 25);
		btnGlobal.addActionListener(this);
		contentPane.add(btnGlobal);
		
		btnPersonal = new JButton("Personal");
		btnPersonal.setEnabled(false);
		btnPersonal.setBounds(185, 150, 114, 25);
		btnPersonal.addActionListener(this);
		contentPane.add(btnPersonal);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPersonal) {
			String[] opciones = {"General", "Por Niveles"};
			JOptionPane.showOptionDialog(null, "Elige ranking", "Ranking Personal", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opciones, null);
		}
		if (e.getSource() == btnGlobal) {
			String[] opciones = {"General", "Por Niveles"};
			JOptionPane.showOptionDialog(null, "Elige ranking", "Ranking Global", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opciones, null);
		}
	}
}
