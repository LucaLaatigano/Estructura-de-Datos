


public class EJ5 {

    public static clsPilaLinkedList fusionarPilasOrdenadas(clsPilaLinkedList pila1, clsPilaLinkedList pila2) {
        clsPilaLinkedList pilaResultante = new clsPilaLinkedList();
        while (!pila1.pilaVacia() && !pila2.pilaVacia()) {
            Integer currentTope1 = (Integer) pila1.verTope();
            Integer currentTope2 = (Integer) pila2.verTope();
            if (currentTope2.intValue() >= currentTope1.intValue()) {
                pilaResultante.meter(pila2.sacar());
            } else {
                pilaResultante.meter(pila1.sacar());
            }
        }
        while (!pila2.pilaVacia()) {
            pilaResultante.meter(pila2.sacar());
        }
        while (!pila1.pilaVacia()) {
            pilaResultante.meter(pila1.sacar());
        }

        return pilaResultante;

    }

    public static void main(String[] args) {


        clsPilaLinkedList pilaA = new clsPilaLinkedList();
        pilaA.meter(1);
        pilaA.meter(3);
        pilaA.meter(5);
        pilaA.meter(7); // Tope

        System.out.println("Pila 1 (Ascendente)");
        pilaA.muestra();

        clsPilaLinkedList pilaB = new clsPilaLinkedList();
        pilaB.meter(2);
        pilaB.meter(4);
        pilaB.meter(6);
        pilaB.meter(8); // Tope

        System.out.println(" Pila B (Descendente)");
        pilaB.muestra();


        clsPilaLinkedList pilaC = fusionarPilasOrdenadas(pilaA, pilaB);


        System.out.println("Pila C Mezclada");

        pilaC.muestra();
    }
}

