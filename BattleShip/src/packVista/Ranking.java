package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import packModelo.Battleship;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Ranking extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
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
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel bottom = new JPanel();
		contentPane.add(bottom, BorderLayout.SOUTH);
		
		JButton btnOki = new JButton("OKI");
		bottom.add(btnOki);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		
		switch(string) {
		case "PersonalGeneral":
			System.out.println("entra");
			cargarPersonaGeneral();
			break;
		case "PersonalPor Niveles":
			cargarPersonaPorNivel();
			break;
		case "GlobalGeneral":
			cargarGlobalGeneral();
			break;
		case "GlobalPor Niveles":
			cargarGlobalPorNivel();
			break;
		}
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
			
	}

	private void cargarGlobalPorNivel() {
		// TODO Auto-generated method stub
		JSONObject json=Battleship.getBattleship().rankingGlobalPorNiv();
	}

	private void cargarGlobalGeneral() {
		// TODO Auto-generated method stub
		JSONObject json=Battleship.getBattleship().rankingGlobalGeneral();
	}

	private void cargarPersonaPorNivel() {
		// TODO Auto-generated method stub
		JSONObject json=Battleship.getBattleship().rankingUsuarioPorNiv();
	}

	private void cargarPersonaGeneral() {
		// TODO Auto-generated method stub
		JSONArray json=Battleship.getBattleship().rankingUsuarioGeneral();
		model.addColumn("nombre");
		model.addColumn("puntos");
		for (int i = 0; i<=json.length();i++) {
			try {
				JSONObject jsonO = (JSONObject) json.get(i);
				model.addRow(new Object[] {jsonO.get("nombre"),jsonO.getInt("puntos")});
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
	}

}
