/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittersearch2;

import Banco.*;
import java.math.BigInteger;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author lipe2
 */
public class Organizador {

    private ArrayList<Tweet> tweets;
    private ArrayList<User> usuarios;
    private BancoDeDados BD;

    public Organizador(ArrayList<Tweet> tweets, ArrayList<User> usuarios) throws SQLException {
        this.tweets = tweets;
        this.usuarios = usuarios;
        BD = new BancoDeDados("127.0.0.1", "hate_tags", "root", "");
        this.insere();
    }

    private void insere() throws SQLException {

        String sql;
        boolean Rbusca = true;
        PreparedStatement stmt;

        for (User u : usuarios) {
            if (u.getTag() == null) {
                Rbusca = false;
            }
        }
        if (Rbusca) {
            for (int i = 0; i < tweets.size(); i++) {

                String tag_busca = usuarios.get(i).getTag();

                ResultSet tagusers = BD.Select("SELECT tag_usuario FROM usuario WHERE tag_usuario LIKE '" + tag_busca + "'");

                if (tagusers.next() == false) {

                    sql = "INSERT INTO usuario(id_usuario,nm_usuario,tag_usuario,nr_seguidores,nr_amigos,nm_idioma,nm_localizacao,nr_tweets,url_perfil,"
                            + "sn_verificado,sn_tradutor) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                    stmt = BD.PrepararInsert(sql);
                    stmt.setLong(1, usuarios.get(i).getId());
                    stmt.setString(2, usuarios.get(i).getNome());
                    stmt.setString(3, usuarios.get(i).getTag());
                    stmt.setLong(4, usuarios.get(i).getNr_seguidores());
                    stmt.setLong(5, usuarios.get(i).getNr_amigos());
                    stmt.setString(6, usuarios.get(i).getIdioma());
                    stmt.setString(7, usuarios.get(i).getLocalizacao());
                    stmt.setLong(8, usuarios.get(i).getNr_tweets());
                    stmt.setString(9, usuarios.get(i).getUrl_perfil());
                    if (usuarios.get(i).isSn_tradutor()) {
                        stmt.setInt(10, 1);
                    } else {
                        stmt.setInt(10, 0);
                    }
                    if (usuarios.get(i).isSn_verificado()) {
                        stmt.setInt(11, 1);
                    } else {
                        stmt.setInt(11, 0);
                    }
                    stmt.execute();
                    stmt.close();

                    sql = "INSERT INTO imagem(id_usuario,nm_imagem) VALUES (?,?)";

                    stmt = BD.PrepararInsert(sql);

                    stmt.setLong(1, usuarios.get(i).getId());
                    stmt.setString(2, usuarios.get(i).getNm_imagem());
                    stmt.execute();
                    stmt.close();
                }

                long dttbusca = tweets.get(i).getId();

                ResultSet idbusca = BD.Select("Select id_tweet FROM tweets WHERE id_tweet =" + dttbusca);

                if (idbusca.next() == false) {

                    sql = "INSERT INTO tweets(id_tweet,id_usuario,ds_tweet,dh_tweet,qt_favoritos,qt_retweet,sn_retweet) VALUES (?,?,?,?,?,?,?)";

                    stmt = BD.PrepararInsert(sql);
                    stmt.setLong(1, tweets.get(i).getId());
                    stmt.setLong(2, usuarios.get(i).getId());
                    stmt.setString(3, tweets.get(i).getText());
                    stmt.setDate(4, tweets.get(i).getDh_tweet());
                    stmt.setLong(5, tweets.get(i).getQt_favoritos());
                    stmt.setLong(6, tweets.get(i).getQt_retweet());

                    if (tweets.get(i).isSn_retweet()) {
                        stmt.setInt(7, 1);
                    } else {
                        stmt.setInt(7, 0);
                    }
                    stmt.execute();
                    stmt.close();

//                sql = "INSERT INTO localizacao_tweet(id_tweet,nm_localizacao,nm_pais) VALUES (?,?,?)";
//
//                stmt = BD.PrepararInsert(sql);
//                
//                stmt.setLong(1, tweets.get(i).getId());
//                stmt.setString(2, tweets.get(i).getNm_local());
//                System.out.println(tweets.get(i).getNm_local());
//                stmt.setString(3, tweets.get(i).getNm_pais());
                    //A partir daqui entra as APIS de ANALISE
                    sql = "INSERT INTO sentimento(id_tweet,rs_api_core,rs_api2,rs_api3) VALUES (?,?,?,?)";

                    stmt = BD.PrepararInsert(sql);

                    stmt.setLong(1, tweets.get(i).getId());
                    stmt.setNull(2, Types.TINYINT);
                    stmt.setNull(3, Types.TINYINT);
                    stmt.setNull(4, Types.TINYINT);

                    stmt.execute();
                    stmt.close();
                }
                System.out.println("Sucesso na inserção ao Banco");

            }
        }
        else{
            System.out.println("A busca não retornou resultados");
        }
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }

    public ArrayList<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<User> usuarios) {
        this.usuarios = usuarios;
    }

}
