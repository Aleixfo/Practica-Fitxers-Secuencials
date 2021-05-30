package com.company;

import java.io.IOException;

public class Read extends ArticleIO{

    public Read(String ruta, String mode) throws IOException {
        super(ruta, mode);
    }

    public void obtenirArticleClient(int id) throws IOException{

        int returnIndex = getArticleIndex(id);

        if (returnIndex!=-1) {

            //Coloca punter a principi de l'article
            getFile().seek(getArticleIndex(id) * Article.getArticleSize());

            Article article = llegirArticle();

            if (article.getDisponible()&&!article.getEliminat()){

                getFile().seek(getArticleIndex(id) * Article.getArticleSize());
                System.out.println(article);

            }else {
                System.out.println("No hi ha cap article disponible amb aquesta ID.\nTornau a intentar.");
            }
        }
    }

    public void obtenirArticleAdmin(int id) throws IOException{

        int returnIndex = getArticleIndex(id);

        if (returnIndex!=-1) {

            //Coloca punter a principi de l'article
            getFile().seek(getArticleIndex(id) * Article.getArticleSize());

            //Printea l'article
            System.out.println(llegirArticle());
        }
    }

    public void llistarArticles() throws IOException{

        System.out.println("[1] - Disponibles\n[2] - No Disponibles\n[3] - Eliminats\n[4] - Per categoria\n[5] - Llistar tots els articles");
        System.out.print("Opcio: ");
        int accio = sc.nextByte();

        switch (accio) {
            case 1 -> mostrarArticlesDisponibles();
            case 2 -> mostrarArticlesNoDisponibles();
            case 3 -> mostrarArticlesEliminats();
            case 4 -> llistarArticlesCategoria();
            case 5 -> mostrarTotalArticles();
        }

    }

    public void mostrarArticlesEliminats() throws IOException{

        for (int i = 0; i < getnArticles(); i++){

            getFile().seek(i*Article.getArticleSize());
            Article article = llegirArticle();

            if (article.getEliminat()){
                System.out.println(article);
            }
        }

    }

    public void mostrarArticlesNoDisponibles() throws IOException{

        for (int i = 0; i < getnArticles(); i++){

            getFile().seek(i*Article.getArticleSize());
            Article article = llegirArticle();

            if (!article.getDisponible()){
                System.out.println(article);
            }
        }
    }

    public void mostrarArticlesDisponibles() throws IOException{

        for (int i = 0; i < getnArticles(); i++){

            getFile().seek(i*Article.getArticleSize());
            Article article = llegirArticle();

            if (article.getDisponible()&&!article.getEliminat()){
                System.out.println(article);
            }
        }
    }

    public void mostrarTotalArticles() throws IOException{

        for (int i = 0; i < getnArticles(); i++){

            getFile().seek(i*Article.getArticleSize());

            Article article = llegirArticle();

            System.out.println(article);
        }
    }

    public void llistarArticlesCategoria() throws IOException{

        System.out.println("Quina categoria vols llistar?");
        int cat = sc.nextByte();

        for (int i = 0; i < getnArticles(); i++){

            getFile().seek(i*Article.getArticleSize());
            Article article = llegirArticle();

            if (!article.getEliminat()&&article.getDisponible()) {

                if (article.getCategoria() == cat) {
                    System.out.println(article);
                }
            }
        }
    }

    //LLISTAR PER PREU
    public void llistarMajorMenor() throws IOException{} // NO FET

    public void llistarMenorMajor() throws IOException{} // NO FET
}