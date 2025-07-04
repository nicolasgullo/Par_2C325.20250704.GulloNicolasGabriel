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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Sala;

/**
 *
 * @author Gullito
 */
public class CompraView extends VBox{
    
    public CompraView(Stage stage, Cine cine, Sala sala, Cliente cliente) {
        Label lbl = new Label("Sala: " + sala.getNumero() + " - " + sala.getPelicula());
        lbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        HBox contenedorTitulo = new HBox(lbl);
        contenedorTitulo.setAlignment(Pos.CENTER);
        
        Label lbl2 = new Label();
        lbl2.setFont(Font.font("Monospaced", 24));
        lbl2.setText(sala.mostrarButacas());
        lbl2.setStyle("-fx-font-size: 32px; -fx-font-weight: bold;");
        HBox contenedorButacas = new HBox(lbl2);
        contenedorButacas.setAlignment(Pos.CENTER);
        
        Label lblComprar = new Label("Ingrese la butaca que desea: ");
        
        Label textfila = new Label("Fila:");
        TextField fila = new TextField();
        Label textcolumna = new Label("Numero:");
        TextField columna = new TextField();
        
        Button btnAceptar = new Button("Comprar");
        Button btnCancelar = new Button("Cancelar");
        
        GridPane grilla = new GridPane();
        grilla.setPadding(new Insets(20));
        grilla.setHgap(10);
        grilla.setVgap(10);
        
        grilla.add(lblComprar, 0, 0);
        grilla.add(textfila, 0, 1);
        grilla.add(fila, 1, 1);
        grilla.add(textcolumna, 0, 2);
        grilla.add(columna, 1, 2);
        grilla.add(btnAceptar, 1, 3);
        grilla.add(btnCancelar, 0, 3);
        
        btnAceptar.setOnAction(e -> {
            try {
                int f = Integer.parseInt(fila.getText());
                int c = Integer.parseInt(columna.getText());
                if (sala.getButaca(f - 1, c - 1).estaOcupada()){
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Butaca ocupada, elija otra.");
                    alerta.showAndWait();
                }else{
                    sala.ocuparButaca(f - 1, c - 1);
                    Entrada entrada = new Entrada(cliente, sala, sala.getButaca(f - 1, c - 1));
                    cine.agregarEntrada(entrada);
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Compra exitosa \n" + entrada.toString() + "\n Gracias por su compra " + cliente.getNombre() );
                    alerta.showAndWait();
                    lbl2.setText(sala.mostrarButacas());
                }
                
            } catch (NumberFormatException | IndexOutOfBoundsException nfe) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION, "[ERROR] Butaca invalida.");
                alerta.showAndWait();
            }
        });
        
        btnCancelar.setOnAction( e -> {
            MenuView menu = new MenuView(stage, cine, cliente);
            stage.setScene(new Scene(menu));
        });
        
        getChildren().addAll(contenedorTitulo, contenedorButacas, grilla);
    } 
    
    
}