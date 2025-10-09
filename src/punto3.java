import java.util.Scanner;
public class punto3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		clsPilaLinkedList pila = new clsPilaLinkedList();
		System.out.println("Ingrese una cadena de formato a^nba^mba^n+m");
		String palabra = sc.nextLine();
		
		if(pila.reconocerFormato(palabra)) {
			System.out.println("la palabra "+ palabra +" es correcta");
		}else {
			System.out.println("la palabra "+ palabra + " es incorrecta");
		}
		sc.close();

	}

}
