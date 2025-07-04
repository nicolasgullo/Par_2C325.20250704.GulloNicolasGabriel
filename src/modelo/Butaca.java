/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Gullito
 */
public class Butaca implements Serializable{
    private int numero;
    private int fila;
    private boolean estado;
    
    public Butaca(int fila, int numero, boolean estado) {
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }

    public boolean estaOcupada() {
        return estado; 
    }
    
    public void setOcupada(boolean estado) {
        this.estado = estado; 
    }
    
    @Override
    public String toString(){
        return " Butaca: Fila: " + (fila + 1) + " Numero: " + (numero + 1);
    }
    
    
}
