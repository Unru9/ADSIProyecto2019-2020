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
			System.out.println("entra PersonalGeneral");
			cargarPersonaGeneral();
			break;
		case "PersonalPor Niveles":
			System.out.println("entra PersonalPor Niveles");
			cargarPersonaPorNivel();
			break;
		case "GlobalGeneral":
			cargarGlobalGeneral();
			System.out.println("entra GlobalGeneral");
			break;
		case "GlobalPor Niveles":
			cargarGlobalPorNivel();
			System.out.println("entra GlobalPor Niveles");
			break;
		}
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
			
	}

	private void cargarGlobalPorNivel() {
		// TODO Auto-generated method stub
		JSONArray json=Battleship.getBattleship().rankingGlobalPorNiv();
		model.addColumn("nombre");
		model.addColumn("puntos facil");
		model.addColumn("nombre");
		model.addColumn("puntos normal");
		model.addColumn("nombre");
		model.addColumn("puntos dificil");
		int facil=0;
		int normal=0;
		int dificil=0;
		int row=-1;
		for (int i = 0; i<json.length();i++) {
			try {
				JSONObject jsonO = (JSONObject) json.get(i);
				String nivel = jsonO.getString("nivel");
				if(row<facil || row<normal || row<dificil) {
					model.addRow(new Object[] {});
					row++;
				}
				if(nivel.equals("facil")) {
					model.setValueAt(jsonO.getString("nombre"), facil, 0);
					model.setValueAt(jsonO.getInt("puntos"), facil, 1);
					facil++;
				}else if(nivel.equals("normal")) {
					model.setValueAt(jsonO.getString("nombre"), normal, 2);
					model.setValueAt(jsonO.getInt("puntos"), normal, 3);
					normal++;
				}else if(nivel.equals("dificil")) {
					model.setValueAt(jsonO.getString("nombre"), dificil, 4);
					model.setValueAt(jsonO.getInt("puntos"), dificil, 5);
					dificil++;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

	private void cargarGlobalGeneral() {
		// TODO Auto-generated method stub
		JSONArray json=Battleship.getBattleship().rankingGlobalGeneral();
		model.addColumn("nombre");
		model.addColumn("puntos");
		for (int i = 0; i<json.length();i++) {
			try {
				JSONObject jsonO = (JSONObject) json.get(i);
				model.addRow(new Object[] {jsonO.get("nombre"),jsonO.getInt("puntos")});
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

	private void cargarPersonaPorNivel() {
		// TODO Auto-generated method stub
		JSONArray json=Battleship.getBattleship().rankingUsuarioPorNiv();
		model.addColumn("nombre");
		model.addColumn("puntos facil");
		model.addColumn("nombre");
		model.addColumn("puntos normal");
		model.addColumn("nombre");
		model.addColumn("puntos dificil");
		int facil=0;
		int normal=0;
		int dificil=0;
		int row=-1;
		for (int i = 0; i<json.length();i++) {
			try {
				JSONObject jsonO = (JSONObject) json.get(i);
				String nivel = jsonO.getString("nivel");
				if(row<facil || row<normal || row<dificil) {
					model.addRow(new Object[] {});
					row++;
				}
				if(nivel.equals("facil")) {
					model.setValueAt(jsonO.getString("nombre"), facil, 0);
					model.setValueAt(jsonO.getInt("puntos"), facil, 1);
					facil++;
				}else if(nivel.equals("normal")) {
					model.setValueAt(jsonO.getString("nombre"), normal, 2);
					model.setValueAt(jsonO.getInt("puntos"), normal, 3);
					normal++;
				}else if(nivel.equals("dificil")) {
					model.setValueAt(jsonO.getString("nombre"), dificil, 4);
					model.setValueAt(jsonO.getInt("puntos"), dificil, 5);
					dificil++;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

	private void cargarPersonaGeneral() {
		// TODO Auto-generated method stub
		JSONArray json=Battleship.getBattleship().rankingUsuarioGeneral();
		model.addColumn("nombre");
		model.addColumn("puntos");
		for (int i = 0; i<json.length();i++) {
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
