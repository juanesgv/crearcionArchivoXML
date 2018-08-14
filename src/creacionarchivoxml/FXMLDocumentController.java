/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacionarchivoxml;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Estudiante;

/**
 *
 * @author juan_esteban.garcia
 */
public class FXMLDocumentController implements Initializable {
    
   
    
    @FXML
    private TextField nombreEstdudiante;
    
    @FXML
    private TextField telefono; 
    
    @FXML
    private TextField correo; 
    
    @FXML
    private TextField codigo; 
    
    @FXML
    private TextField carrera; 
    
    LinkedList<Estudiante> ListaE;
    
    @FXML
    private void handleButtonAction(ActionEvent e){
     
    
    }
    
    @FXML
    private void agregarEstdudiante (ActionEvent e){
        
         String nombre = nombreEstdudiante.getText();
         String telefonoE = telefono.getText();
         String correoE = correo.getText();
         String codigoE = codigo.getText();
         String carreraE = carrera.getText();
         
         Estudiante objE = new Estudiante(codigoE, carreraE, nombre, telefonoE, correoE);
         ListaE.add(objE);
        
        
        
        
    }
    
    @FXML
    private void guardarArchivo(ActionEvent e){
        
        Estudiante objeV = new Estudiante();
        boolean guardar = objeV.crearArchivoXML(ListaE);
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ListaE = new LinkedList<>();
    }    
    
}
