/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cine;
import modelo.Cliente;
import modelo.Sala;

/**
 *
 * @author Gullito
 */
public class MenuView extends VBox{

    public MenuView(Stage stage, Cine cine, Cliente cliente) {
        Label bienvenida = new Label("Bienvenido al Cine, elija una pelicula");
        bienvenida.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        HBox contenedorTitulo = new HBox(bienvenida);
        contenedorTitulo.setAlignment(Pos.CENTER);
        
        Button btnPelicula1 = new Button("Pelicula 1");
        Button btnPelicula2 = new Button("Pelicula 2");
        Button btnPelicula3 = new Button("Pelicula 3");
        Button btnPelicula4 = new Button("Pelicula 4");
        Button btnEntradas = new Button("Mis Entradas");
        Button btnSalir = new Button("Salir");
        
        GridPane grilla = new GridPane();
        grilla.setPadding(new Insets(20));
        
        grilla.setHgap(10);
        grilla.setVgap(10);
        
        grilla.add(btnPelicula1, 0, 0);
        grilla.add(btnPelicula2, 0, 1);
        grilla.add(btnPelicula3, 0, 2);
        grilla.add(btnPelicula4, 0, 3);
        grilla.add(btnEntradas, 9, 0);
        grilla.add(btnSalir, 9, 1);
        
        btnPelicula1.setOnAction( e -> {
            Sala sala = cine.getSalas().get(0);
            CompraView vista = new CompraView(stage, cine, sala, cliente);
            stage.setScene(new Scene(vista));
        });

        btnPelicula2.setOnAction( e -> {
            Sala sala = cine.getSalas().get(1);
            CompraView vista = new CompraView(stage, cine, sala, cliente);
            stage.setScene(new Scene(vista));
        });
        
        btnPelicula3.setOnAction( e -> {
            Sala sala = cine.getSalas().get(2);
            CompraView vista = new CompraView(stage, cine, sala, cliente);
            stage.setScene(new Scene(vista));
        });
        
        btnPelicula4.setOnAction( e -> {
            Sala sala = cine.getSalas().get(3);
            CompraView vista = new CompraView(stage, cine, sala, cliente);
            stage.setScene(new Scene(vista));
        });
        
        btnEntradas.setOnAction( e -> {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, ("MIS ENTRADAS: \n " + cine.entradasString(cliente)));
            alerta.showAndWait();
        });
        
        btnSalir.setOnAction( e -> {
            LoginView login = new LoginView(stage, cine);
            stage.setScene(new Scene(login));
        });
        
        getChildren().addAll(contenedorTitulo, grilla);
    }
    
}

