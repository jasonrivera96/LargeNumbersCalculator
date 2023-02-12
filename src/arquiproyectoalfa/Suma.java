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
public class Suma {

    private Nodo inicio;
    private Nodo fin;

    public ListaCircularDE sumaDePositivos(ListaCircularDE lista1, ListaCircularDE lista2) {

        Nodo aux1 = lista1.fin;
        Nodo aux2 = lista2.fin;
        int acarreo = 0;

        do {
            if (!aux1.dato.equals(",")) {
                if (acarreo == 1) {
                    int conversion = Integer.parseInt(aux1.dato);
                    conversion = conversion + 1;
                    aux1.dato = Integer.toString(conversion);
                    acarreo = 0;
                }

                int conversionAux1 = Integer.parseInt(aux1.dato);
                int conversionAux2 = Integer.parseInt(aux2.dato);
                int conversionSuma = conversionAux1 + conversionAux2;
                aux1.dato = Integer.toString(conversionSuma);

                if (Integer.parseInt(aux1.dato) >= 10) {
                    int conversion = Integer.parseInt(aux1.dato);
                    conversion = conversion - 10;
                    aux1.dato = Integer.toString(conversion);
                    acarreo = 1;
                }
                System.out.print(aux1.dato);
            }

            aux1 = aux1.anterior;
            aux2 = aux2.anterior;
        } while (aux1 != lista1.fin);
        
        if(acarreo == 1){
            lista1.ingresarNodoAlInicio("1");
        }
//        System.out.println("");

        return lista1;
    }
    
    public ListaCircularDE sumaDeSignosDiferentes(ListaCircularDE lista1, ListaCircularDE lista2){
        Nodo aux1 = lista1.fin;
        Nodo aux2 = lista2.fin;
        
        do {
            if (!aux1.dato.equals(",")) {
                int conversionAux1 = Integer.parseInt(aux1.dato);
                int conversionAux2 = Integer.parseInt(aux2.dato);
                int conversionResta = conversionAux1 - conversionAux2;
                aux1.dato = Integer.toString(conversionResta);

                if(Integer.parseInt(aux1.dato) < 0){
                    if(!aux1.anterior.dato.equals(",")){
                        aux1.anterior.dato = Integer.toString(Integer.parseInt(aux1.anterior.dato) - 1);
                    }
                    if(aux1.anterior.dato.equals(",")){
                        aux1.anterior.anterior.dato = Integer.toString(Integer.parseInt(aux1.anterior.anterior.dato) - 1);
                    }
                    
                    if(Integer.parseInt(aux1.dato) == -1){
                        aux1.dato = "9";
                    }
                    if(Integer.parseInt(aux1.dato) == -2){
                        aux1.dato = "8";
                    }
                    if(Integer.parseInt(aux1.dato) == -3){
                        aux1.dato = "7";
                    }
                    if(Integer.parseInt(aux1.dato) == -4){
                        aux1.dato = "6";
                    }
                    if(Integer.parseInt(aux1.dato) == -5){
                        aux1.dato = "5";
                    }
                    if(Integer.parseInt(aux1.dato) == -6){
                        aux1.dato = "4";
                    }
                    if(Integer.parseInt(aux1.dato) == -7){
                        aux1.dato = "3";
                    }
                    if(Integer.parseInt(aux1.dato) == -8){
                        aux1.dato = "2";
                    }
                    if(Integer.parseInt(aux1.dato) == -9){
                        aux1.dato = "1";
                    }
                    if(Integer.parseInt(aux1.dato) == -10){
                        aux1.dato = "0";
                    }
                }
            }
            System.out.print(aux1.dato);
            aux1 = aux1.anterior;
            aux2 = aux2.anterior;
        } while (aux1 != lista1.fin);
        
//        System.out.println("");
        return lista1;
    }
    

}
