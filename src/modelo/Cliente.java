/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gullito
 */
public class Cliente implements Serializable{
    private String nombre;
    private String email;
    private String contraseña;
    private List <Entrada> listaEntradas; 

    public Cliente(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;  
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public boolean validarContraseña(String contraseña) {
            return this.contraseña.equals(contraseña);
        }
    
    
}

