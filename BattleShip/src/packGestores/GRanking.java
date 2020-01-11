package packGestores;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import packModelo.packJugador.Usuario;

public class GRanking {
	 
	private static GRanking miGRanking;
	
	private GRanking() {
		
	}
	
	public static GRanking getGRankoing() {
		if(miGRanking == null) {
			miGRanking = new GRanking();
		}
		return miGRanking;
	}
	
	public JSONArray rankingUsuarioGeneral(Usuario pUsuario) {
		//TODO
		String elNombre = pUsuario.getNombreUsuario();
		JSONObject json1 = new JSONObject();
		String statement = "SELECT nombreUsuario,puntos FROM Partida WHERE nombreUsuario='"+elNombre+"' ORDER BY puntos DESC;";
		JSONArray partidas = new JSONArray();
		try {
			ResultSet sql = SGBD.getSGBD().execSQLSelect(statement);
			while(sql.next()) {
				JSONObject partida=new JSONObject();
				partida.put("nombre", sql.getString("nombreUsuario"));
				partida.put("puntos", sql.getInt("puntos"));
				partidas.put(partida);
			}
			
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partidas;
	}

	public JSONArray rankingUsuarioPorNiv(Usuario pUsuario) {
		// TODO Auto-generated method stub
		String elNombre = pUsuario.getNombreUsuario();
		JSONObject json1 = new JSONObject();
		String statement = "SELECT nombreUsuario,puntos,nivel FROM Partida WHERE nombreUsuario='"+elNombre+"' ORDER BY puntos DESC;";
		JSONArray partidas = new JSONArray();
		try {
			ResultSet sql = SGBD.getSGBD().execSQLSelect(statement);
			while(sql.next()) {
				JSONObject partida=new JSONObject();
				partida.put("nombre", sql.getString("nombreUsuario"));
				partida.put("puntos", sql.getInt("puntos"));
				partida.put("nivel", sql.getString("nivel"));
				partidas.put(partida);
			}
			
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partidas;
	}

	public JSONArray rankingGlobalGeneral() {
		JSONObject json1 = new JSONObject();
		String statement = "SELECT nombreUsuario,puntos FROM Partida ORDER BY puntos DESC;";
		JSONArray partidas = new JSONArray();
		try {
			ResultSet sql = SGBD.getSGBD().execSQLSelect(statement);
			sql.next();
			while(sql.next()) {
				JSONObject partida=new JSONObject();
				partida.put("nombre", sql.getString("nombreUsuario"));
				partida.put("puntos", sql.getInt("puntos"));
				partidas.put(partida);
			}
			
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partidas;
	}

	public JSONArray rankingGlobalPorNiv() {
		JSONObject json1 = new JSONObject();
		String statement = "SELECT nombreUsuario,puntos,nivel FROM Partida ORDER BY puntos DESC;";
		JSONArray partidas = new JSONArray();
		try {
			ResultSet sql = SGBD.getSGBD().execSQLSelect(statement);
			while(sql.next()) {
				JSONObject partida=new JSONObject();
				partida.put("nombre", sql.getString("nombreUsuario"));
				partida.put("puntos", sql.getInt("puntos"));
				partida.put("nivel", sql.getString("nivel"));
				partidas.put(partida);
			}
			
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partidas;
	}
	
}
