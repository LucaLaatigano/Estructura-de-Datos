package punto4;
public abstract class clsBinaryTree implements TADArbol{
	protected clsBinaryTreeNode root;
	
	
	public abstract void imprimir(Object nodeInfo);
	public abstract void meter(Object nodeInfo);
	public abstract boolean esta(Object nodeInfo);
	public abstract void sacar(Object nodeInfo);
	public abstract clsBinaryTreeNode devuelve(Object nodeInfo);
	
	public boolean estaVacio(){
		return (this.root==null);
	}
		
	public void vaciaArbol(){
		this.root=null;
	}
	

	public void inOrder(clsBinaryTreeNode node){
		   if (node.getLeftChild() != null) {
	            inOrder(node.getLeftChild());
	        }
	        imprimir(node.getNodeInfo());
	        if (node.getRightChild() != null) {
	            inOrder(node.getRightChild());
	        }
	    }	

	
	
	
	public void preOrder(clsBinaryTreeNode node){
		    imprimir(node.getNodeInfo());
	        if (node.getLeftChild() != null) {
	            preOrder(node.getLeftChild());
	        }
	        if (node.getRightChild() != null) {
	            preOrder(node.getRightChild());
	        }
	}
	
	public void postOrder(clsBinaryTreeNode node){
		if (node.getLeftChild() != null) {
			postOrder(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            postOrder(node.getRightChild());
        }
        imprimir(node.getNodeInfo());
		}
	
	
	public void muestraInOrder(){
		inOrder(this.root);	
	}
	
	
	public void muestraPreOrder(){
		preOrder(this.root);
	}	

	
	public void muestraPostOrder(){
		postOrder(this.root);
	}
	
	
	///// adicional 
	
	public int cantHojas(clsBinaryTreeNode node){
   		if (node==null){
			return 0;
		}else {
			if (node.getLeftChild()==null && node.getRightChild()==null){
				return 1; // es hoja
			}else {
				return cantHojas(node.getLeftChild()) + cantHojas(node.getRightChild());
			}
		}       
		
	}
	
	public int cuentaHojas(){			
		return cantHojas(this.root);		
	}
	
	
	public int alturaArbol(clsBinaryTreeNode node)
	{
	    int alturaIzq, alturaDer;

	    if(node==null){
	    	return -1;
	    } else {
	        alturaIzq = alturaArbol(node.getLeftChild());
	        alturaDer = alturaArbol(node.getRightChild());
	        
	        if(alturaIzq>alturaDer)
	            return alturaIzq +1;
	        else
	            return alturaDer+1;
	    }
	}	
	
	
	public int altura(){
		return alturaArbol(this.root);
	}
	
	public int diferenciaAltura() {
		if(this.root==null) {
			return 0;
		}
		int alturaizq=alturaArbol(this.root.getLeftChild());
		int alturader=alturaArbol(this.root.getRightChild());
		int diferencia = alturaizq - alturader;
		return diferencia;
	}
	
	public int cantNodos(clsBinaryTreeNode node){
   		if (node==null){
			return 0;
		}else {
				return 1 +cantNodos(node.getLeftChild()) + cantNodos(node.getRightChild());			
		}		
	}
	
	
	public int cuentaNodos(){
		return cantNodos(this.root);
	}
	
	public boolean esCompleto(clsBinaryTreeNode node,int i, int totalNodos) {
		if(node==null) {
			return true;
		}
		if(i>=totalNodos) {
			return false;
		}
		return esCompleto(node.getLeftChild(),2*i,totalNodos) && esCompleto(node.getRightChild(),2*i,totalNodos);
	}
	public boolean isComplete() {
		int totalNodos = cantNodos(this.root);
		return esCompleto(this.root,0,totalNodos);
	}
	
	
	
	
	
	
	
}
