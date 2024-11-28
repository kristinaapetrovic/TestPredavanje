/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zmr4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author Korisnik
 */
public class Server {
    
    
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server je pokrenut i čeka klijenta...");
            
            Socket socket = serverSocket.accept();
            System.out.println("Klijent povezan.");

            // Kreiranje ulaznih i izlaznih tokova
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            
            String clientMessage, serverMessage;

            // Petlja za razmenu poruka
            while (true) {
                // Čitanje poruke od klijenta
                clientMessage = input.readLine();
                if ("stop".equalsIgnoreCase(clientMessage)) {
                    System.out.println("Klijent je završio razgovor.");
                    break;
                }
                System.out.println("Klijent: " + clientMessage);

                // Slanje poruke klijentu
                System.out.print("Server: ");
                serverMessage = consoleInput.readLine();
                output.println(serverMessage);

                if ("stop".equalsIgnoreCase(serverMessage)) {
                    System.out.println("Server je završio razgovor.");
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
