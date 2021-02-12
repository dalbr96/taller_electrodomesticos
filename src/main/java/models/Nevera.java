package models;

import constants.Consumo;
import constants.Procedencia;

public class Nevera extends Electrodomestico{
    protected int litros;

    /**
     * Constructor clase nevera
     * @param consumo - tipo Consumo
     * @param procedencia - tipo Procedencia
     * @param litros - tipo int
     */
    public Nevera(Consumo consumo, Procedencia procedencia, int litros){
        super(consumo, procedencia);
        this.litros = litros;
    }


    /**
     * Constructor por defecto de Nevera
     * Inicializa las variables a null y cero
     */
    public Nevera(){
        super();
        this.litros = 0;
    }

    /**
     * Accesor dar litros
     * @return this.litros
     */
    public int darLitros(){
        return this.litros;
    }

    /**
     * Setter de litros
     * @param litros - tipo int
     */
    public void asignarLitros(int litros){
        this.litros = litros;
    }

    /**
     * Calcula el incremento de precio dependiendo de la capacidad en litros de la nevera
     * @return incremento en fraccion - tipo float
     */
    public float calcularIncremento(){

        if(darLitros()>120){

            int litrosExcedidos = darLitros() - 120;
            int aumentoPorcentual = 5 * litrosExcedidos/10;
            return aumentoPorcentual/100 + 1;

        }
        else{
            return 1;
        }
    }

    /**
     * Implementacion de nevera del metodo asignar precio.
     * Precio nevera = precioBase * incrementoEnFraccion
     */
    @Override
    public void asignarPrecio(){
        this.precio = calcularIncremento() * (calcularPrecioConsumo() + calcularPrecioProcedencia());
    }
}
