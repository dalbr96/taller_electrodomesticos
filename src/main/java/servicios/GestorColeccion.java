package servicios;

import java.util.ArrayList;

import models.Electrodomestico;
import models.Nevera;
import models.Televisor;

/**
 * Clase gestora de la coleccion de electrodomesticos
 */
public class GestorColeccion {

    protected ArrayList<Electrodomestico> listaElectrodomesticos;
    float precioTelevisores;
    float precioNeveras;
    float precioElectrodomesticos;

    /**
     * Constructor clase GestorColeccion
     * Inicializa todos los valores a su valor predeterminado menos listaElectrodomesticos
     * listaElectrodomesticos = new ArrayList<>()
     */
    public GestorColeccion(){
        listaElectrodomesticos = new ArrayList<>();
        precioNeveras = 0f;
        precioElectrodomesticos = 0f;
        precioTelevisores = 0f;
    }

    /**
     * Getter listaElectrodomesticos
     * @return listaElectrodomesticos - Tipo ArrayList<Electrodomestico>
     */
    public ArrayList<Electrodomestico> darListaElectrodomesticos(){
        return this.listaElectrodomesticos;
    }

    /**
     * Getter precio total televisores
     * @return precioTelevisores - Tipo float
     */
    public float darPrecioTelevisores(){
        return this.precioTelevisores;
    }

    /**
     * Getter precio total neveras
     * @return precioNeveras - Tipo float
     */
    public float darPrecioNeveras(){
        return this.precioNeveras;
    }

    /**
     * Getter precio total electrodomesticos
     * @return precioElectrodomesticos - Tipo float
     */
    public float darPrecioElectrodomesticos(){
        return this.precioElectrodomesticos;
    }

    /**
     * Agrega un nuevo electrodomestico a la propiedad listaElectrodomesticos
     * @param electrodomestico - Tipo Electrodomestico
     */
    public void agregarElectrodomestico(Electrodomestico electrodomestico){
        this.listaElectrodomesticos.add(electrodomestico);
    }

    /**
     * Calcula el total del precio de los televisores en la coleccion listaElectrodomesticos
     * Asigna este valor a this.precioTelevisores
     */
    public void calcularPrecioTelevisores(){
        for(Electrodomestico electrodomestico : darListaElectrodomesticos()){
            if(electrodomestico instanceof Televisor){
                ((Televisor)electrodomestico).asignarPrecio();
                this.precioTelevisores += electrodomestico.darPrecio();
            }
        }
    }

    /**
     * Calcula el total del precio de los Electrodomesticos en la coleccion listaElectrodomesticos
     * Asigna este valor a this.precioElectrodomesticos
     */
    public void calcularPrecioElectrodomestico(){
        for(Electrodomestico electrodomestico: darListaElectrodomesticos()){
            if(!(electrodomestico instanceof Televisor) && !(electrodomestico instanceof Nevera)) {
                electrodomestico.asignarPrecio();
                this.precioElectrodomesticos += electrodomestico.darPrecio();
            }
        }
    }

    /**
     * Calcula el total del precio de las Neveras en la coleccion listaElectrodomesticos
     * Asigna este valor a this.precioNeveras
     */
    public void calcularPrecioNeveras(){
        for(Electrodomestico electrodomestico:darListaElectrodomesticos()){
            if(electrodomestico instanceof Nevera){
                ((Nevera)electrodomestico).asignarPrecio();
                this.precioNeveras += electrodomestico.darPrecio();
            }
        }
    }

    /**
     * Invoca los metodos calcularPrecioTelevisores(), calcularPrecioElectrodomesticos() y calcularPrecioNeveras
     */
    public void calcularTotales() {
        calcularPrecioTelevisores();
        calcularPrecioElectrodomestico();
        calcularPrecioNeveras();
    }

}
