package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuari {

    Scanner sc = new Scanner(System.in);

    private String nick;
    private String password;
    private int rol;
    private final ArrayList<Usuari> usuaris = new ArrayList<>();

    public Usuari(int rol, String nick, String password){
        this.nick=nick;
        this.password=password;
        this.rol=rol;
    }

    public Usuari(){}

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public int getRol(){
        return rol;
    }

    public void crearUsuari(){

        System.out.println("Quin rol tendra l'usuari?");
        System.out.println("Admin [0]\nClient [1]");
        System.out.print("Rol -> ");
        int rol = sc.nextByte();

        System.out.print("Nom d'usuari -> ");
        String nom = sc.next();

        System.out.print("Contrasenya -> ");
        String pass = sc.next();

        Usuari user = new Usuari(rol, nom, pass);

        usuaris.add(user);

    }

    public Usuari signIn(){

        Usuari guest = new Usuari(1, "guest", "guest");
        Usuari admin = new Usuari(0, "admin", "admin");
        usuaris.add(admin);
        usuaris.add(guest);

        System.out.println("\n[INICI DE SESSIO]");
        System.out.print("Nom d'usuari -> ");
        String nick = sc.next();
        System.out.print("Contrasenya -> ");
        String password = sc.next();

        for (Usuari user : usuaris) {

            if (nick.equals(user.getNick())) {

                if (password.equals(user.getPassword())){
                    System.out.println("[SESSIO INICIADA]");
                    System.out.println(user);
                    return user;
                }
            }
        }

        System.out.println("[DADES INCORRECTES]\n");
        System.out.println("Has iniciat sessio com a guest (client)\n");
        return guest;
    }

    public String getRolString(){
        if (this.rol==0){
            return "Administrador";
        }
        else {
            return "Client";
        }
    }

    public String toString(){
        return "\n[CREEDENCIALS USUARI]\n* Rol -> "+getRolString()+"\n* Nom -> "+this.nick+"\n* Contrasenya -> "+this.password+"\n\n";
    }

}
