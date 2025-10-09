
public class punto2 {

	public static void main(String[] args) {
		clsPilaLinkedList pila =new clsPilaLinkedList();
		
		pila.meter(2);
		pila.meter(3);
		pila.meter(5);
		pila.meter(6);
		
		pila.muestra();
		
		clsPilaLinkedList pila2 = new clsPilaLinkedList();
		
		pila2=pila.Coincide();
		System.out.println();
		pila2.muestra();
	}

}
