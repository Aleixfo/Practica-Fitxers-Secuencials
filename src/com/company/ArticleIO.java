package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ArticleIO{

    Scanner sc = new Scanner(System.in);

    private final RandomAccessFile file;

    public RandomAccessFile getFile(){return this.file;}

    public ArticleIO (String ruta, String mode) throws IOException {
        file = new RandomAccessFile(ruta, mode);
    }

    // -----------LLEGIR | ESCRIURE---------------------------------------

    //METODE QUE ESCRIU UN ARTICLE 100 BytesSeguits
    //Va escrivint a la posicio indicada els atributs de l'article
    public void escriureArticle(Article article) throws IOException {

        if (file.getFilePointer() % Article.getArticleSize() == 0) {
            file.writeBoolean(article.getEliminat());
            file.writeBoolean(article.getDisponible());
            file.writeInt(article.getId());
            file.writeChars(article.getNomAjustat());
            file.writeChars(article.getDesAjustada());
            file.writeDouble(article.getPreu());
            file.writeInt(article.getCategoria());
            file.writeInt(article.getStock());


            System.out.println("\n[ARTICLE AFEGIT]\n");
        }else {
            System.out.println("No estas a la posicio correcta per escriure un nou article.");
        }
    }

    //Metode llegir article
    public Article llegirArticle() throws IOException{

        Article article = new Article();

        if (file.getFilePointer() % Article.getArticleSize() == 0){

            article.setEliminat(file.readBoolean());
            article.setDisponible(file.readBoolean());
            article.setId(file.readInt());
            article.setNom(llegirString(Article.getMaxStringName()));
            article.setDescripcio(llegirString(Article.getMaxStringDes()));
            article.setPreu(file.readDouble());
            article.setCategoria(file.readInt());
            article.setStock(file.readInt());

        }else {
            System.out.println("No es pot llegir l'article perque el punter no esta on toca.");
        }

        return article;
    }

    // -----------OBTENIR INDEX O NARTICLES--------------------------------

    //Metode que retorna el numero d'articles que hi ha al fitxer
    public int getnArticles() throws IOException{
        return (int) file.length()/Article.getArticleSize();
    }

    //Metode que obte la posicio (index) de l'article al fitxer, cercantlo a traves de la ID (unica)
    //Si no troba cap article amb aquella ID retorna un -1
    public int getArticleIndex(int id) throws IOException{

        for (int i = 0; i < getnArticles(); i++){
            file.seek( i * Article.getArticleSize() + 2);

            if (id == file.readInt()){
                return i;
            }
        }

        System.out.println("Error!\nNo hi ha cap article amb l'ID: "+id);
        return -1;
    }

    //METODE inserir Article
    public int getIndexPrimerArticleEliminat() throws IOException{

        //Bucle que cerca l'index de un article eliminat
        for (int i = 0; i<getnArticles();i++){

            file.seek(i*Article.getArticleSize());

            //Si troba boolea eliminat = true indexEliminat=i (index)
            if (file.readBoolean()){
                return i;
            }

        }
        return -1;
    }

    // -----------CLOSE---------------------------------------------------

    //Metode per tancar el fitxer (SEMPRE S'HA DE TANCAR)
    public void close() throws IOException{
        file.close();

        System.out.println("S'ha tancat el fitxer amb exit");
    }

    /* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */

    //Metode que llegeix CHARS on el tamany arriba per parametre i retorna l'string que ha llegit
    public String llegirString(int midaString) throws IOException{

        String nom = "";

        for (int i = 0; i < midaString; i++){
            nom = nom + file.readChar();
        }

        return nom;
    }

}
