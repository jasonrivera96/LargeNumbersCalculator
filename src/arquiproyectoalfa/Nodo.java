/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquiproyectoalfa;

/**
 *
 * @author Jason
 */
public class Nodo {
    public String dato;
    Nodo siguiente;
    Nodo anterior;

    public Nodo() {
    }
    
    //Constructor para cuando aun no hay nodos
    public Nodo(String elemento){
        this(elemento, null, null);
    }
    
    //Constructor para cuando ya hay nodos
    public Nodo(String elemento, Nodo sig, Nodo ant){
        dato  = elemento;
        siguiente = sig;
        anterior = ant;
    }
    
}
