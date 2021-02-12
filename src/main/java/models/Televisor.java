package models;

import constants.Consumo;
import constants.Procedencia;

public class Televisor extends Electrodomestico{

    protected int pulgadas;
    protected boolean sintonizadorTDT;

    /**
     * Constructor clase Televisor
     * @param consumo - Tipo Consumo
     * @param procedencia - Tipo Procedencia
     * @param pulgadas - Tipo int
     * @param sintonizadorTDT - Tipo boolean
     */
    public Televisor(Consumo consumo, Procedencia procedencia, int pulgadas, boolean sintonizadorTDT){
        super(consumo, procedencia);
        this.pulgadas = pulgadas;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    /**
     * Constructor por defecto clase Television
     * Inicializa todo a null, 0 o false como corresponda
     */
    public Televisor(){
        super();
        this.pulgadas = 0;
        this.sintonizadorTDT = false;
    }

    /**
     * Getter tamaño del tv en pulgadas
     * @return pulgadas - Tipo int
     */
    public int darPulgadas(){
        return this.pulgadas;
    }

    /**
     * Getter dar Sintonizador
     * @return sintonizadorTDT - Tipo boolean
     */
    public boolean darSintonizador(){
        return this.sintonizadorTDT;
    }

    /**
     * Setter tamaño del Televisor
     * @param pulgadas - Tipo int
     */
    public void asignarPulgadas(int pulgadas){
        this.pulgadas = pulgadas;
    }

    /**
     * Setter sintonizadorTDT
     * @param sintonizadorTDT - Tipo boolean
     */
    public void asignarSintetizador(boolean sintonizadorTDT){
        this.sintonizadorTDT = sintonizadorTDT;
    }

    /**
     * Calcular el costo adicional del tv segun la propiedad sintonizadorTDT
     * @return costo adicional - Tipo float
     */
    public float calcularPrecioSintatizador(){

        float precio = 0;
        if(darSintonizador()){
            precio = 250000;
        }
        return precio;
    }

    /**
     * Asignar precio
     * Implementacion propia del metodo asignar precio de la clase electrodomestic
     */
    @Override
    public void asignarPrecio(){
        this.precio = calcularPrecio();
    }

    /**
     * Calcular el precio del Televisor
     * darPulgadas()>40?(precioBase + precioSintonizador) * 1.3: (precioBase + precioSintonizador);
     * @return precioTelevisor - Tipo int
     */
    private float calcularPrecio(){
        float precioTentativo = calcularPrecioConsumo() + calcularPrecioProcedencia() + calcularPrecioSintatizador();
        if(darPulgadas() > 40){
            precioTentativo = precioTentativo * 1.3f;
        }
        return precioTentativo;
    }
}
