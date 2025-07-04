/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Sala;

/**
 *
 * @author Gullito
 */
public class PersistenciaDatos {
    private static final String ARCHIVO = "cine.ser";
    
    public static void guardar(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(cine);
        } catch (IOException ioe) {
            System.out.println("Error guardando cine: " + ioe.getMessage());
        }
    }
    
    public static Cine cargar(){
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            HashMap<String, Cliente> clientes = new HashMap<>();
            List<Sala> salas = new ArrayList<>();
            salas.add(new Sala(1, "Star Wars - Capitulo I", 4, 6));
            salas.add(new Sala(2, "Star Wars - Capitulo II", 4, 6));
            salas.add(new Sala(3, "Star Wars - Capitulo III", 4, 6));
            salas.add(new Sala(4, "Star Wars - Capitulo IV", 4, 6));
            List<Entrada> entradas = new ArrayList<>();
            Cine cine = new Cine(salas, entradas, clientes);
            return cine;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
           return (Cine) ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Error cargando el cine: " + ioe.getMessage());
            HashMap<String, Cliente> clientes = new HashMap<>();
            List<Sala> salas = new ArrayList<>();
            salas.add(new Sala(1, "Star Wars - Capitulo I", 4, 6));
            salas.add(new Sala(2, "Star Wars - Capitulo II", 4, 6));
            salas.add(new Sala(3, "Star Wars - Capitulo III", 4, 6));
            salas.add(new Sala(4, "Star Wars - Capitulo IV", 4, 6));
            List<Entrada> entradas = new ArrayList<>();
            Cine cine = new Cine(salas, entradas, clientes);
            return cine;
        }
    }
}