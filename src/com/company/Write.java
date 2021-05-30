package com.company;

import java.io.IOException;

public class Write extends Read {


    public Write(String ruta, String mode) throws IOException {
        super(ruta, mode);
    }

    //METODE CONJUNT DE MODIFICAR DADES
    public void modificarDades(int id) throws IOException {

        System.out.println("Quina dada vols modificar?");
        System.out.println("[1] - Disponibilitat\n[2] - Stock\n[3] - Nom\n[4] - Descripcio");
        System.out.println("Accio -> ");
        int accio = sc.nextByte();

        switch (accio) {
            case 1 -> modificarDisponibilitat(id);
            case 2 -> modificarStock(id);
            case 3 -> modificarNom(id);
            case 4 -> modificarDes(id);
        }

    }

    //Metode modificar stock d'un article
    public void modificarStock(int id) throws IOException{

        int index = getArticleIndex(id);

        System.out.println("Quants d'articles vols afegir|restar de l'stock?");
        System.out.print("Afegir (+) | Restar (-)");
        int stock = sc.nextByte();

        getFile().seek( index*Article.getArticleSize() + 96);

        int stockActual = getFile().readInt();

        System.out.println("L'stock actual es "+stockActual);

        if (stockActual+stock>=0){

            getFile().seek(index*Article.getArticleSize() + 96);

            getFile().writeInt(stockActual+stock);

            System.out.println("S'ha actualitzat l'stock a "+stockActual+stock);

        }else {
            System.out.println("No s'ha pogut realitzar l'accio perque no hi ha stock disponible.");
        }

    }

    //Metode que marca un article com NO DISPONIBLE o DISPONIBLE segons boolea que arriba per parametre
    public void modificarDisponibilitat(int id) throws IOException{

        int index = getArticleIndex(id);

        if (index != -1) {

            System.out.print("Disponible = True | No Disponible = False");
            boolean disponible = sc.nextBoolean();

            getFile().seek(index * Article.getArticleSize() + 1);
            getFile().writeBoolean(disponible);

            System.out.println("S'ha marcat l'article numero " + index + " com a no disponible.");
        }

    }

    //Metode per modificar el nom
    public void modificarNom(int id) throws IOException{

        Article article = new Article();
        int index = getArticleIndex(id);

        if (index != -1) {

            getFile().seek(index * Article.getArticleSize() + 6);
            String nomActual = llegirString(Article.getMaxStringName());
            System.out.println("El nom actual de l'article es " + nomActual + ", introdueix un nom nou: ");
            String nouNom = sc.nextLine();
            article.setNom(nouNom);

            getFile().seek(index * Article.getArticleSize() + 6);
            getFile().writeChars(article.getNomAjustat());
            System.out.println("La nova descripcio es " + article.getNomAjustat());
        }

    }

    //Metode per modificar el nom
    public void modificarDes(int id) throws IOException{

        int index = getArticleIndex(id);

        if (index != -1) {

            Article article = new Article();

            getFile().seek(index * Article.getArticleSize() + 36);
            String desActual = llegirString(Article.getMaxStringDes());
            System.out.println("La descripcio actual de l'article es\n " + desActual + ", \nIntrodueix una nova descripcio: ");
            String desNova = sc.nextLine();
            article.setDescripcio(desNova);

            getFile().seek(index * Article.getArticleSize() + 36);
            getFile().writeChars(article.getDesAjustada());
            System.out.println("La nova descripcio de l'article es:\n " + article.getDesAjustada());
        }

    }

    //METODE ELIMINAR ARTICLE)
    public void eliminarArticle(int id) throws IOException{

        int returnIndex = getArticleIndex(id);

        if (returnIndex!=-1) {

        getFile().seek( getArticleIndex(id)*Article.getArticleSize());

        getFile().writeBoolean(true);

        System.out.println("S'ha marcat com eliminat l'article amb id = "+id);

        }
    }

    //METODE RESTAURAR ARTICLE ELIMINAT
    public void restaurarArticle(int id) throws IOException{

        int index = getArticleIndex(id);

        if (index != -1) {

            getFile().seek(getArticleIndex(id) * Article.getArticleSize());

            boolean artEliminat = getFile().readBoolean();

            if (artEliminat) {

                getFile().writeBoolean(false);

                System.out.println("S'ha restaurat l'article amb id = " + id);
            }else {
                System.out.println("L'article amb ID "+id+" no es troba eliminat.");
            }
        }

    }

    //METODE AFEGIR ARTICLE
    public void afegirArticle() throws IOException{

        if (getIndexPrimerArticleEliminat()>=0){
            getFile().seek(getIndexPrimerArticleEliminat()*Article.getArticleSize());
        }else {
            getFile().seek(getFile().length());
        }

        escriureArticle(Article.crearArticle());
    }

    //METODE AFEGIR ARTICLE
    public void afegirArticleVell(Article article) throws IOException{

        if (getIndexPrimerArticleEliminat()>=0){
            getFile().seek(getIndexPrimerArticleEliminat()*Article.getArticleSize());
        }else {
            getFile().seek(getFile().length());
        }

        escriureArticle(article);
    }


}
