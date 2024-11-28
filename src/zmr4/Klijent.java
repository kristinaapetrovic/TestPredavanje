/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zmr4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Korisnik
 */
public class Klijent {

     public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Povezani ste na server.");

            // Kreiranje ulaznih i izlaznih tokova
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            
            String clientMessage, serverMessage;

            // Petlja za razmenu poruka
            while (true) {
                // Slanje poruke serveru
                System.out.print("Klijent: ");
                clientMessage = consoleInput.readLine();
                output.println(clientMessage);

                if ("stop".equalsIgnoreCase(clientMessage)) {
                    System.out.println("Klijent je završio razgovor.");
                    break;
                }

                // Čitanje poruke od servera
                serverMessage = input.readLine();
                if ("stop".equalsIgnoreCase(serverMessage)) {
                    System.out.println("Server je završio razgovor.");
                    break;
                }
                System.out.println("Server: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
