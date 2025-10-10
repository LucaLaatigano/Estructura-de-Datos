public class punto13 {

    private static final int NUM_CARROS_INICIALES = 25;
    private static clsColaLinkedList colaCarros;
    private static clsColaLinkedList caja1;
    private static clsColaLinkedList caja2;
    private static clsColaLinkedList caja3;

    public static void main(String[] args) {
        colaCarros = new clsColaLinkedList();
        for (int i = 1; i <= NUM_CARROS_INICIALES; i++) {
            colaCarros.meter("Carrito " + i);
        }

        caja1 = new clsColaLinkedList();
        caja2 = new clsColaLinkedList();
        caja3 = new clsColaLinkedList();

        System.out.println("--- INICIO DE LA SIMULACIÓN ---");

        for (int i = 1; i <= 10; i++) {
            clsCliente nuevoCliente = new clsCliente(i);

            System.out.println("\nLlega " + nuevoCliente.toString() + ".");

            if (colaCarros.colaVacia()) {
                System.out.println("  No hay carritos disponibles. " + nuevoCliente.toString() + " espera.");

            }

            // Si hay carritos, el cliente toma uno
            if (!colaCarros.colaVacia()) {
                String carritoTomado = (String) colaCarros.sacar();
                System.out.println("  " + nuevoCliente.toString() + " toma un " + carritoTomado + ".");

                // El cliente elige la caja con menos gente
                clsColaLinkedList cajaElegida = elegirCajaConMenosClientes();
                System.out.println("  " + nuevoCliente.toString() + " se dirige a la cola de la caja " + obtenerNumeroDeCaja(cajaElegida) + ".");
                cajaElegida.meter(nuevoCliente);

                // Simulación de que un cliente termina de pagar y libera su carrito
                if (!caja1.colaVacia()) {
                    clsCliente clienteAtendido = (clsCliente) caja1.sacar();
                    System.out.println("  " + clienteAtendido.toString() + " ha pagado en la caja 1 y se va.");
                    colaCarros.meter(carritoTomado);
                    System.out.println("  El carrito ha sido devuelto y está disponible.");
                }
            }
        }

        System.out.println("\n FIN DE LA SIMULACIÓN ");

        // Muestra el estado final
        System.out.println("\nEstado final:");
        System.out.println("Carritos disponibles: " + contarElementos(colaCarros));
        System.out.println("Clientes en la cola de la caja 1: " + contarElementos(caja1));
        System.out.println("Clientes en la cola de la caja 2: " + contarElementos(caja2));
        System.out.println("Clientes en la cola de la caja 3: " + contarElementos(caja3));
    }

    private static clsColaLinkedList elegirCajaConMenosClientes() {
        int clientesCaja1 = contarElementos(caja1);
        int clientesCaja2 = contarElementos(caja2);
        int clientesCaja3 = contarElementos(caja3);

        if (clientesCaja1 <= clientesCaja2 && clientesCaja1 <= clientesCaja3) {
            return caja1;
        } else if (clientesCaja2 <= clientesCaja1 && clientesCaja2 <= clientesCaja3) {
            return caja2;
        } else {
            return caja3;
        }
    }

    private static int obtenerNumeroDeCaja(clsColaLinkedList caja) {
        if (caja.equals(caja1)) return 1;
        if (caja.equals(caja2)) return 2;
        if (caja.equals(caja3)) return 3;
        return 0;
    }

    private static int contarElementos(clsColaLinkedList cola) {
        clsColaLinkedList temp = new clsColaLinkedList();
        int contador = 0;
        while (!cola.colaVacia()) {
            temp.meter(cola.sacar());
            contador++;
        }
        while (!temp.colaVacia()) {
            cola.meter(temp.sacar());
        }
        return contador;
    }
}

