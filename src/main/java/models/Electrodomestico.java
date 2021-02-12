package models;

import constants.Procedencia;
import constants.Consumo;

public class Electrodomestico {

    protected Consumo consumo;
    protected Procedencia procedencia;
    protected float precio;

    /**
     * Constructor Electrodomesticos cuando se especifica el consumo y la procedencia, inicializa por defecto
     * el precio como 0
     *
     * @param consumo     define el consumo del electrodomestico
     * @param procedencia define la procedencia del electrodomestico
     */
    public Electrodomestico(Consumo consumo, Procedencia procedencia) {
        this.consumo = consumo;
        this.procedencia = procedencia;
        this.precio = 0f;
    }

    /**
     * Constuctor por defecto de clase Electrodomestico
     * Inicializa por defecto consumo y prodecencia a null y precio a 0
     */
    public Electrodomestico() {
        this.consumo = null;
        this.procedencia = null;
        this.precio = 0f;
    }

    /**
     * Metodo accesor de consumo
     *
     * @return consumo
     */
    public Consumo darConsumo() {
        return this.consumo;
    }

    /**
     * Metodo accesor de procedencia
     *
     * @return procedencia
     */
    public Procedencia darProcedencia() {
        return this.procedencia;
    }

    /**
     * Metodo accesor de precio
     *
     * @return precio
     */
    public float darPrecio() {
        return this.precio;
    }

    /**
     * Metodo para asignar el precio del electrodomestico
     */
    public void asignarPrecio() {
        this.precio = calcularPrecioProcedencia() + calcularPrecioConsumo();
    }

    /**
     * Metodo para asignar una nueva procedencia del electrodomestico
     * @param procedencia - Debe ser de tipo Procedencia
     */
    public void asignarProcedencia(Procedencia procedencia){
        this.procedencia = procedencia;
    }

    /**
     * Metodo para asignar una nuevo tipo de consumo
     * @param consumo - Debe ser de tipo Consumo
     */
    public void asignarConsumo(Consumo consumo){
        this.consumo = consumo;
    }


    /**
     * Metodo para calcular la parte del precio correspondiente a la procedencia del electrodomestico
     * @return precio correspondiente a la procedencia
     */
    public float calcularPrecioProcedencia() {
        switch (darProcedencia()) {
            case NACIONAL:
                return 250000;
            case IMPORTADO:
                return 350000;
            default:
                System.out.println("Por favor ingrese una procedencia válida");
                return 0;
        }
    }

    /**
     * Metodo para calcular la parte del precio correspondiente al consumo del electrodomestico
     * @return precio correspondiente al consumo
     */
    public float calcularPrecioConsumo(){
            switch (darConsumo()){
                case A:
                    return 450000;
                case C:
                    return 350000;
                case M:
                    return 250000;
                default:
                    System.out.println("Por favor ingrese un consumo válido");
                    return 0;
            }
        }
}
