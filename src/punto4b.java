public class punto4b {
    public static String convertir(String expresionInfija) {
        clsPilaLinkedList pilaOperadores = new clsPilaLinkedList();
        StringBuilder expresionPosfija = new StringBuilder();

        for (int i = 0; i < expresionInfija.length(); i++) {
            char caracter = expresionInfija.charAt(i);

            if (Character.isDigit(caracter)) {
                expresionPosfija.append(caracter).append(" ");
            } else if (caracter == '(') {
                pilaOperadores.meter(caracter);
            } else if (caracter == ')') {
                while (!pilaOperadores.pilaVacia() && (Character) pilaOperadores.verTope() != '(') {
                    expresionPosfija.append((Character) pilaOperadores.sacar()).append(" ");
                }
                if (!pilaOperadores.pilaVacia()) {
                    pilaOperadores.sacar();
                }
            } else if (esOperador(caracter)) {
                while (!pilaOperadores.pilaVacia() && precedencia((Character) pilaOperadores.verTope()) >= precedencia(caracter)) {
                    expresionPosfija.append((Character) pilaOperadores.sacar()).append(" ");
                }
                pilaOperadores.meter(caracter);
            }
        }

        while (!pilaOperadores.pilaVacia()) {
            expresionPosfija.append((Character) pilaOperadores.sacar()).append(" ");
        }

        return expresionPosfija.toString().trim();
    }

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; // Para los paréntesis
        }
    }

    public static void main(String[] args) {
        String expresion = "(3+5/9)*(6-9)";
        String posfija = convertir(expresion);
        System.out.println("Expresión infija: " + expresion);
        System.out.println("Expresión posfija: " + posfija);
    }
}

