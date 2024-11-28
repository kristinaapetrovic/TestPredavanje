/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Korisnik
 */
public class ZMR3 {
    //unetu url preko stu
    //na toj url je neka datoteka
    //procictati dat i zapamtiti njen sadrzaj
    //pretraziti sadrzaj po zadatoj reci
    //prikazati ukuman broj pojavljivanja zadate reci
    
    public static void main(String[] args) throws IOException {
        System.out.println("Unesite url: ");                                            //uzeti jednostavniji url da bi citalo 
        BufferedReader tastatura=new BufferedReader(new InputStreamReader(System.in)); //https://silab.fon.bg.ac.rs/wp-content/uploads/2016/05/NitiPredavanja.pdf
        String urlStr=tastatura.readLine();
        urlStr.trim();
        System.out.println("Unesite zeljenu rec: "); 
        String rec=tastatura.readLine();
        
        URL url=new URL(urlStr);
        URLConnection conn=url.openConnection();
        int duzina=conn.getContentLength();
        if(duzina>0){
            InputStream is=conn.getInputStream();
            int i=duzina;
            int karakter;
            String text="";
            while((karakter=is.read())!=-1 && --i>0){
                text+=(char)karakter;
            }
          //  System.out.println(text);
            String [] niz=text.split(rec);
            int brojPojavljivanja=niz.length-1;
            System.out.println("Broj pojavljivanja reci u dokumentu: "+brojPojavljivanja);
        }else{
            System.out.println("Prazno");
        }
        
        
        
        
        
    }
    
    
    
    
}
