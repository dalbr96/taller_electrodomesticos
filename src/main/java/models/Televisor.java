package models;

import constants.Consumo;
import constants.Procedencia;

public class Televisor extends Electrodomestico{

    protected int pulgadas;
    protected boolean sintonizadorTDT;

    public Televisor(Consumo consumo, Procedencia procedencia, int pulgadas, boolean sintonizadorTDT){
        super(consumo, procedencia);
        this.pulgadas = pulgadas;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public Televisor(){
        super();
        this.pulgadas = 0;
        this.sintonizadorTDT = false;
    }

    public int darPulgadas(){
        return this.pulgadas;
    }

    public boolean darSintonizador(){
        return this.sintonizadorTDT;
    }

    public void asignarPulgadas(int pulgadas){
        this.pulgadas = pulgadas;
    }

    public void asignarSintetizador(boolean sintonizadorTDT){
        this.pulgadas = pulgadas;
    }

    public float calcularPrecioSintatizador(){

        float precio = 0;
        if(darSintonizador()){
            precio = 250000;
        }
        return precio;
    }

    @Override
    public void asignarPrecio(){
        this.precio = calcularPrecio();
    }

    private float calcularPrecio(){
        float precioTentativo = calcularPrecioConsumo() + calcularPrecioProcedencia() + calcularPrecioSintatizador();
        if(darPulgadas() > 40){
            precioTentativo = precioTentativo * 1.3f;
        }
        return precioTentativo;
    }
}
