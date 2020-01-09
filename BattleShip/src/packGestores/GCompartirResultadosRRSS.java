package packGestores;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GCompartirResultadosRRSS {

	private static GCompartirResultadosRRSS RRSS;

	public static GCompartirResultadosRRSS getcompartirResultadosRRSS() {
		if (RRSS == null) {
			RRSS = new GCompartirResultadosRRSS();

		}
		return RRSS;
	}
	


	public void compartirTwitter(String nombreUsuario, int ptosPartida, int ptosTotales) throws IOException, URISyntaxException {
		String TITULO = nombreUsuario+"--%20BattleShip2019-2020%3A%20PUNTOS%20PARTIDA%3D" + ptosPartida +".%20PUNTUACIÓN%20HISTÓRICA%3D" + ptosTotales;
		URI myURI = new URI("http://twitter.com/share?text=" + TITULO + "&url=[URLcodificada]");
		System.out.println(myURI);
		Desktop.getDesktop().browse(myURI);
	}
	
	public void compartirWhatsApp(String nombreUsuario, int ptosPartida) throws IOException, URISyntaxException {
		//https://api.whatsapp.com/send?text=HOLA
		
		String TITULO = nombreUsuario+"%20BattleShip%3A%20PUNTOS%20PARTIDA%3D" + ptosPartida;
		URI myURI = new URI("https://api.whatsapp.com/send?text="+TITULO);
		System.out.println(myURI);
		Desktop.getDesktop().browse(myURI);
	}

	public void compartirReddit(String nombreUsuario, int ptosPartida) throws IOException, URISyntaxException {
		//http://www.reddit.com/submit?url=[URLcodificada]
		
		String TITULO = nombreUsuario + "%20" + "%20PUNTOS%20TOTALES%20OBTENIDO%3D" + ptosPartida;
		URI myURI = new URI("http://reddit.com//r/java/submit?title=RESULTADOS%20BATTLESHIP&url=" + TITULO + "");
		System.out.println(myURI);
		Desktop.getDesktop().browse(myURI);
	}

}