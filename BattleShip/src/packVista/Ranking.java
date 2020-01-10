package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTable;

public class Ranking extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking("title");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public Ranking(String string) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("nombre");
		table = new JTable(model);
		contentPane.add(table, BorderLayout.CENTER);
		System.out.println(string);
		switch(string) {
		case "PersonalGeneral":
			cargarPersonaGlobal(model);
			break;
		case "PersonalPor Niveles":
			break;
		case "GlobalGeneral":
			break;
		case "GlobalPor Niveles":
			break;
		}
			
	}

	private void cargarPersonaGlobal(DefaultTableModel model) {
		// TODO Auto-generated method stub
		System.out.println("entra");
		String[] headers= {"nombre", "puntos"};
		String[][] data= {{"test","1"},{"test","2"}};
		
	}

}
