/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Gullito
 */
public class Cine implements Serializable{
    private List<Sala> salas;
    private List<Entrada> entradas;
    private HashMap<String, Cliente> clientes;

    public Cine(List<Sala> salas, List<Entrada> entradas, HashMap<String, Cliente> clientes) {
        this.salas = salas;
        this.entradas = entradas;
        this.clientes = clientes;
    }

    public List<Sala> getSalas() {
        return salas;
    }
    
    public void agregarEntrada(Entrada entrada){
        entradas.add(entrada);
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }
    
    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }
      
    public void registrarCliente(Cliente cliente, String usuario){
        clientes.put(usuario, cliente);
    }
    
    public String entradasString(Cliente cliente){
        String resultado = "";
        for (Entrada entrada : entradas){
            if(entrada.getCliente().equals(cliente)){
                resultado += entrada.toString() + "\n";
            }
        }
        return resultado;
    }
    

}
