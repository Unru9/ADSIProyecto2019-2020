package packModelo;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import packGestores.GCompartirResultadosRRSS;
import packGestores.GRanking;
import packGestores.GestorBD;
import packGestores.SGBD;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.BarcoNoEncException;
import packModelo.packBarcos.BarcosFactory;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Ordenador;
import packModelo.packJugador.Usuario;

public class Battleship extends Observable {

	private static Battleship theBattleship;
	private Usuario usuario;
	private Ordenador ordenador;
	private boolean turno; // true = Usuario, false = Ordenador
	private boolean juegoFinalizado;
	private boolean avisar = true;

	private Battleship() {}

	public static Battleship getBattleship() {
		if (theBattleship == null) {
			theBattleship = new Battleship();
		}
		return theBattleship;
	}

	public void inicializar() {
		usuario = new Usuario();
		ordenador = new Ordenador();
		ordenador.colocarBarcosAleatorios();
		ordenador.imprimirTablero();
		turno = true;
		juegoFinalizado = false;
	}

	public void colocarBarcoUs(String pTipo, Coordenada pC, boolean pVertical) {
		Barco unBarco = BarcosFactory.getBarcoFactory().crearBarco(pTipo, pC, pVertical);
		usuario.anadirAdyacentesBarco(unBarco);
		usuario.colocarBarco(unBarco);
	}

	public boolean puedeColocar(String pTipo, Coordenada pC, boolean pVertical) {
		boolean puede = false;
		Barco unBarco = BarcosFactory.getBarcoFactory().crearBarco(pTipo, pC, pVertical);
		if (usuario.puedePonerUs(unBarco) && usuario.puedeColocar(unBarco)) {
			puede = true;
		}
		return puede;
	}

	public boolean getTurno() {
		return turno;
	}

	public void setTurno(boolean pTurno) throws BarcoNoEncException {
		turno = pTurno;
		if (!turno) {
			ordenador.jugar();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Ordenador getOrdenador() {
		return ordenador;
	}

	public void imprimirTableroUsuario() {
		usuario.imprimirTablero();
	}

	public boolean hasPerdido() {
		boolean perdido = false;
		if (ordenador.haGanado()) {
			juegoFinalizado = true;
			perdido = true;
		}
		return perdido;
	}

	public boolean hasGanado() {
		boolean ganado = false;
		if (usuario.haGanado()) {
			juegoFinalizado = true;
			ganado = true;
		}
		return ganado;
	}

	public boolean usarEscudo(Coordenada pCoordenada) {
		boolean puesto = false;
		if (usuario.ponerEscudo(pCoordenada)) {
			notificarEscudo(pCoordenada);
			puesto = true;
		}
		return puesto;
	}

	public void usarBomba(Coordenada pCoordenada) {
		usuario.usarBomba(pCoordenada);
	}

	public void usarMisil(Coordenada pCoordenada) {
		usuario.usarMisil(pCoordenada);
	}

	public void usarMisilNS(Coordenada pCoordenada) {
		usuario.usarMisilNS(pCoordenada);
	}

	public void usarMisilEO(Coordenada pCoordenada) {
		usuario.usarMisilEO(pCoordenada);
	}

	public void usarMisilBOOM(Coordenada pCoordenada) {
		usuario.usarMisilBOOM(pCoordenada);
	}

	public boolean puedeUsar(int pArma) {
		return usuario.puedeUsar(pArma);
	}

	public void moverRadar(Coordenada pCoordenada) {
		ordenador.moverRadar(pCoordenada);
	}

	public boolean usarRadar() {
		boolean usado = false;
		if (usuario.getRadar().puedeUsarRadar()) {
			ordenador.recibirEscaRadar();
			usuario.getRadar().restarUsoRadar();
			usado = true;
		}
		return usado;
	}

	private void notificarEscudo(Coordenada pCoordenada) {
		Barco barco;
		try {
			barco = usuario.getListaBarcos().buscarBarco(pCoordenada);
			String cambios = "escudo";
			for (Coordenada co : barco.getPosicion().getCoordenadas()) {
				cambios += ";" + co.getX() + "," + co.getY();
			}
			setChanged();
			notifyObservers(cambios);
		} catch (BarcoNoEncException e) {}
	}

	public boolean hayBarcoUsu(Coordenada pC) {
		return usuario.hayBarco(pC);
	}

	public boolean todosBarcosUsPuestos() {
		return usuario.getListaBarcos().numBarcos() >= DatosJuego.NUM_BARCOS;
	}

	public int getDineroUsuario() {
		return usuario.getDinero();
	}

	public boolean comprarArma(int pArma) {
		return usuario.comprarArma(pArma);
	}

	public void ponerBarcosUsuario() {
		usuario.colocarBarcosAleatorios();
	}

	public boolean juegoFinalizado() {
		return juegoFinalizado;
	}

	public boolean getAvisar() {
		return avisar;
	}

	public void noAvisarMas() {
		avisar = false;
	}

	public boolean repararBarco(Coordenada pCoordenada) {
		boolean reparado = false;
		if (usuario.repararBarco(pCoordenada)) {
			try {
				ordenador.usuarioReparado(pCoordenada, usuario.getListaBarcos().buscarBarco(pCoordenada));
			} catch (BarcoNoEncException e) {}
			notificarReparar(pCoordenada);
			reparado = true;
		}
		return reparado;
	}

	private void notificarReparar(Coordenada pCoordenada) {
		Barco barco;
		try {
			barco = usuario.getListaBarcos().buscarBarco(pCoordenada);
			String cambios = "reparar";
			for (Coordenada co : barco.getPosicion().getCoordenadas()) {
				cambios += ";" + co.getX() + "," + co.getY();
			}
			setChanged();
			notifyObservers(cambios);
		} catch (BarcoNoEncException e) {}
	}
	
	public JSONArray rankingUsuarioGeneral() {
		return GRanking.getGRankoing().rankingUsuarioGeneral(usuario);
	}
	
	public JSONArray rankingUsuarioPorNiv() {
		return GRanking.getGRankoing().rankingUsuarioPorNiv(usuario);
	}
	
	public JSONArray rankingGlobalGeneral() {
		return GRanking.getGRankoing().rankingGlobalGeneral();
	}
	
	public JSONArray rankingGlobalPorNiv() {
		return GRanking.getGRankoing().rankingGlobalPorNiv();
	}
	
	public JSONObject  obtDatos() throws SQLException, JSONException{
		JSONObject obj = new JSONObject();;
		GestorBD BD = GestorBD.getMiGestorBD();
		int puntosHistoricos=0;
		int numPremios=0;
		
		if( juegoFinalizado()){
			String nombreUsuario= this.usuario.getNombreUsuario();
			int ptosPartida= this.usuario.getDinero();
			obj.put("nombreUsuario", nombreUsuario);
			obj.put("puntos",ptosPartida);
			
			// OBT NUM PREMIOS
			ResultSet rt= BD.execSQLSelect("SELECT premio FROM Logro INNER JOIN LogrosJugador WHERE LogrosJugador.nombreUsuario=%nombreUsuario% AND Logro.completado='true'");
			rt.next();
				numPremios= rt.getInt("premio");
				
			rt.close();
			obj.put("numPremios", numPremios);
			
			//OBT PUNTOS HIST�RICOS
			ResultSet rt1= BD.execSQLSelect("SELECT SUM(puntos) as sumPuntos FROM Partida where nombreUsuario=%nombreUsuario%");
			rt1.next();
				puntosHistoricos= rt1.getInt("sumPuntos");
			rt1.close();
			obj.put("puntosHist�ricos", puntosHistoricos);
		}
		
		return obj;
		
	}
	
	public void setUsuario(Usuario pUsuario) {
		this.usuario=pUsuario;
	}
}