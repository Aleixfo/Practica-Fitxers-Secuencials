package com.company;

public class Main {

    public static void main(String[] args){

        /*
        Article Art1 = new Article(1, "Mause", "Utilitzat per moures", 24.3, 1);
        Article Art2 = new Article(2, "Ram", "El segon cervell", 14.3, 1);
        Article Art3 = new Article(3, "Teclat", "Utilitzat per escriure", 28.3, 2);
        Article Art4 = new Article(4, "Pantalla", "Projecta l'ordinador", 56.3, 3);
        Article Art5 = new Article(5, "Disc dur", "Enmagatzema informacio", 87.3, 4);

        Write write = new Write("C://Users/fontc/OneDrive/hola/DAW (MANACOR)/Programació/Tercer Trimestre/Practica 3/Practica3-FitxersAccesAleatori-master-master/File.txt", "rw");

        write.afegirArticleVell(Art1);
        write.afegirArticleVell(Art2);
        write.afegirArticleVell(Art3);
        write.afegirArticleVell(Art4);
        write.afegirArticleVell(Art5);
        */

        try {
            Menu.programa();
        }catch (Exception e){
            System.out.println("Hi ha agut un problema!\nProblema -> "+e);
        }
    }
}

