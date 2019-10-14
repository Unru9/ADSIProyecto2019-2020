package packCompartirResultados;
import java.util.HashMap;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
 
public class TwitterJ
{
	//atributos
	private static TwitterJ twitter;
		
	public static TwitterJ getTwitter() {
		if (twitter == null) {
			twitter = new TwitterJ();

		}
		return twitter;
	}
	
	//métodos
    public void escribirTweet() throws TwitterException
    {
        Twitter twitter;
        String ApiK="rBhgheqhABiVOT4SrmUUYJ90R";
        String ApiKP="4hkjXk5i7aHGfFMtPv9sVYt9QwGLdQDX3MC9RtbuOsXcppr2ct";
        String AccesT="1177311933021794311-zFZrdFqowMBm0LGIgh31feoonfipJX";
        String AccesTP="54Z4letZBpKPIHOKbXr9ntF3LCeWhWSYq4JouyLm8Og7Z";
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setUseSSL (true);
        
        
        //Aquí deberéis sustituir vuestras key, secret, token y tokenSecret.
        //Estas son las claves de mi cuenta @SuarezDeveloper
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(ApiK)
            .setOAuthConsumerSecret(ApiKP)
            .setOAuthAccessToken(AccesT)
            .setOAuthAccessTokenSecret(AccesTP);
        
        twitter = new TwitterFactory(cb.build()).getInstance();
 
        //Recuperar listado de ultimos tweets escritos
        //El paging sirve para decir el número máx de tweets que quieres recuperar
        Paging pagina = new Paging();
        pagina.setCount(10);
 
        //Recupera como máx 50 tweets escritos por tí
        ResponseList<Status> listado = twitter.getUserTimeline(pagina);
        for (int i = 0; i < listado.size(); i++)
            System.out.println(listado.get(i).getText());
 
        //Recupera como máx los ultimos 50 tweets de tus tablon de novedades
        listado = twitter.getHomeTimeline(pagina);
        for (int i = 0; i < listado.size(); i++)
            System.out.println(listado.get(i).getText());
 
        //Actualizar tu estado
        String nombreUsuario;
        int ptos;
        
        Status tweetEscrito = twitter.updateStatus("Probando Escritura de tweets");
        System.out.println ("Se actualizó correctamente el estado a [" + tweetEscrito.getText () + "].");

    }
}