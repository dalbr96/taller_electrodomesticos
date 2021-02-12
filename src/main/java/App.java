import servicios.Facturacion;

public class App {
    public static void main(String[] args){

        int numeroDeProductos = Facturacion.pedirNumeroDeProductos();

        Facturacion.crearElectrodomesticos(numeroDeProductos);

        Facturacion.imprimirPrecios();
    }
}
