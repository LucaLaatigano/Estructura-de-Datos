package punto4;

public class prueba {

	public static void main(String[] args) {
		clsIntABB arbol = new clsIntABB();
		arbol.meter(10);
		arbol.meter(5);
		arbol.meter(6);
		arbol.meter(7);
		arbol.meter(3);
		arbol.meter(11);
		arbol.meter(8);
		System.out.println("Muestra In Order");
		arbol.muestraInOrder();
		System.out.println("Muestra PostOrder");
		arbol.muestraPostOrder();
		System.out.println("Muestra PreOrder");
		arbol.muestraPreOrder();
		System.out.println(arbol.cuentaNodos());
		System.out.println(arbol.isComplete());
		System.out.println(arbol.altura());
		System.out.println(arbol.diferenciaAltura());



		
	}

}
