package tadArbolComplejo;

public interface TADArbol {
		public void meter(Object nodeInfo);
		public boolean esta(Object nodeInfo);
		public void sacar(Object nodeInfo);
		public boolean estaVacio();
		public void vaciaArbol();
		public clsBinaryTreeNode devuelve(Object nodeInfo);

		public void preOrder(clsBinaryTreeNode node);
		public void inOrder(clsBinaryTreeNode node);
		public void postOrder(clsBinaryTreeNode node);
		
		
		// faltan operaciones como altura, cantidad de hojas, ....
		public int cantHojas(clsBinaryTreeNode node);
		public int alturaArbol(clsBinaryTreeNode node);
		
		
		}	

