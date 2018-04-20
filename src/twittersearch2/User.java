/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittersearch2;

/**
 *
 * @author lipe2
 */
public class User {
    
    public long id;
    public String nome;
    public String tag;
    public long nr_seguidores;
    public long nr_amigos;
    public String idioma;
    public String localizacao;
    public long nr_tweets;
    public String url_perfil;
    public boolean sn_verificado;
    public boolean sn_tradutor;
    public String nm_imagem;

    public User(long id, String nome, String tag, long nr_seguidores, long nr_amigos, String idioma, String localizacao, long nr_tweets, String url_perfil, boolean sn_verificado, boolean sn_tradutor, String nm_imagem) {
        this.id = id;
        this.nome = nome;
        this.tag = tag;
        this.nr_seguidores = nr_seguidores;
        this.nr_amigos = nr_amigos;
        this.idioma = idioma;
        this.localizacao = localizacao;
        this.nr_tweets = nr_tweets;
        this.url_perfil = url_perfil;
        this.sn_verificado = sn_verificado;
        this.sn_tradutor = sn_tradutor;
        this.nm_imagem = nm_imagem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getNr_seguidores() {
        return nr_seguidores;
    }

    public void setNr_seguidores(long nr_seguidores) {
        this.nr_seguidores = nr_seguidores;
    }

    public long getNr_amigos() {
        return nr_amigos;
    }

    public void setNr_amigos(long nr_amigos) {
        this.nr_amigos = nr_amigos;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    
    public String getNm_imagem(){
        return nm_imagem;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public long getNr_tweets() {
        return nr_tweets;
    }

    public void setNr_tweets(long nr_tweets) {
        this.nr_tweets = nr_tweets;
    }

    public String getUrl_perfil() {
        return url_perfil;
    }

    public void setUrl_perfil(String url_perfil) {
        this.url_perfil = url_perfil;
    }

    public boolean isSn_verificado() {
        return sn_verificado;
    }

    public void setSn_verificado(boolean sn_verificado) {
        this.sn_verificado = sn_verificado;
    }

    public boolean isSn_tradutor() {
        return sn_tradutor;
    }

    public void setSn_tradutor(boolean sn_tradutor) {
        this.sn_tradutor = sn_tradutor;
    }
    
    public void setNm_imagem(String nm_imagem){
        this.nm_imagem = nm_imagem;
    }
    
    
}
