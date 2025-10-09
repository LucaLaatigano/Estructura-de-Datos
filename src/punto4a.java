public class punto4a {
    public static int evaluar(String expresion) {
        clsPilaLinkedList pila = new clsPilaLinkedList();

        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            if (esOperando(token)) {
                pila.meter(Integer.parseInt(token));
            } else if (esOperador(token)) {
                int operando2 = (Integer) pila.sacar();
                int operando1 = (Integer) pila.sacar();
                int resultado = realizarOperacion(operando1, operando2, token);
                pila.meter(resultado);
            }
        }
        return (Integer) pila.sacar();
    }

    private static boolean esOperando(String s) {
        return s.length() == 1 && Character.isDigit(s.charAt(0));
    }

    private static boolean esOperador(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int realizarOperacion(int operando1, int operando2, String operador) {
        switch (operador) {
            case "+":
                return operando1 + operando2;
            case "-":
                return operando1 - operando2;
            case "*":
                return operando1 * operando2;
            case "/":
                return operando1 / operando2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String expresion = "3 5 9 / + 6 9 - *";
        int resultado = evaluar(expresion);
        System.out.println("El resultado de la expresión posfija es: " + resultado);
    }
}

