public class punto6 {

    public static boolean estaEquilibrada(String expresion) {
        clsPilaLinkedList pila = new clsPilaLinkedList();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (caracter == '(') {
                pila.meter(caracter);
            } else if (caracter == ')') {
                if (pila.pilaVacia()) {
                    System.out.println("Error: Falta un paréntesis de apertura.");
                    return false;
                } else {
                    pila.sacar();
                }
            }
        }

        if (pila.pilaVacia()) {
            System.out.println("La expresión tiene paréntesis equilibrados.");
            return true;
        } else {
            System.out.println("Error: Falta un paréntesis de cierre.");
            return false;
        }
    }

    public static void main(String[] args) {
        String expresion1 = "((a+b)*5) - 7";
        System.out.println("Evaluando la expresión: " + expresion1);
        estaEquilibrada(expresion1);

        System.out.println("\n---");

        String expresion2 = "2*((a+b)/2.5 + x - 7*y";
        System.out.println("Evaluando la expresión: " + expresion2);
        estaEquilibrada(expresion2);

        System.out.println("\n---");

        String expresion3 = ")a+b(";
        System.out.println("Evaluando la expresión: " + expresion3);
        estaEquilibrada(expresion3);

        System.out.println("\n---");

        String expresion4 = "(a-b))";
        System.out.println("Evaluando la expresión: " + expresion4);
        estaEquilibrada(expresion4);
    }
}

