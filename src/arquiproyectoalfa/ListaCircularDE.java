/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquiproyectoalfa;

import java.util.PrimitiveIterator;

/**
 *
 * @author Jason
 */
public class ListaCircularDE {
    //propiedades

    Nodo inicio;
    Nodo fin;

    public ListaCircularDE() {
        inicio = null;
        fin = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public void ingresarNodoAlFinal(String nuevoNodo) {
        Nodo nuevo = new Nodo();
        nuevo.dato = nuevoNodo;

        if (inicio == null) {
            inicio = nuevo;
            inicio.siguiente = inicio;
            inicio.anterior = fin;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            nuevo.siguiente = inicio;
            nuevo.anterior = fin;
            fin = nuevo;
            inicio.anterior = fin;
        }
    }

    public void ingresarNodoAlInicio(String dato) {
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
            inicio.siguiente = fin;
            fin.siguiente = inicio;
            inicio.anterior = fin;
        } else {
            inicio.anterior = nuevo;
            nuevo.anterior = fin;
            nuevo.siguiente = inicio;
            inicio = nuevo;
            fin.siguiente = inicio;
        }

    }

    //método de impresion de la lista
    public String imprimirLista() {
        String informacion = "";
        Nodo aux = new Nodo();
        aux = inicio;
        do {
            System.out.print("[" + aux.dato + "]");
            informacion = informacion + aux.dato;
            aux = aux.siguiente;
        } while (aux != inicio);
        System.out.println("");
        return informacion;
    }

    //método para encontrar el tamaño de la parte entera
    public int encontrarTamañoEnteros() {
        int contador = 0;
        if (!estaVacia()) {
            Nodo aux = inicio;
            Nodo aux2 = new Nodo(",");
            while ((!aux.dato.equals(aux2.dato))) {
                contador = contador + 1;
                aux = aux.siguiente;
            }
//            System.out.println(contador + " enteros antes de la coma");
        }
        return contador;
    }

    //método para encontrar el tamaño de la parte decimal
    public int encontrarTamañoDecimales() {
        int contador = 0;
        if (!estaVacia()) {
            Nodo aux = fin;
            Nodo aux2 = new Nodo(",");
            while ((!aux.dato.equals(aux2.dato))) {
                contador = contador + 1;
                aux = aux.anterior;
            }
//            System.out.println(contador +" digitos despues de la coma");
        }
        return contador;
    }

    //método para reconocer el signo del número
    public boolean reconocerSigno(ListaCircularDE lista) {
        boolean signo = false;
        Nodo aux = inicio;
        if (aux.dato.equals("-")) {
            signo = true;
        }
        return signo;
    }

    // método para borrar el signo
    public void borrarSigno(ListaCircularDE lista) {
        inicio = inicio.siguiente;
        fin.siguiente = inicio;
        inicio.anterior = fin;
    }

    public void borrarUltimoElemento(ListaCircularDE lista) {
        fin = fin.anterior;
        inicio.anterior = fin;
        fin.siguiente = inicio;
    }

    //método para comparar las listas
    public int comparar(ListaCircularDE lista1, ListaCircularDE lista2) {
        Nodo aux1 = lista1.inicio;
        Nodo aux2 = lista2.inicio;
        int caso = 0;
        do {
            //condicion, que se cumplira mientras el dato de la lista sea diferente de una coma
            if (!aux1.dato.equals(",")) {
                if (Integer.parseInt(aux1.dato) > Integer.parseInt(aux2.dato)) {
                    caso = 1;
                }
                if (Integer.parseInt(aux1.dato) < Integer.parseInt(aux2.dato)) {
                    caso = 2;
                }
            }
            aux1 = aux1.siguiente;
            aux2 = aux2.siguiente;
            //el proceso se dara hasta que el auxiliar sea diferente del primer numero de la lista
            // o que la variable caso sea igual a 1 u 2
        } while ((aux1 != lista1.inicio) && (caso != 1) && (caso != 2));

        return caso;
    }

    public boolean verificadorComa(ListaCircularDE lista) {
        boolean verificador = false;
        Nodo aux = inicio;
        do {
            if (aux.dato.equals(",")) {
                verificador = true;
            }
            aux = aux.siguiente;
        } while (aux != inicio);
        return verificador;
    }

    public void vaciarLista(ListaCircularDE lista1) {
        Nodo aux = inicio;
        inicio = fin = null;
    }

    public void traspasoDeDatos(ListaCircularDE lista1, ListaCircularDE otraLista) {
        Nodo aux1 = lista1.inicio;
        Nodo aux2 = otraLista.inicio;
        do {
            aux1.dato = aux2.dato;
            aux1 = aux1.siguiente;
            aux2 = aux2.siguiente;
        } while (aux1 != lista1.inicio);

    }

    public void borrarComa(ListaCircularDE lista) {
        Nodo aux = lista.fin;
        Nodo aux2 = aux.anterior;
        boolean encontrada = false;
        do {

            if (aux.dato.equals(",")) {
                aux2.siguiente = aux.siguiente;
                aux.siguiente.anterior = aux2;
                encontrada = true;
            }

            aux = aux.anterior;
            aux2 = aux2.anterior;

        } while (encontrada != true);
    }

    public void ponerComa(ListaCircularDE listaResultado, int tamanioParaComa) {
        Nodo aux = listaResultado.fin;
        Nodo aux2 = aux.siguiente;
        for (int i = tamanioParaComa; i > 0; i--) {
            aux = aux.anterior;
            aux2 = aux2.anterior;
        }

        Nodo coma = new Nodo(",", aux2, aux);
        aux.siguiente = coma;
        aux2.anterior = coma;

    }

    public void traspasoMultiplicacion(ListaCircularDE lista1, ListaCircularDE listaResultado) {
        lista1.vaciarLista(lista1);
        Nodo aux = listaResultado.inicio;
        do {
            lista1.ingresarNodoAlFinal(aux.dato);
            aux = aux.siguiente;
        } while (aux != listaResultado.inicio);

    }

    public void borrarCerosInnecesarios(ListaCircularDE lista) {
        Nodo auxIzquierda = lista.inicio;
        Nodo auxDerecha = lista.fin;

        while ((Integer.parseInt(auxIzquierda.dato) == 0) && (!auxIzquierda.siguiente.dato.equals(","))) {
            lista.borrarSigno(lista);
            auxIzquierda = auxIzquierda.siguiente;
        }

        while ((Integer.parseInt(auxDerecha.dato) == 0) && (!auxDerecha.anterior.dato.equals(","))) {
            lista.borrarUltimoElemento(lista);
            auxDerecha = auxDerecha.anterior;
        }
    }

    public int borrarSoloCerosIzquierda(ListaCircularDE lista) {
        int contador = 0;
        Nodo auxIzquierda = lista.inicio;
        while (Integer.parseInt(auxIzquierda.dato) == 0) {
            lista.borrarSigno(lista);
            auxIzquierda = auxIzquierda.siguiente;
            contador = contador + 1;
        }
        return contador;
    }

    public int encontrarTamañoDeTodaLaLista(ListaCircularDE lista) {
        Nodo aux = lista.inicio;
        int contador = 0;
        do {
            contador = contador + 1;
            aux = aux.siguiente;
        } while (aux != lista.inicio);

        return contador;
    }

    public int comparacionParaDivision(ListaCircularDE lista1, ListaCircularDE lista2) {
        Nodo aux1 = lista1.inicio;
        Nodo aux2 = lista2.inicio;
        int caso = 0;
        do {

            if (lista1.encontrarTamañoDeTodaLaLista(lista1) > lista2.encontrarTamañoDeTodaLaLista(lista2)) {
                caso = 1;
            }

            if (lista1.encontrarTamañoDeTodaLaLista(lista1) < lista2.encontrarTamañoDeTodaLaLista(lista2)) {
                caso = 2;
            }

            if (lista1.encontrarTamañoDeTodaLaLista(lista1) == lista2.encontrarTamañoDeTodaLaLista(lista2)) {
                if (Integer.parseInt(aux1.dato) > Integer.parseInt(aux2.dato)) {
                    caso = 1;
                }
                if (Integer.parseInt(aux1.dato) < Integer.parseInt(aux2.dato)) {
                    caso = 2;
                }
            }

            aux1 = aux1.siguiente;
            aux2 = aux2.siguiente;
        } while ((aux1 != lista1.inicio) && (caso != 1) && (caso != 2));
        return caso;
    }

    public boolean verificarListaEncerada(ListaCircularDE lista) {
        boolean completaDeCeros = true;
        Nodo aux = lista.inicio;
        do {
            if (Integer.parseInt(aux.dato) != 0) {
                completaDeCeros = false;
            }
            aux = aux.siguiente;
        } while ((aux != lista.inicio) && (completaDeCeros != false));

        return completaDeCeros;
    }

    public boolean bajoLaSiguienteCifra(ListaCircularDE listaDividendo, ListaCircularDE lista1) {
        Nodo aux1 = lista1.inicio;
        Nodo aux2 = listaDividendo.inicio;
        boolean parar = false;
        boolean iguales = false;
        if (lista1.encontrarTamañoDeTodaLaLista(lista1) > listaDividendo.encontrarTamañoDeTodaLaLista(listaDividendo)) {
            do {
                if ((aux1.siguiente != lista1.inicio) && (aux2.siguiente == listaDividendo.inicio)) {
                    listaDividendo.ingresarNodoAlFinal(aux1.siguiente.dato);
                    parar = true;
                }
                if(lista1.encontrarTamañoDeTodaLaLista(lista1) == listaDividendo.encontrarTamañoDeTodaLaLista(listaDividendo)){
                    iguales = true;
                }
                aux1 = aux1.siguiente;
                aux2 = aux2.siguiente;
            } while (parar == false);
        } else {
            iguales = true;
        }
        return iguales;
    }

    public boolean verificarDivisionesConCero(ListaCircularDE lista) {
        boolean completaDeCeros = true;
        Nodo aux = lista.inicio;
        do {
            if (!aux.dato.equals(",")) {
                if (Integer.parseInt(aux.dato) != 0) {
                    completaDeCeros = false;
                }
            }
            aux = aux.siguiente;
        } while ((aux != lista.inicio) && (completaDeCeros != false));
        
        return completaDeCeros;
    }
    
}
