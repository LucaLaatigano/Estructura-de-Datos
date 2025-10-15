package tadArbolComplejo;
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
		if (node!=null){
			inOrder(node.getLeftChild());
			imprimir(node.getNodeInfo());
			inOrder(node.getRightChild());
		}
	}	

	
	
	
	public void preOrder(clsBinaryTreeNode node){
      // completar
	}
	
	
	public void postOrder(clsBinaryTreeNode node){
		// completar
	}	
	
	
	public void muestraInOrder(){
		inOrder(this.root);	
	}
	
	
	public void muestraPreOrder(){
		// completar
	}	

	
	public void muestraPostOrder(){
		// completar
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
	
	
	
	
	
	
	
	
	
}
