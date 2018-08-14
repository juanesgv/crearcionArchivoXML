/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
/**
 *
 * @author juan_esteban.garcia
 */
public class Estudiante extends Persona{
    
     
    private String codigo;
    private String carrera;
    
    /**
     *
     */
    public Estudiante(){
    
    }

        
    
    public Estudiante(String codigo, String carrera, String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    
   
    
   

   
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante = {" + super.toString() + "codigo=" + codigo + ", carrera=" + carrera ;
    }

    public boolean crearArchivoXML(LinkedList<Estudiante> ListaE) {
        
        boolean g = false;
                
                
       try{
           
           Element universidad = new Element ("estudiante"); //elemento = nueva etiqueta
           Document doc = new Document(universidad);
       
           for (int i=0; i < ListaE.size(); i++){
               
               Element estudiante = new Element("estudiante");
               estudiante.addContent(new Element("nombre").setText(
                    ListaE.get(i).getNombre()));
               
               estudiante.addContent(new Element("telefono").setText(
                    ListaE.get(i).getTelefono()));
               
               estudiante.addContent(new Element("correo").setText(
                    ListaE.get(i).getCorreo()));
               
               estudiante.addContent(new Element("codigo").setText(
                    ListaE.get(i).getCodigo()));
              
               estudiante.addContent(new Element("carrera").setText(
                    ListaE.get(i).getCarrera()));
               
               
               doc.getRootElement().addContent(estudiante); // añade y cierra un objetivo para almacenar los datos e impide que otro usuario edite datos
                
           
           }
           
           XMLOutputter xmlOutput = new XMLOutputter();
           xmlOutput.setFormat(Format.getPrettyFormat());
           xmlOutput.output(doc, new FileWriter("universidad.xml"));
           g =true;
       
       } catch(IOException e){
           
           
           System.out.println(e.getMessage());
           g = false;
       }       
                            
                       
                
       return g;
    }
    
    
    
}
