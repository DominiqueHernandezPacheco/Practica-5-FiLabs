/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominique.practica5abstraccion;

/**
 *
 * @author SPARTAN PC
 */
import java.util.*;
import java.io.IOException;

public class Ejecutor extends TareaPeriodica {
    
    protected String comando;
	
	public Ejecutor(String comando, int periodo){
		super(periodo);
		this.comando = comando;
	}
	
	public String leerComando(){ return comando; }
        
    @Override
        public boolean necesitaEjecucion(){
            if(!activa) return false;
            
            //Calcula la hora de la próxima ejecución
            Calendar proximaEjecucion = new GregorianCalendar();
            proximaEjecucion.setTime(ultimaEjecucion);
            proximaEjecucion.add(Calendar.SECOND, periodo);
            
            Calendar ahora = new GregorianCalendar();
            
            //Comprobamos si ha pasado la hora actual
            return(proximaEjecucion.before(ahora));
        }
        
    @Override
        public int ejecutarTarea(){
            try{
                Runtime.getRuntime().exec(comando);
                return 0;
            } catch(IOException e){
                System.err.println(e.toString());
            }
            return -1;
        }
        
    @Override
        public void run(){
            if(this.necesitaEjecucion()){
                this.ejecutarTarea();
            }
        }
}