package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Administrador extends Usuari{

    Scanner sc = new Scanner(System.in);

    Write w = new Write("C://Users/fontc/OneDrive/hola/DAW (MANACOR)/Programació/Tercer Trimestre/Practica 3/Practica3-FitxersAccesAleatori-master-master/File.txt", "rw");

    public Administrador() throws IOException {}

    public Boolean menuOpcionsAdmin() throws IOException {

        System.out.println("[ACCIONS ADMINISTRADORS]");
        System.out.println("""
                [1] - Crear i afegir un article
                [2] - Eliminar un article
                [3] - Restaurar un article eliminat
                [4] - Llistar un article per la seva ID
                [5] - Modificar les dades d'un article
                [6] - Filtrar articles segons atributs
                [0] - SIGN OUT""");

        System.out.print("Accio: ");
        int accio = sc.nextByte();
        int id;

            // FALTA METODE
            switch (accio) {
                case 0 -> {
                    System.out.println("\nHas tancat sessio.\n");
                    return false;
                }
                case 1 -> w.afegirArticle();
                case 2 -> {
                    System.out.println("\nIntrodueix l'ID de l'article a eliminar.");
                    System.out.print("ID: ");
                    id = sc.nextByte();
                    w.eliminarArticle(id);
                }
                case 3 -> {
                    System.out.println("\nIntrodueix l'ID de l'article a restaurar");
                    System.out.print("ID: ");
                    id = sc.nextByte();
                    w.restaurarArticle(id);
                }
                case 4 -> {
                    System.out.println("\nIntrodueix l'ID de l'article a llistar.");
                    System.out.print("ID: ");
                    id = sc.nextByte();
                    w.obtenirArticleAdmin(id);
                }
                case 5 -> {
                    System.out.println("\nIntrodueix l'ID de l'article a modificar.");
                    System.out.print("ID: ");
                    id = sc.nextByte();
                    w.modificarDades(id);
                }
                case 6 -> w.llistarArticles();
            }

        return true;

    }
    
}


