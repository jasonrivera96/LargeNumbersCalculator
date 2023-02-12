/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquiproyectoalfa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jason
 */
public class Archivos {
    
    public String leerArchivo(String direccion){
        String texto = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = br.readLine()) != null){
                temp = temp + bfRead;
            }
            texto = temp;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se encontró el archivo.");
        }
        return texto;
    }
    
    public void escribirArchivo(String direccion,String dato){
        File archivo;
        FileWriter escribir;
        PrintWriter linea;
        String resultado = "";
        archivo = new File(direccion);
        if(!archivo.exists()){
            try{
                archivo.createNewFile();
                resultado = dato;
                escribir = new FileWriter(archivo, false);
                linea = new PrintWriter(escribir);
                
                linea.println(resultado);
                linea.close();
                escribir.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la creación del archivo.");
            }
            
        }else{
            try{
                resultado = dato;
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                
                linea.println(resultado);
                linea.close();
                escribir.close();
            }catch(IOException ex){
               JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la creación del archivo.");
            }
        }
    }
    
}
