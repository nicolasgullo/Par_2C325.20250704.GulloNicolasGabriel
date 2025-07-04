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
public class Sala implements Serializable{
    private int numero;
    private String pelicula;
    private Butaca[][] butacas;
    
    public Sala(int numero, String pelicula, int filas, int columnas) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.butacas = new Butaca[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                butacas[i][j] = new Butaca(i, j, false);
            }
        }
    }
   
    public String mostrarButacas() {
    
        String resultado = "";
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++) {
                if (butacas[i][j].estaOcupada()) {
                   resultado += "[x]";
                } else {
                resultado += "[  ]";
            }
        }
        resultado += "\n";
    }
        return resultado;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getPelicula() {
        return pelicula;
    }

    public Butaca getButaca(int fila, int columna){
            return butacas[fila][columna];
    }
    
    public Butaca[][] getButacas() {
        return butacas;
    }

    
    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public void ocuparButaca(int fila, int columna) {
        butacas[fila][columna].setOcupada(true);
    }
    
    @Override
    public String toString(){
        return "Pelicula: " + pelicula + ", Sala: " + numero;
    }
    
}
