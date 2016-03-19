/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.IPMessenger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Jennings
 */
public class Pat {
    Scanner b;
    {
         b = new Scanner(System.in);
    }
    
    public static void main( String[] args){
        
        PrintWriter l = null;
        Path c = Paths.get("C:\\Users\\David Jennings\\Desktop");
      System.out.println(c.toAbsolutePath());
        System.out.println(System.getProperty("user.home"));
        File k = new File(c.toAbsolutePath() + "\\boot.txt");
        System.out.print(k.toString());
        try {
            
            k.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Pat.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             l = new PrintWriter(k);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        l.write("g");
        l.close();
    }
}
