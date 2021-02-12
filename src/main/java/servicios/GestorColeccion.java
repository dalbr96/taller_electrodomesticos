package gestores;

import java.util.ArrayList;

import models.Electrodomestico;
import models.Nevera;
import models.Televisor;

public class GestorColeccion {

    protected ArrayList<Electrodomestico> listaElectrodomesticos;
    float precioTelevisores;
    float precioNeveras;
    float precioElectrodomesticos;

    public GestorColeccion(){
        listaElectrodomesticos = new ArrayList<>();
        precioNeveras = 0f;
        precioElectrodomesticos = 0f;
        precioTelevisores = 0f;
    }


    public ArrayList<Electrodomestico> darListaElectrodomesticos(){
        return this.listaElectrodomesticos;
    }

    public float darPrecioTelevisores(){
        return this.precioTelevisores;
    }

    public float darPrecioNeveras(){
        return this.precioNeveras;
    }

    public float darPrecioElectrodomesticos(){
        return this.precioElectrodomesticos;
    }

    public void agregarElectrodomestico(Electrodomestico electrodomestico){
        this.listaElectrodomesticos.add(electrodomestico);
    }

    public void calcularPrecioTelevisores(){
        for(Electrodomestico electrodomestico : darListaElectrodomesticos()){
            if(electrodomestico instanceof Televisor){
                ((Televisor)electrodomestico).asignarPrecio();
                this.precioTelevisores += electrodomestico.darPrecio();
            }
        }
    }

    public void calcularPrecioElectrodomestico(){
        for(Electrodomestico electrodomestico: darListaElectrodomesticos()){
            if(!(electrodomestico instanceof Televisor) && !(electrodomestico instanceof Nevera)) {
                electrodomestico.asignarPrecio();
                this.precioElectrodomesticos += electrodomestico.darPrecio();
            }
        }
    }

    public void calcularPrecioNeveras(){
        for(Electrodomestico electrodomestico:darListaElectrodomesticos()){
            if(electrodomestico instanceof Nevera){
                ((Nevera)electrodomestico).asignarPrecio();
                this.precioNeveras += electrodomestico.darPrecio();
            }
        }
    }

    public void calcularTotales() {
        calcularPrecioTelevisores();
        calcularPrecioElectrodomestico();
        calcularPrecioNeveras();
    }

}
