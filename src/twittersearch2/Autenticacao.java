package twittersearch2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public abstract class Autenticacao {

    //private static final String tweetLink = "https://twitter.com/tweet/status/";
    private static final long maxId = 0;

    public static Twitter Acesso() {

        //try {
        ConfigurationBuilder builder = new ConfigurationBuilder();

        builder.setOAuthConsumerKey("NbcyMJEvKGrKuPa9cZq2KQS3B");
        builder.setOAuthConsumerSecret("JoeVyPkkQkh4mxwftwePd4yyLilvIRv01qt6hLUF15iiZUgqXH");

        Configuration configuration = builder.build();

        TwitterFactory factory = new TwitterFactory(configuration);
        Twitter twitter = factory.getInstance();

        AccessToken accessToken = loadAccessToken();

        twitter.setOAuthAccessToken(accessToken);

        // return twitter;
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        return twitter;
    }

    private static AccessToken loadAccessToken() {
        String token = "204146460-moBLeW3kWqmpmLEgMoXQBUGa59PIgC6hBOUbUryu";
        String tokenSecret = "zsHgbgdRSNHxlSIOiPLN6fdkWA7M6OhHCcB07jddJ9hfY";
        return new AccessToken(token, tokenSecret);
    }

    public static void search(Twitter twitter, String queryString, int tweetCount) throws SQLException {
        
        try {

            Query query = new Query(queryString);
            
             if(maxId != 0)
            {
                query.setMaxId(maxId);
                
                query.setSinceId(maxId);
                
            }

            query.setCount(tweetCount);
            
            //query.setLang("pt_br");
            
            query.setLang("en");

            QueryResult result = twitter.search(query);
            
            ArrayList<Tweet> tweets = new ArrayList<>();
            
            ArrayList<User> users = new ArrayList<>();
            

            for (Status status : result.getTweets()) {
                
                long id_usuario = status.getUser().getId();
                
                String nm_usuario = status.getUser().getName();
                
                String tag_usuario = "@"+status.getUser().getScreenName();
                
                long nr_seguidores = status.getUser().getFollowersCount();
                
                long nr_amigos = status.getUser().getFriendsCount();
                
                String nm_idioma = status.getUser().getLang();
                
                String nm_local = status.getUser().getLocation();
                
                long nr_tweets = status.getUser().getStatusesCount();
                
                String url_perfil = status.getUser().getURL();
                
                boolean is_verify = status.getUser().isVerified();
                
                boolean is_translate = status.getUser().isTranslator();
                
                String nm_imagem = status.getUser().getProfileImageURL();
                
                User user = new User(id_usuario,nm_usuario,tag_usuario,nr_seguidores,nr_amigos,nm_idioma,nm_local,nr_tweets,url_perfil,is_verify,is_translate,nm_imagem);
                
                long id_tweet = status.getId();
                
                String ds_tweet = status.getText();
                
                Date dh_tweet = status.getCreatedAt();
                
                long qt_favoritos = status.getFavoriteCount();
                
                long qt_retweet = status.getRetweetCount();
                
                boolean sn_retweet = status.isRetweet();
                
                String nm_pais;
                String nm_local_tweet;
                try{
                    nm_pais = status.getPlace().getCountryCode();
                }
                catch( Exception e){
                    nm_pais = "";
                }
                try{
                    
                    nm_local_tweet = status.getPlace().getName();
                }
                catch(Exception e){
                    nm_local_tweet = "";
                }
                Tweet tweet = new Tweet (id_tweet,ds_tweet,dh_tweet,qt_favoritos,qt_retweet,sn_retweet, nm_pais,nm_local_tweet);
                
                
                tweets.add(tweet);
                users.add(user);
//                //int Sentiment = NLP.findSentiment(text); //Passa text do Tweet para a API de Analise de Sentimento
//                if (Sentiment == 1) {
//                    Tweet tweet = new Tweet(id, user, text, image, link, Sentiment);
//
//                    tweets.add(tweet);
//                }
            }
            
            
            Organizador org = new Organizador(tweets, users);
            
            query.maxId(maxId);

        } catch (TwitterException e) {

            System.out.println("Erro no twitter");

        } catch (NullPointerException e) {

            System.out.println("Provavelmente Twitter nulo sendo passado para o método search.");
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Erro de log.");

        }

    }

}

/* Status status = twitter.updateStatus("Qualquer coisa");
            System.out.println("Tweet postado com sucesso! [" + status.getText() + "]."); */
// Código para postar no Twitter
/*try {
			ConfigurationBuilder builder = new ConfigurationBuilder();
			
			builder.setOAuthConsumerKey("vFTHrp3luViolfD29mgOGuEBr");
			builder.setOAuthConsumerSecret( "Bhbawm0D58cpKK3Ox7kdnqjJJASfXpNu1bojhz4fdaswks2v8q");
			
			Configuration configuration = builder.build();

			TwitterFactory factory = new TwitterFactory(configuration);
			Twitter twitter = factory.getInstance();      

			AccessToken accessToken = loadAccessToken();

			twitter.setOAuthAccessToken(accessToken);

			Status status = twitter.updateStatus("Qualquer coisa");
			System.out.println("Tweet postado com sucesso! [" + status.getText() + "].");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static AccessToken loadAccessToken(){
		String token = "204146460-9rRGendYT3PPq1pVtJO8aWU4II4qWddlIs6pze99"; 
		String tokenSecret = "NVNMFdXds12WWXGj3y0IVX998CdFaTEAR50ieb51YhguJ"; 
		return new AccessToken(token, tokenSecret);
	}

} */
