

public class clsTestPila {
	public static void main(String[] args) {
		
		clsPilaLinkedList objLista = new clsPilaLinkedList();
		Double objInt1,objInt2,objInt3;
		Object objAux;
		
		objInt1=31.7;
		objInt2=50.0;
		objInt3=-4.0;
		
		objLista.meter(objInt1);
		objLista.meter(objInt2);
		objLista.meter(objInt3);
	
		objLista.muestra();
		
		objAux= (Double)objLista.sacar();
		System.out.println("tope de pila " + objAux.toString());
		objAux= objLista.sacar();
		objLista.muestra();

		objAux=objLista.sacar();
		objAux=objLista.sacar();

		objLista.muestra();	

		
		
	}
}
