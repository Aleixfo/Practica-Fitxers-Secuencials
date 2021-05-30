package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Client extends Usuari{

    Scanner sc = new Scanner(System.in);

    Read r = new Read("C://Users/fontc/OneDrive/hola/DAW (MANACOR)/Programació/Tercer Trimestre/Practica 3/Practica3-FitxersAccesAleatori-master-master/File.txt", "r");

    public Client() throws IOException {}

    public Boolean menuOpcionsClient() throws IOException{

        System.out.println("[ACCIONS CLIENTS]");
        System.out.println("[1] - Llistar un article segons l'ID\n[2] - Llistar articles disponibles\n[3] - Filtrar articles per categoria \n[4] - Ordenar articles per preu\n[0] - Sign Out");

        System.out.print("Accio: ");
        int accio = sc.nextByte();
        int id;

            switch (accio) {
                case 0 -> {
                    System.out.println("[SESSIO FINALITZADA]\n");
                    return false;
                }
                case 1 -> {
                    System.out.println("\nIntrodueix l'ID de l'article a llistar.");
                    System.out.print("ID: ");
                    id = sc.nextByte();
                    r.obtenirArticleClient(id);
                }
                case 2 -> r.mostrarArticlesDisponibles();
                case 3 -> r.llistarArticlesCategoria();
            }

        return true;
    }

}



