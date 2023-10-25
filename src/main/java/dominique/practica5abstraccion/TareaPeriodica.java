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

public abstract class TareaPeriodica implements Runnable{
    
    protected int periodo;
	protected Date ultimaEjecucion;
	protected boolean activa;
	
	public TareaPeriodica(int periodo){
		this.periodo = periodo;
		actualizar();
		activa = true;
	}
	
	public TareaPeriodica() { this(1); }
	
	public void actualizar(){
		ultimaEjecucion = new Date(); // Hora actual
	}
	
	public void activar() { activa = true; }
	public void desactivar() { activa = false; }
	
	public abstract boolean necesitaEjecucion();
		// Metodo blanco intencionalmente
	
	public abstract int ejecutarTarea();
		// Método blanco intencionalmente
    
}
