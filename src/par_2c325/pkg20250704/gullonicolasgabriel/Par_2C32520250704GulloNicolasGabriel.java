/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package par_2c325.pkg20250704.gullonicolasgabriel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Cine;
import persistencia.PersistenciaDatos;
import vista.LoginView;

/**
 *
 * @author Gullito
 */
public class Par_2C32520250704GulloNicolasGabriel extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Cine cine = PersistenciaDatos.cargar();
        
        LoginView login = new LoginView(stage, cine);
        stage.setScene(new Scene(login));
        stage.setTitle("CINE");
        
        stage.setOnCloseRequest(eh -> PersistenciaDatos.guardar(cine));
        
        stage.show();
    }
    
}

