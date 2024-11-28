/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package klase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
/**
 *
 * @author Korisnik
 */
public class ZMR1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        //napisati preko stu da prihvati poizvoljnu simbol adresu 
        //rac. proveriti da li je moguce pristupiti tom rac (ping)
        System.out.println("Unesite simbolicku adresu: ");
        BufferedReader tastatura=new BufferedReader(new InputStreamReader(System.in));
        String adresa=tastatura.readLine(); //uneti: www.fon.bg.ac.rs i radi
        adresa.trim();
        InetAddress address=InetAddress.getByName(adresa);
        boolean ping=address.isReachable(5000);
        System.out.println("IP adresa: "+address.getHostAddress());
        System.out.println("Ping: "+ping);
        
        
    }
    
}
