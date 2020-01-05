package packGestores;

import org.json.JSONObject;

import packModelo.packJugador.Usuario;

public class GRanking {
	
	private static GRanking miGRanking;
	
	private GRanking() {
		
	}
	
	public static GRanking getGRankoing() {
		return miGRanking;
	}
	
	public JSONObject rankingUsuarioGeneral(Usuario pUsuario) {
		//TODO
		String elNombre = pUsuario.getNombreUsuario();
		JSONObject json1 = new JSONObject();
		return json1;
	}

	public JSONObject rankingUsuarioPorNiv(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject rankingGlobalGeneral() {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject rankingGlobalPorNiv() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
