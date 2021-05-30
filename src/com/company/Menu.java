package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void programa() throws IOException {

        Scanner sc = new Scanner(System.in);

        boolean actiu;
        int resposta;


        do {

            System.out.println("\n[PROGRAMA INICIAT]\n[0] -> Crear Usuari\n[1] -> Iniciar Sessio\n[2] -> Sortir del programa");
            System.out.print("Accio -> ");
            resposta = sc.nextByte();

            Usuari user = new Usuari();


            if (resposta == 0) {
                System.out.println("Crea un usuari");
                user.crearUsuari();
            }
            if (resposta == 1) {

                Usuari usuariActual = user.signIn();

                if (usuariActual.getRol() == 0) {
                    Administrador admin = new Administrador();

                    do {
                        actiu = admin.menuOpcionsAdmin();
                    } while (actiu);
                }
                if (usuariActual.getRol() == 1) {
                    Client client = new Client();

                    do {
                        actiu = client.menuOpcionsClient();
                    } while (actiu);
                }

            }
        } while (resposta != 2);
        System.out.println("\n[PROGRAMA FINALITZAT]");
    }

}
