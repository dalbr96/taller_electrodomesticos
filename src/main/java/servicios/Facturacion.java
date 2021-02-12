package servicios;

import java.math.BigDecimal;
import java.util.Scanner;

import constants.Consumo;
import constants.Procedencia;
import models.Electrodomestico;
import models.Nevera;
import models.Televisor;

/**
 * Clase encargada de la interaccion con el usuario
 */
public class Facturacion {

    private static GestorColeccion listaElectrodomesticos = new GestorColeccion();

    /**
     * Pide al usuario el numero de productos.
     * El input debe ser un numero entero mayor a 0
     * El programa seguira preguntando por input hasta que esta condicion se cumpla
     * @return numeroProductos - Tipo int
     */
    public static int pedirNumeroDeProductos(){
        boolean numberCondition = false;
        int numeroProductos = 0;
        do{
            System.out.println("Ingrese el numero de electrodomesticos a facturar");

            try{
                Scanner in = new Scanner(System.in);
                String prueba = in.nextLine();
                numeroProductos = Integer.parseInt(prueba);

                if(numeroProductos > 0){
                    numberCondition = true;
                }
                else {
                    System.out.println("El numero debe ser un entero mayor a 0");
                }
            }catch (Exception e){

                System.out.println("El numero debe ser un entero mayor a 0");
            }
        }while (!numberCondition);
        return numeroProductos;
    }

    /**
     * Crea la cantidad de electrodomesticos especificada por el usuario
     * @param numeroDeProductos
     * Invoca los metodos preguntarElectrodomestico(), agregarElectrodomestico(), crearTelevisor(),
     * crearNevera() y crearElectrodomestico()
     */
    public static void crearElectrodomesticos(int numeroDeProductos){

        for(int i = 0; i < numeroDeProductos; i++){
            switch (preguntarElectrodomestico()){
                case 1:
                    listaElectrodomesticos.agregarElectrodomestico(crearTelevisor());
                    break;
                case 2:
                    listaElectrodomesticos.agregarElectrodomestico(crearNevera());
                    break;
                case 3:
                    listaElectrodomesticos.agregarElectrodomestico(crearElectrodomestico());
                    break;
                default:
                    break;

            }
        }
    }

    /**
     * PreguntarElectrodomestico
     * Le pregunta al usuario el electrodomestico a agregar.
     * No se deja de ejecutar hasta que el usuario ingrese una opcion valida
     * @return opcionEscogida - Tipo int
     */
    public static int preguntarElectrodomestico(){

        boolean validadorInputElectrodomestico = false;
        int opcionElectrodomestico = 0;

        do{
            System.out.println("Por favor, seleccione una de las opciones de electrodomestico: ");
            System.out.println("1. Televisor");
            System.out.println("2. Nevera");
            System.out.println("3. Otro");

            try {
                Scanner in = new Scanner(System.in);
                String inputUsuario = in.nextLine();
                opcionElectrodomestico = Integer.parseInt(inputUsuario);

                if((0 < opcionElectrodomestico)  && (opcionElectrodomestico <= 3)){
                    validadorInputElectrodomestico = true;
                }
                else{
                    System.out.println("El numero debe ser un entero entre 1 y 3");
                }
            }catch (Exception e){
                System.out.println("Debe ingresar un numero entero entre 1 y 3");
            }

        }while(!validadorInputElectrodomestico);

        return opcionElectrodomestico;
    }

    /**
     * Crea un objeto de tipo Electrodomestico
     * @return electrodomesticoCreado - Tipo Electrodomestico
     * Invoca a los metodos preguntarTipoDeConsumo() y preguntarProcedencia()
     */
    public static Electrodomestico crearElectrodomestico(){

        Consumo consumo = preguntarTipoDeConsumo();
        Procedencia procedencia = preguntarProcedencia();

        return new Electrodomestico(consumo, procedencia);
    }

    /**
     * Crea un objeto de tipo Televisor
     * @return televisorCreado - Tipo Televisor
     * Invoca a los metodos preguntarTipoDeConsumo(), preguntarProcedencia(), preguntarTamanhoTv() y
     * preguntarTDT()
     */
    public static Electrodomestico crearTelevisor(){

        Consumo consumo = preguntarTipoDeConsumo();
        Procedencia procedencia = preguntarProcedencia();
        int tamanho = preguntarTamanhoTv();
        boolean tdt = preguntarTDT();

        return new Televisor(consumo, procedencia, tamanho, tdt);
    }

    /**
     * Crea un objeto de tipo Nevera
     * @return NeveraCreado - Tipo Nevera
     * Invoca a los metodos preguntarTipoDeConsumo(), preguntarProcedencia() y preguntarCapacidad()
     */
    public static Electrodomestico crearNevera(){

        Consumo consumo = preguntarTipoDeConsumo();
        Procedencia procedencia = preguntarProcedencia();
        int capacidad = preguntarCapacidad();

        return new Nevera(consumo, procedencia, capacidad);
    }

    /**
     * Le pregunta al usuario el tipo de consumo del electrodomestico
     * Se ejecuta hasta que el usuario no ingrese una opcion valida
     * @return consumo - Tipo Consumo
     */
    public static Consumo preguntarTipoDeConsumo(){
        boolean validadorInputConsumo;
        Consumo consumoElegido;

        do{
            System.out.println("Por favor, escriba una opcion de consumo entre A, M y C");
            Scanner in = new Scanner(System.in);
            String inputUsuario = in.nextLine();
            validadorInputConsumo = true;
            switch (inputUsuario){
                case "A":
                    consumoElegido = Consumo.A;
                    break;
                case "M":
                    consumoElegido = Consumo.M;
                    break;
                case "C":
                    consumoElegido = Consumo.C;
                    break;
                default:
                    System.out.println("Debe elegir entre A, M y C");
                    consumoElegido = null;
                    validadorInputConsumo = false;

            }

        }while(!validadorInputConsumo);
        return consumoElegido;
    }

    /**
     * Le pregunta al usuario la procedencia del electrodomestico
     * Se ejecuta hasta que el usuario no ingrese una opcion valida
     * @return procedencia - Tipo Prodecencia
     */
    public static Procedencia preguntarProcedencia(){
        boolean validadorInputProcedencia;
        Procedencia procedenciaElegida;

        do{
            System.out.println("Por favor, elija entre las siguientes opciones");
            System.out.println("1. Nacional");
            System.out.println("2. Importado");

            Scanner in = new Scanner(System.in);
            String inputUsuario = in.nextLine();
            validadorInputProcedencia = true;
            switch (inputUsuario){
                case "1":
                    procedenciaElegida = Procedencia.NACIONAL;
                    break;
                case "2":
                    procedenciaElegida = Procedencia.IMPORTADO;
                    break;
                default:
                    System.out.println("Debe elegir entre A, M y C");
                    procedenciaElegida = null;
                    validadorInputProcedencia = false;

            }

        }while(!validadorInputProcedencia);
        return procedenciaElegida;
    }

    /**
     * Pregunta al usuario el tamanho del tv
     * Se ejecuta hasta que el usuario ingresa un numero entero mayor a 0
     * @return tamanho - Tipo int
     */
    public static int preguntarTamanhoTv(){
        boolean validadorTamanho = false;
        int tamanho = 0;
        do{
            System.out.println("Ingrese el tamanho del televisor");

            try{
                Scanner in = new Scanner(System.in);
                String tamanhoS = in.nextLine();
                tamanho = Integer.parseInt(tamanhoS);

                if(tamanho > 0){
                    validadorTamanho = true;
                }
                else {
                    System.out.println("El tamanho de TV debe ser mayor a 0 pulgadas.");
                }
            }catch (Exception e){

                System.out.println("El tamanho del TV debe ser un numero entero mayor a 0");
            }
        }while (!validadorTamanho);
        return tamanho;
    }

    /**
     * Pregunta al usuario si el tv tiene sintonizador de TDT
     * Se ejecuta hasta que el usuario ingresa una opcion valida
     * @return tieneTDT - Tipo boolean
     */
    public static boolean preguntarTDT(){
        boolean validadorTdt;
        boolean tieneTDT;
        do{
            validadorTdt = true;

            System.out.println("Por favor escrina una de las siguientes opciones");
            System.out.println("1. Si su TV cuenta con sintonizador TDT");
            System.out.println("2. Si su TV NO cuenta con sintonizador TDT");

            Scanner in = new Scanner(System.in);
            String preguntaTdt = in.nextLine();
            switch (preguntaTdt){
                case "1":
                    tieneTDT = true;
                    break;
                case "2":
                    tieneTDT = false;
                    break;
                default:
                    validadorTdt = false;
                    tieneTDT = false;
                    System.out.println("Por favor seleccione una de las opciones" );
            }
    }while (!validadorTdt);

        return tieneTDT;
    }

    /**
     * Pregunta al usuario la capacidad de la nevera
     * Se ejecuta hasta que el usuario ingresa un numero entero mayor a 0
     * @return litros - Tipo int
     */
    public static int preguntarCapacidad(){
        boolean validadorCapacidad = false;
        int capacidad = 0;
        do{
            System.out.println("Ingrese la capacidad en litros de la nevera");

            try{
                Scanner in = new Scanner(System.in);
                String capacidadS = in.nextLine();
                capacidad = Integer.parseInt(capacidadS);

                if(capacidad > 0){
                    validadorCapacidad = true;
                }
                else {
                    System.out.println("La capacidad debe ser mayor a 0 Litros.");
                }
            }catch (Exception e){

                System.out.println("La capacidad de la nevera debe ser un numero entero mayor a 0");
            }
        }while (!validadorCapacidad);
        return capacidad;
    }

    /**
     * Imprime el total de precios categorizado por: Televisores, Neveras y otros Electrodomesticos
     */
    public static void imprimirPrecios(){

        listaElectrodomesticos.calcularTotales();

        System.out.println("Precio Tototal Televisores: $" + new BigDecimal(listaElectrodomesticos.darPrecioTelevisores()));
        System.out.println("Precio Tototal Neveras: $" + new BigDecimal(listaElectrodomesticos.darPrecioNeveras()));
        System.out.println("Precio Tototal Electrodomesticos: $" +  new BigDecimal(listaElectrodomesticos.darPrecioElectrodomesticos()));

    }

}


