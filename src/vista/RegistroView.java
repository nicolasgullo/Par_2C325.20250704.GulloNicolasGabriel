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
public class RegistroView extends VBox{ 
    
    public RegistroView(Stage stage, Cine cine) {
            Label lblRegistro = new Label("Registro");
            lblRegistro.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            HBox contenedorTitulo = new HBox(lblRegistro);
            contenedorTitulo.setAlignment(Pos.CENTER);
            
            Label lblUser = new Label("Usuario");
            TextField campoUsuario = new TextField();
            Label lblNombre = new Label("Nombre");
            TextField campoNombre = new TextField();
            Label lblPw = new Label("Contraseña");
            PasswordField campoContraseña = new PasswordField();
            Label lblEmail = new Label("Correo");
            TextField campoEmail = new TextField();
            
            Button btnRegistrarse = new Button("Registrarse");
            Button btnSalir = new Button("Salir");
    
            GridPane grilla = new GridPane();
            grilla.setPadding(new Insets(20));
            grilla.setHgap(10);
            grilla.setVgap(10);
        
            grilla.add(lblUser, 0, 0);
            grilla.add(campoUsuario, 1, 0);
            grilla.add(lblNombre, 0, 1);
            grilla.add(campoNombre, 1, 1);
            grilla.add(lblPw, 0, 2);
            grilla.add(campoContraseña, 1, 2);
            grilla.add(lblEmail, 0, 3);
            grilla.add(campoEmail, 1, 3);
            grilla.add(btnRegistrarse, 1, 4);
            grilla.add(btnSalir, 0, 4);
            
            btnRegistrarse.setOnAction( e -> {
                String usuario = campoUsuario.getText();
                String nombre = campoNombre.getText();
                String email = campoEmail.getText();
                String contraseña = campoContraseña.getText();
                Cliente cliente = new Cliente(nombre, email, contraseña);
                if (cine.getClientes().containsKey(usuario) || usuario.trim().isEmpty() || contraseña.trim().isEmpty() || email.trim().isEmpty() || contraseña.trim().isEmpty()){
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION,"Error al crear Usuario, ingrese los datos correctamente");
                    alerta.showAndWait();
                }else{
                    cine.registrarCliente(cliente, usuario);
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION,"REGISTRADO CON ÉXITO!");
                    alerta.showAndWait();
                    LoginView login = new LoginView(stage, cine);
                    stage.setScene(new Scene(login));
                }
            });
            
            btnSalir.setOnAction( e -> {
                LoginView login = new LoginView(stage, cine);
                stage.setScene(new Scene(login));
            });

            getChildren().addAll(contenedorTitulo, grilla);
    }
    
}
