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
public class DivisionSegundoIntento{

    private Nodo inicio;
    private Nodo fin;
    private ListaCircularDE listaNum1 = new ListaCircularDE();
    private ListaCircularDE listaNum2 = new ListaCircularDE();
    private ListaCircularDE listaNum3 = new ListaCircularDE();
    private ListaCircularDE listaNum4 = new ListaCircularDE();
    private ListaCircularDE listaNum5 = new ListaCircularDE();
    private ListaCircularDE listaNum6 = new ListaCircularDE();
    private ListaCircularDE listaNum7 = new ListaCircularDE();
    private ListaCircularDE listaNum8 = new ListaCircularDE();
    private ListaCircularDE listaNum9 = new ListaCircularDE();
    private ListaCircularDE listaDivisor = new ListaCircularDE();
    private ListaCircularDE listaDividendo = new ListaCircularDE();
    private ListaCircularDE listaResultadoMult = new ListaCircularDE();
    private ListaCircularDE listaAuxiliarResultados = new ListaCircularDE();
    private int numeroCorrecto;

    public ListaCircularDE divisionSegundoIntento(ListaCircularDE lista1, ListaCircularDE lista2, ListaCircularDE listaCociente) {
        Archivos archivo = new Archivos();
        
        listaNum1.ingresarNodoAlFinal("1");
        listaNum2.ingresarNodoAlFinal("2");
        listaNum3.ingresarNodoAlFinal("3");
        listaNum4.ingresarNodoAlFinal("4");
        listaNum5.ingresarNodoAlFinal("5");
        listaNum6.ingresarNodoAlFinal("6");
        listaNum7.ingresarNodoAlFinal("7");
        listaNum8.ingresarNodoAlFinal("8");
        listaNum9.ingresarNodoAlFinal("9");
        listaDivisor.ingresarNodoAlFinal("0");
        Calculadora cal = new Calculadora();
        boolean agregarCero = true;

        while ((Integer.parseInt(lista1.fin.dato) == 0) && (Integer.parseInt(lista2.fin.dato) == 0)) {
            lista1.borrarUltimoElemento(lista1);
            lista2.borrarUltimoElemento(lista2);
        }
        listaDivisor.traspasoMultiplicacion(listaDivisor, lista2);
        listaDividendo.traspasoMultiplicacion(listaDividendo, lista2);

        boolean stop = false;
        if (lista1.encontrarTamañoDeTodaLaLista(lista1) > lista2.encontrarTamañoDeTodaLaLista(lista2)) {
            agregarCero = false;
            listaDividendo.traspasoDeDatos(listaDividendo, lista1);
            do {
                
                if (this.comparandoEnEstaClase(listaDividendo, lista2) == 2) {
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    listaDividendo.borrarUltimoElemento(listaDividendo);
                    listaDividendo.borrarUltimoElemento(listaDividendo);

                if (listaDividendo.bajoLaSiguienteCifra(listaDividendo, lista1) == true) {
                        lista1.vaciarLista(lista1);
                        lista1.traspasoMultiplicacion(lista1, listaDividendo);
                        stop = true;
                    }

                }
                if (stop == false) {
                    double cerosBorrados = listaDividendo.borrarSoloCerosIzquierda(listaDividendo);
                    this.sigNumeroParaElCociente(listaDividendo, lista2);
                    
                    listaCociente.ingresarNodoAlFinal(Integer.toString(numeroCorrecto));
                    
                    for(int i = 0; i<cerosBorrados ; i++){
                        listaDividendo.ingresarNodoAlInicio("0");
                    }
                    
                    if((this.comparandoEnEstaClase(listaDividendo, lista2) == 1) || (this.comparandoEnEstaClase(listaDividendo, lista2) == 0)){
                        Suma sum = new Suma();
                        cal.igualarListas(listaDividendo, lista2);
                        sum.sumaDeSignosDiferentes(listaDividendo, lista2);
                        listaDividendo.borrarUltimoElemento(lista1);
                        listaDividendo.borrarUltimoElemento(lista1);
                    }
                    
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                }

            } while (stop == false);
        }
        
        if (lista1.verificarListaEncerada(lista1) == true) {
                lista1.vaciarLista(lista1);
                lista1.ingresarNodoAlFinal("0");
            } else {
                lista1.borrarSoloCerosIzquierda(lista1);
            }
        
        lista1.ingresarNodoAlFinal(",");
        lista1.ingresarNodoAlFinal("0");
        lista2.ingresarNodoAlFinal(",");
        lista2.ingresarNodoAlFinal("0");
        cal.igualarListas(lista1, lista2);
        lista1.borrarUltimoElemento(lista1);
        lista1.borrarUltimoElemento(lista1);
        lista2.borrarUltimoElemento(lista2);
        lista2.borrarUltimoElemento(lista2);
        
        if (lista1.encontrarTamañoDeTodaLaLista(lista1) < lista2.encontrarTamañoDeTodaLaLista(lista2)) {
            lista1.ingresarNodoAlFinal("0");
            listaCociente.ingresarNodoAlFinal("0");
            listaCociente.ingresarNodoAlFinal(",");
        }
        if (lista1.encontrarTamañoDeTodaLaLista(lista1) == lista2.encontrarTamañoDeTodaLaLista(lista2)) {
            if (lista1.comparacionParaDivision(lista1, lista2) == 2) {
                    lista1.ingresarNodoAlFinal("0");
                    listaCociente.ingresarNodoAlFinal("0");
                listaCociente.ingresarNodoAlFinal(",");
            }
        }
        
        while (lista1.encontrarTamañoDeTodaLaLista(lista1) < lista2.encontrarTamañoDeTodaLaLista(lista2)) {
            lista1.ingresarNodoAlFinal("0");
            listaCociente.ingresarNodoAlFinal("0");
        }
        
        int precisionDecimal = 0;
        do {
            if (lista1.comparacionParaDivision(lista1, lista2) == 2){
                lista1.ingresarNodoAlFinal("0");
                if (listaCociente.verificadorComa(listaCociente) == false) {
                    listaCociente.ingresarNodoAlFinal(",");
                }

            }

            this.sigNumeroParaElCociente(lista1, lista2);
            listaCociente.ingresarNodoAlFinal(Integer.toString(numeroCorrecto));
            

            if ((lista1.comparacionParaDivision(lista1, lista2) == 1) || (lista1.comparacionParaDivision(lista1, lista2) == 0)) {
                Suma sum = new Suma();
                lista1.ingresarNodoAlFinal(",");
                lista1.ingresarNodoAlFinal("0");
                lista2.ingresarNodoAlFinal(",");
                lista2.ingresarNodoAlFinal("0");

                cal.igualarListas(lista1, lista2);
                sum.sumaDeSignosDiferentes(lista1, lista2);
                lista1.borrarCerosInnecesarios(lista1);
                lista1.borrarUltimoElemento(lista1);
                lista1.borrarUltimoElemento(lista1);
            }

            if (lista1.verificarListaEncerada(lista1) == true) {
                lista1.vaciarLista(lista1);
                lista1.ingresarNodoAlFinal("0");
            } else {
                lista1.borrarSoloCerosIzquierda(lista1);
            }

            lista2.traspasoMultiplicacion(lista2, listaDivisor);
            
            listaCociente.imprimirLista();
            listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
            precisionDecimal = precisionDecimal + 1;

        } while ((lista1.inicio.dato != "0")&&(precisionDecimal < 55));

        System.out.print("Residuo actual: ");
        lista1.imprimirLista();

        return listaCociente;
    }

    public void multiplicacion(ListaCircularDE lista1, ListaCircularDE lista2, ListaCircularDE listaResultados) {
        if (lista1.verificadorComa(lista1) == false) {
            lista1.ingresarNodoAlFinal(",");
            lista1.ingresarNodoAlFinal("0");
        }
        if (lista2.verificadorComa(lista2) == false) {
            lista2.ingresarNodoAlFinal(",");
            lista2.ingresarNodoAlFinal("0");
        }

        boolean signolista1 = lista1.reconocerSigno(lista1);
        boolean signolista2 = lista2.reconocerSigno(lista2);
        int tamanioParaComa = lista1.encontrarTamañoDecimales() + lista2.encontrarTamañoDecimales();
        int tamanioLista1 = lista1.encontrarTamañoEnteros() + lista1.encontrarTamañoDecimales();

        if ((signolista1 == false) && (signolista2 == true)) {
            lista2.borrarSigno(lista2);
            lista1.borrarComa(lista1);
            lista2.borrarComa(lista2);

            for (int i = 0; i < tamanioLista1; i++) {
                listaResultados.ingresarNodoAlFinal("0");
            }

            Multiplicacion mult = new Multiplicacion();
            mult.multiplicacion(lista1, lista2, listaResultados);

            listaResultados.ponerComa(listaResultados, tamanioParaComa);
            listaResultados.borrarCerosInnecesarios(listaResultados);
            listaResultados.ingresarNodoAlInicio("-");
            lista1.traspasoMultiplicacion(lista1, listaResultados);

        }
        if ((signolista1 == true) && (signolista2 == false)) {
            lista1.borrarSigno(lista1);
            lista1.borrarComa(lista1);
            lista2.borrarComa(lista2);

            for (int i = 0; i < tamanioLista1 - 1; i++) {
                listaResultados.ingresarNodoAlFinal("0");
            }

            Multiplicacion mult = new Multiplicacion();
            mult.multiplicacion(lista1, lista2, listaResultados);

            listaResultados.ponerComa(listaResultados, tamanioParaComa);
            listaResultados.borrarCerosInnecesarios(listaResultados);
            listaResultados.ingresarNodoAlInicio("-");
            lista1.traspasoMultiplicacion(lista1, listaResultados);

        }
        if ((signolista1 == false) && (signolista2 == false)) {

            lista1.borrarComa(lista1);
            lista2.borrarComa(lista2);

            for (int i = 0; i < tamanioLista1; i++) {
                listaResultados.ingresarNodoAlFinal("0");
            }

            Multiplicacion mult = new Multiplicacion();
            mult.multiplicacion(lista1, lista2, listaResultados);

            listaResultados.ponerComa(listaResultados, tamanioParaComa);
            listaResultados.borrarCerosInnecesarios(listaResultados);
            lista1.traspasoMultiplicacion(lista1, listaResultados);

        }

        if ((signolista1 == true) && (signolista2 == true)) {
            lista1.borrarSigno(lista1);
            lista2.borrarSigno(lista2);
            lista1.borrarComa(lista1);
            lista2.borrarComa(lista2);

            for (int i = 0; i < tamanioLista1 - 1; i++) {
                listaResultados.ingresarNodoAlFinal("0");
            }

            Multiplicacion mult = new Multiplicacion();
            mult.multiplicacion(lista1, lista2, listaResultados);

            listaResultados.ponerComa(listaResultados, tamanioParaComa);
            listaResultados.borrarCerosInnecesarios(listaResultados);
            lista1.traspasoMultiplicacion(lista1, listaResultados);
        }
    }

    public int comparandoEnEstaClase(ListaCircularDE lista1, ListaCircularDE lista2) {
        Calculadora cal = new Calculadora();
        int retornar = -1;
        if (lista1.verificadorComa(lista1) == false) {
            lista1.ingresarNodoAlFinal(",");
            lista1.ingresarNodoAlFinal("0");
        }
        if (lista2.verificadorComa(lista2) == false) {
            lista2.ingresarNodoAlFinal(",");
            lista2.ingresarNodoAlFinal("0");
        }

        if ((lista1.reconocerSigno(lista1) == false) && (lista2.reconocerSigno(lista2) == false)) {
            cal.igualarListas(lista1, lista2);

            if ((lista1.comparar(lista1, lista2)) == 0) {
                retornar = 0;
            }
            if ((lista1.comparar(lista1, lista2)) == 1) {
                retornar = 1;
            }
            if ((lista1.comparar(lista1, lista2)) == 2) {
                retornar = 2;
            }

        }
        return retornar;
    }

    public ListaCircularDE sigNumeroParaElCociente(ListaCircularDE lista1, ListaCircularDE lista2) {
        numeroCorrecto = 0;
        int i = 9;
        do {
            if (i == 9) {
                this.multiplicacion(lista2, listaNum9, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum9.vaciarLista(listaNum9);
                listaNum9.ingresarNodoAlFinal("9");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 9;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            if (i == 8) {
                this.multiplicacion(lista2, listaNum8, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum8.vaciarLista(listaNum8);
                listaNum8.ingresarNodoAlFinal("8");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 8;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            if (i == 7) {
                this.multiplicacion(lista2, listaNum7, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum7.vaciarLista(listaNum7);
                listaNum7.ingresarNodoAlFinal("7");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 7;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            if (i == 6) {
                this.multiplicacion(lista2, listaNum6, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum6.vaciarLista(listaNum6);
                listaNum6.ingresarNodoAlFinal("6");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 6;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            if (i == 5) {
                this.multiplicacion(lista2, listaNum5, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum5.vaciarLista(listaNum5);
                listaNum5.ingresarNodoAlFinal("5");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 5;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            if (i == 4) {
                this.multiplicacion(lista2, listaNum4, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum4.vaciarLista(listaNum4);
                listaNum4.ingresarNodoAlFinal("4");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 4;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            if (i == 3) {
                this.multiplicacion(lista2, listaNum3, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum3.vaciarLista(listaNum3);
                listaNum3.ingresarNodoAlFinal("3");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 3;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            if (i == 2) {
                this.multiplicacion(lista2, listaNum2, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum2.vaciarLista(listaNum2);
                listaNum2.ingresarNodoAlFinal("2");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 2;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            if (i == 1) {
                this.multiplicacion(lista2, listaNum1, listaAuxiliarResultados);
                lista2.borrarUltimoElemento(lista2);
                lista2.borrarUltimoElemento(lista2);
                listaNum1.vaciarLista(listaNum1);
                listaNum1.ingresarNodoAlFinal("1");
                listaAuxiliarResultados.vaciarLista(listaAuxiliarResultados);
                if ((this.comparandoEnEstaClase(lista1, lista2) == 1) || (this.comparandoEnEstaClase(lista1, lista2) == 0)) {
                    numeroCorrecto = 1;
                    lista2.borrarCerosInnecesarios(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista2.borrarUltimoElemento(lista2);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                } else {
                    lista2.traspasoMultiplicacion(lista2, listaDivisor);
                    lista1.borrarCerosInnecesarios(lista1);
                    lista1.borrarUltimoElemento(lista1);
                    lista1.borrarUltimoElemento(lista1);
                }
            }
            i--;

        } while ((i > 0) && (numeroCorrecto == 0));

        return lista2;
    }

}
