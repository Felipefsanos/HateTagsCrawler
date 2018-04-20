/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittersearch2;

import java.util.Date;


/**
 *
 * @author est18515621
 */
public class Tweet {

    public long id;
    public String text;
    public Date dh_tweet;
    public long qt_favoritos;
    public long qt_retweet;
    public boolean sn_retweet;
    public String nm_local;
    public String nm_pais;

    public Tweet(long id, String text, Date dh_tweet, long qt_favoritos, long qt_retweet, boolean sn_retweet, String nm_local, String nm_pais) {
        this.id = id;
        this.text = text;
        this.dh_tweet = dh_tweet;
        this.qt_favoritos = qt_favoritos;
        this.qt_retweet = qt_retweet;
        this.sn_retweet = sn_retweet;
        this.nm_local = nm_local;
        this.nm_pais = nm_pais;
    }

    public String getNm_pais() {
        return nm_pais;
    }

    public void setNm_pais(String nm_pais) {
        this.nm_pais = nm_pais;
    }

    public String getNm_local() {
        return nm_local;
    }

    public void setNm_local(String nm_local) {
        this.nm_local = nm_local;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public java.sql.Date getDh_tweet() {
        java.sql.Date dh_sql = new java.sql.Date(dh_tweet.getTime());
        return dh_sql;
    }

    public void setDh_tweet(Date dh_tweet) {
        this.dh_tweet = dh_tweet;
    }

    public long getQt_favoritos() {
        return qt_favoritos;
    }

    public void setQt_favoritos(long qt_favoritos) {
        this.qt_favoritos = qt_favoritos;
    }

    public long getQt_retweet() {
        return qt_retweet;
    }

    public void setQt_retweet(long qt_retweet) {
        this.qt_retweet = qt_retweet;
    }

    public boolean isSn_retweet() {
        return sn_retweet;
    }

    public void setSn_retweet(boolean sn_retweet) {
        this.sn_retweet = sn_retweet;
    }
    
    
        
}
