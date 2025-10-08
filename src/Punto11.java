public class Punto11 {

	static boolean esCapicua(String numero ) {
		return(numero.charAt(0)==numero.charAt(3)&&numero.charAt(1)==numero.charAt(2));
	}
	 public static void verificarHilera(String[] numeros) {
	        clsColaLinkedList colaDeNumeros = new clsColaLinkedList();
	        for (String num : numeros) {
	            if (num.length() == 4) { 
	                colaDeNumeros.meter(num);
	            }
	        }
	        int numeroAnterior = -1;
	        boolean serieEsCorrecta = true;
	        String mensajeDeError = "";
	        while (!colaDeNumeros.colaVacia()) {
	            String numeroActual = (String) colaDeNumeros.sacar();
	            if (numeroActual.equals("0000")) {
	                break;
	            }
	            if (!esCapicua(numeroActual)) {
	                mensajeDeError = "El valor " + numeroActual + " no es capicúa.";
	                serieEsCorrecta = false;
	                break; 
	            }

	            int numeroActualInt = Integer.parseInt(numeroActual);
	            if (numeroAnterior != -1 && numeroActualInt < numeroAnterior) {
	                mensajeDeError = "La serie no viene ordenada ascendentemente.";
	                serieEsCorrecta = false;
	                break; 
	            }
	            numeroAnterior = numeroActualInt;
	        }

	        if (serieEsCorrecta) {
	            System.out.println("todos los numeros son capicuas y estan bien ordenados.");
	        } else {
	            System.out.println(" La serie es incorrecta. Motivo: " + mensajeDeError);
	        }
	    }

	
	public static void main(String[] args) {
			String[] numeros = {"1221","3443","5555","6556","8998","0000"};
			
			verificarHilera(numeros);
			
			String[] numeros2= {"1221","3443","5545","6756","8998","0000"};
			
			verificarHilera(numeros2);

	}
}


