package packGestores;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class compartirResultadosRRSS {

	private static compartirResultadosRRSS RRSS;

	public static compartirResultadosRRSS getcompartirResultadosRRSS() {
		if (RRSS == null) {
			RRSS = new compartirResultadosRRSS();

		}
		return RRSS;
	}
	


	public void compartirTwitter(String nombreUsuario, int ptosPartida) throws IOException, URISyntaxException {
		String TITULO = nombreUsuario + "%20" +"%20PUNTOS%20TOTALES%20OBTENIDOS=" + ptosPartida;
		URI myURI = new URI("http://twitter.com/share?text=" + TITULO + "&url=[URLcodificada]");
		System.out.println(myURI);
		Desktop.getDesktop().browse(myURI);
	}
	
	public void compartirFacebook(String nombreUsuario, int ptosPartida) throws IOException, URISyntaxException {
		//http://www.facebook.com/sharer.php?url=[URLcodificada]
		
		String TITULO = nombreUsuario + "%20" + "%20PUNTOS%20TOTALES%20OBTENIDOS%3D" + ptosPartida;
		URI myURI = new URI("");
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