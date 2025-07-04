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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cine;
import modelo.Cliente;

/**
 *
 * @author Gullito
 */
public class LoginView extends VBox{ 
    
    public LoginView(Stage stage, Cine cine) {
            Label lblInicio = new Label("Inicio de Sesión");
            lblInicio.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            HBox contenedorTitulo = new HBox(lblInicio);
            contenedorTitulo.setAlignment(Pos.CENTER);
            
            Label lblUser = new Label("Usuario");
            TextField campoUsuario = new TextField();
            
            Label lblPw = new Label("Contraseña");
            PasswordField campoContraseña = new PasswordField();
            
            Button btnIngresar =new Button("Ingresar");
            Button btnRegistrarse = new Button("Registrarse");
            
            GridPane grilla = new GridPane();
            grilla.setPadding(new Insets(20));
            
            grilla.add(lblUser, 0, 0);            
            grilla.add(campoUsuario, 1, 0);
            grilla.add(lblPw, 0, 1);            
            grilla.add(campoContraseña, 1, 1);
            grilla.add(btnIngresar, 0, 2);    
            grilla.add(btnRegistrarse, 1, 2);   
            
            grilla.setHgap(10);
            grilla.setVgap(10);
            grilla.setAlignment(Pos.CENTER);
            
            btnIngresar.setOnAction( e -> {
                String usuario = campoUsuario.getText();
                String contraseña = campoContraseña.getText();
                Cliente cliente = cine.getClientes().get(usuario);
                
                if (cliente != null && cliente.validarContraseña(contraseña)) {
                    MenuView menu = new MenuView(stage, cine, cliente);
                    stage.setScene(new Scene(menu));
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION, "[ERROR] Usuario o contraseña incorrectos.");
                    alerta.showAndWait();
                }
            });
            
            btnRegistrarse.setOnAction( e -> {
               RegistroView registro = new RegistroView(stage, cine); 
               stage.setScene(new Scene(registro));
            });
            
            getChildren().addAll(contenedorTitulo, grilla);
    }
}
