

public class clsColaLinkedList {
	private clsNode frenteC, finalC;
	
	clsColaLinkedList(){
		limpiaCola();
	}
	
	boolean colaVacia(){
		return (this.frenteC==null);
	}	

	void limpiaCola(){
		this.frenteC=this.finalC=null;
	}	
	
	//final es a derecha
	void meter(Object objElemento){
		if (!colaVacia()){
			this.finalC.setNextNode(new clsNode(objElemento));
			this.finalC=this.finalC.getNextNode();
			// nuevo nodo es el ultimo. su sigte vale null
		}else{
			this.frenteC=this.finalC= new clsNode(objElemento);			
		}		
	}	
	
	// frente es a izquierda
	Object sacar(){
		Object objElemento = null;
		if (!colaVacia()){
			objElemento=this.frenteC.getNodeInfo();
			this.frenteC=this.frenteC.getNextNode();
			
			if (colaVacia()){
				this.finalC=null;
			}
		}else{
			System.out.println("Error sacar. Cola vacia");			
		}
		return objElemento;
	}	
	
	
	void muestra(){
		clsNode temp;		
		if (!colaVacia()){
			temp=this.frenteC;
			while (temp!=null){
				System.out.println("Elemento " + temp.getNodeInfo().toString());
				temp=temp.getNextNode();
			}			
		}else{
			System.out.println("Error muestra. Cola vacia");
		}		
	}
}
