package com.company;

import java.util.Scanner;

public class Article {

    private Boolean eliminat; //1 Byte
    private Boolean disponible; //1 Byte
    private int id; //4 Bytes
    private String nom; // 15 * 2 = 30 Bytes
    private String descripcio; //24 * 2 = 48 Bytes
    private double preu; //8 Bytes
    private int categoria; //4 Bytes
    private int stock; // 4 Bytes
    //Total article: 100 Bytes

    //Constants longitut strings
    private static final int MAX_STRING_NAME = 15;
    private static final int MAX_STRING_DES = 24;
    private static final int ARTICLE_SIZE = 100;

    //Constructors
    public Article(){}

    public Article(int id, String nom, String descripcio, double preu, int categoria){

        this.eliminat = false;
        this.id =id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.preu = preu;
        this.categoria = categoria;
        this.stock = 0;
        this.disponible = true;

    }

    //Getters
    public boolean getEliminat(){return this.eliminat;}
    public boolean getDisponible(){return this.disponible;}
    public int getId(){return this.id;}
    public double getPreu(){return this.preu;}
    public int getCategoria(){return this.categoria;}
    public int getStock(){return this.stock;}

    public static int getMaxStringName(){
        return MAX_STRING_NAME;
    }
    public static int getMaxStringDes(){
        return MAX_STRING_DES;
    }
    public static int getArticleSize() {
        return ARTICLE_SIZE;
    }

    //Setters
    public void setEliminat(Boolean eliminat){this.eliminat=eliminat;}
    public void setDisponible(Boolean disponible){this.disponible=disponible;}
    public void setId(int id){this.id=id;}
    public void setNom(String nom){this.nom=nom;}
    public void setDescripcio(String descripcio){this.descripcio=descripcio;}
    public void setPreu(double preu){this.preu=preu;}
    public void setCategoria(int categoria){this.categoria=categoria;}
    public void setStock(int stock){this.stock=stock;}

    //Metode per printear toString
    @Override
    public String toString(){
        return  "\n******ARTICLE******\n* ID: "+id+"\n* Nom: "+nom+"\n* Descripcio: "+descripcio+
                "\n* Preu: "+preu+"\n* Categoria: "+categoria+"\n* Numero en stock: "+stock+"\n*******************\n";
    }

    //Metode d'ajustar NOM
    public String getNomAjustat(){

        String nomAjustat = this.nom;

        if (nomAjustat.length() > MAX_STRING_NAME) {
            nomAjustat = nomAjustat.substring(0, MAX_STRING_NAME);
            return nomAjustat;
        }
        for (int i = this.nom.length(); i < MAX_STRING_NAME; i++) {
            nomAjustat += " ";
        }

        return nomAjustat;
    }

    //Metode d'ajustar NOM
    public String getDesAjustada(){

        String desAjustada = this.descripcio;

        if (desAjustada.length() > MAX_STRING_DES) {
            desAjustada = desAjustada.substring(0, MAX_STRING_DES);
            return desAjustada;
        }
        for (int i = this.descripcio.length(); i < MAX_STRING_DES; i++) {
            desAjustada += " ";
        }

        return desAjustada;
    }

    //Metode crear Article
    public static Article crearArticle(){

        Scanner sc = new Scanner(System.in);

        Article article = new Article();

        System.out.println("\n[CREA UN NOU ARTICLE]\n");

        article.setDisponible(true);
        article.setEliminat(false);
        article.setStock(0);

        System.out.print("Introdueix l'ID de l'article -> ");
        int id = sc.nextByte();
        article.setId(id);

        System.out.print("Introdueix el nom de l'article -> ");
        String nom = sc.next();
        article.setNom(nom);

        System.out.println("Introdueix la descripcio de l'article. ");
        System.out.print("Descripcio -> ");
        String descripcio = sc.next();
        article.setDescripcio(descripcio);

        sc.nextLine();

        System.out.print("Quina categoria te? -> ");
        int cat;
        cat = sc.nextByte();
        article.setCategoria(cat);

        System.out.print("Quin preu te? -> ");
        double preu = sc.nextDouble();
        article.setPreu(preu);

        return article;
    }

}
