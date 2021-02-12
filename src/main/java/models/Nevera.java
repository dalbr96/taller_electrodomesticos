package models;

import constants.Consumo;
import constants.Procedencia;

public class Nevera extends Electrodomestico{
    protected int litros;

    public Nevera(Consumo consumo, Procedencia procedencia, int litros){
        super(consumo, procedencia);
        this.litros = litros;
    }

    public Nevera(){
        super();
        this.litros = 0;
    }

    public int darLitros(){
        return this.litros;
    }

    public void asignarLitros(int litros){
        this.litros = litros;
    }

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

    @Override
    public void asignarPrecio(){
        this.precio = calcularIncremento() * (calcularPrecioConsumo() + calcularPrecioProcedencia());
    }
}
