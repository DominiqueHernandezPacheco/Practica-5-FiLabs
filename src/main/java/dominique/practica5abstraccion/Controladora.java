/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dominique.practica5abstraccion;

/**
 *
 * @author SPARTAN PC
 */
import java.util.Scanner;
public class Controladora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Ejecutor e = new Ejecutor("calc",1);
        Scanner leer = new Scanner (System.in);
        System.out.println("Escribe un comando para ejecutar");
        e.comando = leer.next();
        if(e.necesitaEjecucion()){
            e.ejecutarTarea();
            
            new Thread(new Reloj()).start();
            new Thread(new Ejecutor("calc",0)).start();
                    
        }
        
    }
    
}
