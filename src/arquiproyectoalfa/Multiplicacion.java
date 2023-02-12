/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquiproyectoalfa;

/**
 *
 * @author Java
 */
public class Multiplicacion {

    private Nodo inicio;
    private Nodo fin;

    public ListaCircularDE multiplicacion(ListaCircularDE lista1, ListaCircularDE lista2, ListaCircularDE listaResultadoMult) {

        Nodo aux2 = lista2.fin;
        int contador = 0;

        do {
                Nodo aux1 = lista1.fin;
                Nodo aux3 = listaResultadoMult.fin;
                
                if (contador != 0) {
                    listaResultadoMult.ingresarNodoAlInicio("0");
                    for (int i = 0; i < contador; i++) {
                        aux3 = aux3.anterior;
                    }
                }

                do {
                        int conversionAux1 = Integer.parseInt(aux1.dato);
                        int conversionAux2 = Integer.parseInt(aux2.dato);
                        int multiplicacion = conversionAux1 * conversionAux2;

                        int conversionAux3 = Integer.parseInt(aux3.dato);
                        conversionAux3 = conversionAux3 + multiplicacion;
                        aux3.dato = Integer.toString(conversionAux3);
                        System.out.print(aux3.dato);
                    
                    aux1 = aux1.anterior;
                    aux3 = aux3.anterior;

                } while (aux1 != lista1.fin);
                
                contador = contador + 1;

            aux2 = aux2.anterior;
        } while (aux2 != lista2.fin);
        
        this.correccionDeListaMult(listaResultadoMult);
        
//        System.out.println("");
        return listaResultadoMult;
    }
    
    public void correccionDeListaMult(ListaCircularDE listaResultadoMult){
        
        Nodo aux = listaResultadoMult.fin;
        
        do{
            if(Integer.parseInt(aux.dato) >= 10){
                
                int acarreo = Integer.parseInt(aux.dato) / 10;
                int numero = Integer.parseInt(aux.dato) % 10;
                
                aux.dato = Integer.toString(numero);
                
                if((aux.anterior == listaResultadoMult.fin)&&(acarreo != 0)){
                    listaResultadoMult.ingresarNodoAlInicio(Integer.toString(acarreo));
                }else{
                    aux.anterior.dato = Integer.toString(Integer.parseInt(aux.anterior.dato) + acarreo);
                }
            }
            aux = aux.anterior;
        }while(aux != listaResultadoMult.fin);
    
    }

}
