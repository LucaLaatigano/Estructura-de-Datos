public class EJ12 {
    public static void intercambiarConPilaAux(clsPilaLinkedList P, clsColaLinkedList C) {
        clsPilaLinkedList P_aux = new clsPilaLinkedList();
        int tamañoC = 0;


        while (!P.pilaVacia()) {
            P_aux.meter(P.sacar());
        }


        while (!C.colaVacia()) {
            P.meter(C.sacar());
            tamañoC++;
        }


        while (!P_aux.pilaVacia()) {
            C.meter(P_aux.sacar());
        }

        for (int i = 0; i < tamañoC; i++) {
            P_aux.meter(P.sacar());
        }


        for (int i = 0; i < tamañoC; i++) {
            P.meter(P_aux.sacar());
        }

    }


    public static void intercambiarConColaAux(clsPilaLinkedList P, clsColaLinkedList C) {
        clsColaLinkedList C_aux = new clsColaLinkedList();
        int tamañoC = 0;
        int tamañoP = 0;


        while (!C.colaVacia()) {
            C_aux.meter(C.sacar());
            tamañoC++;
        }


        while (!P.pilaVacia()) {
            C_aux.meter(P.sacar());
            tamañoP++;
        }


        for (int i = 0; i < tamañoC; i++) {
            P.meter(C_aux.sacar());
        }


        for (int i = 0; i < tamañoP; i++) {
            C.meter(C_aux.sacar());
        }

        for (int i = 0; i < tamañoC; i++) {
            C_aux.meter(P.sacar());
        }


        for (int i = 0; i < tamañoC; i++) {
            P.meter(C_aux.sacar());
        }

    }
        public static void mostrarEstado(String mensaje, clsPilaLinkedList P, clsColaLinkedList C) {
            System.out.println("---------------------------------");
            System.out.println(mensaje);
            System.out.println("Contenido de la Pila (Tope -> Base):");
            P.muestra();
            System.out.println("Contenido de la Cola (Frente -> Final):");
            C.muestra();
            System.out.println("---------------------------------");
        }

        public static void main(String[] args) {

            clsPilaLinkedList P1 = new clsPilaLinkedList();
            P1.meter(1);
            P1.meter(2);
            P1.meter(3);

            clsColaLinkedList C1 = new clsColaLinkedList();
            C1.meter("D");
            C1.meter("C");
            C1.meter("B");
            C1.meter("A");

            mostrarEstado("Caso Pila Auxiliar", P1, C1);

            EJ12.intercambiarConPilaAux(P1, C1);
            mostrarEstado("Cambiado", P1,C1);

            clsPilaLinkedList P2 = new clsPilaLinkedList();
            P2.meter(1);
            P2.meter(2);
            P2.meter(3);

            clsColaLinkedList C2 = new clsColaLinkedList();
            C2.meter("D");
            C2.meter("C");
            C2.meter("B");
            C2.meter("A");

            mostrarEstado(" Caso Cola Auxiliar", P2, C2);

            EJ12.intercambiarConColaAux(P2, C2);

            mostrarEstado("Cambiado", P2, C2);
        }
    }


