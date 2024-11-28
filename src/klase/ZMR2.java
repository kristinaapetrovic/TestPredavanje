/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Korisnik
 */
public class ZMR2 {

    //preko stu prihvata niz simbolickih adresa i 
    //za svaku ce odrediti ip adresu. prikazati i simbolicke
    //i ip adrese i sortirati prema broju njihovih adresa 
    //one koje imaju vise ip adresa bice prve
    static ArrayList<Adresa> adrese = new ArrayList<>();

    public static void main(String[] args) throws UnknownHostException {

        prihvatiNizSimbolickihAdresa();

        odreditiIPAdreseSimbolickihAdresa();

        sortirajSimbolickeAdrese();

        prikaziSimbolickeINjihoveIPAdrese();

    }

    static void prihvatiNizSimbolickihAdresa() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Uneti simbolicku adresu racunara (za izlaz izaberi 1):");

            String SimbolickaAdresa = sc.nextLine(); //**********************
                
            if (SimbolickaAdresa.equals("1")) {

                break;

            }
            Adresa adresa=new Adresa(SimbolickaAdresa);
            adrese.add(adresa);
        }

    }

    static void odreditiIPAdreseSimbolickihAdresa() throws UnknownHostException {
        
        
        for (Adresa ad : adrese) {
            ad.IPAdrese=InetAddress.getAllByName(ad.SimbolickaAdresa);
        }

    }

    static void sortirajSimbolickeAdrese() {
        Collections.sort(adrese);
    }

    static void prikaziSimbolickeINjihoveIPAdrese() {

        for (Adresa ad : adrese) {
            ad.prikazi();
        }

    }

}

class Adresa implements Comparable<Adresa> {

    String SimbolickaAdresa;

    InetAddress[] IPAdrese;

    public Adresa(String SimbolickaAdresa) {

        this.SimbolickaAdresa = SimbolickaAdresa;

    }

    @Override

    public int compareTo(Adresa adresa) {

        return Integer.compare(adresa.IPAdrese.length,this.IPAdrese.length);

    }

    @Override

    public String toString() {

        String s = "SimbolickaAdresa:" + SimbolickaAdresa + "\n";

        for (InetAddress IPAdresa : IPAdrese) {
            s = s + IPAdresa.getHostAddress()+"\n";
        }

        return s;

    }

    void prikazi() {

        System.out.println(toString());

    }

}

