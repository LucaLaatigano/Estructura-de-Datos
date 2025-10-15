package tadArbolComplejo;

public class clsTestAVL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clsIntAVLTree miArbol;
		
		miArbol = new clsIntAVLTree();
		
		
		System.out.println("esta vacio " + miArbol.estaVacio());
		
	
		miArbol.meterAVL(new Integer(10));
	
		miArbol.meterAVL(new Integer(30));
		
		    miArbol.meterAVL(new Integer(20));
		    
		    miArbol.meterAVL(new Integer(40));
		
		    miArbol.meterAVL(new Integer(50));
		
		System.out.println("mostrando el arbol final despues de todas inserciones");
		miArbol.inOrder();	
	}

}
