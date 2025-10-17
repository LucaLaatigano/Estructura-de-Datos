package EJ6;

public abstract class clsAVLTree {
    protected clsAVLNode root;

    public abstract boolean mayor(Object nodeA, Object B);
    public abstract boolean menor(Object nodeA, Object B);
    public abstract boolean iguales(Object nodeA, Object B);
    public abstract void imprimir(Object nodeInfo);


    public void meterAVL(Object nodeInfo){
        this.root = meterR(this.root, nodeInfo);
    }

    public boolean estaVacio(){
        return this.root==null;
    }


    public void inOrder(){
        if(estaVacio( ) )
            System.out.println( "Arbol AVL vacio" );
        else
            inOrder(this.root);
    }

    private void inOrder(clsAVLNode node){
        if (node!=null){
            inOrder(node.getLeftChild());
            imprimir(node.getNodeInfo());
            inOrder(node.getRightChild());
        }
    }


    private clsAVLNode meterR(clsAVLNode node, Object nodeInfo){
        int b, izq, der;
        if (node==null){
            node= new clsAVLNode(nodeInfo);
        }else {
            if (mayor(node.getNodeInfo(), nodeInfo)){
                node.setLeftChild(meterR(node.getLeftChild(),nodeInfo));
                node =balancear(node);
            } else {
                // es menor
                node.setRightChild(meterR(node.getRightChild(),nodeInfo));
                node= balancear(node);
            }
        }


        System.out.println("intentando meter " + nodeInfo.toString());
        izq=height(node.getLeftChild());
        der=height(node.getRightChild());
        System.out.println("altura subizq " + izq);
        System.out.println("altura der " + der);

        b=max(izq,der)+1;
        node.setHeight(b);

        return node;
    }


    public clsAVLNode balancear(clsAVLNode node){

        if (height(node.getLeftChild()) - height(node.getRightChild())==2){
            System.out.println("hay desequilibrio izquierda >");
            if (height(node.getLeftChild().getLeftChild()) >= height(node.getLeftChild().getRightChild())){
                System.out.println("-> simple");
                return rotacionSimple(node, true);
            }else {
                System.out.println("-> doble");
                return rotacionDoble(node, true);
            }
        }else {
            if (height(node.getRightChild()) -height(node.getLeftChild())==2){
                System.out.println("hay desequilibrio derecha >");
                if (height(node.getRightChild().getRightChild()) >= height(node.getRightChild().getLeftChild())){
                    System.out.println("> simple");
                    return rotacionSimple(node,false);
                }else {
                    System.out.println("> doble");
                    return rotacionDoble(node,false);
                }
            } else {
                return node;
            }
        }
    }


    public clsAVLNode rotacionSimple (clsAVLNode node, boolean esIzquierda){
        clsAVLNode temp;
        if (esIzquierda){
            temp=node.getLeftChild();
            node.setLeftChild(temp.getRightChild());
            temp.setRightChild(node);

            node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild()))+1);
            temp.setHeight(max(height(temp.getLeftChild()), node.getHeight())+1);

        }else{
            temp=node.getRightChild();
            node.setRightChild(temp.getLeftChild());
            temp.setLeftChild(node);

            node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild()))+1);
            temp.setHeight(max(height(temp.getRightChild()), node.getHeight())+1);
        }
        return temp;
    }


    public clsAVLNode rotacionDoble(clsAVLNode node, boolean esIzquierda){
        if (esIzquierda){
            node.setLeftChild(rotacionSimple(node.getLeftChild(),false));
            return rotacionSimple(node, true);
        }else {
            node.setRightChild(rotacionSimple(node.getRightChild(),true));
            return rotacionSimple(node, false);
        }
    }

    public static int height(clsAVLNode node){
        if (node==null)
            return -1;
        return node.getHeight();
    }


    public static int max( int a, int b){
        if (a>b)
            return a;
        else
            return b;
    }

    public int getBalanceFactor(clsAVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    public boolean isAVL() {
        return isAVL(this.root);
    }

    private boolean isAVL(clsAVLNode node) {
        if (node == null) {
            return true;
        }
        if (node.getLeftChild() != null && mayor(node.getLeftChild().getNodeInfo(), node.getNodeInfo())) {
            System.out.println("Falla BST: Hijo izquierdo (" + node.getLeftChild().getNodeInfo() + ") es mayor que padre (" + node.getNodeInfo() + ")");
            return false;
        }
        if (node.getRightChild() != null && menor(node.getRightChild().getNodeInfo(), node.getNodeInfo())) {
            System.out.println("Falla BST: Hijo derecho (" + node.getRightChild().getNodeInfo() + ") es menor que padre (" + node.getNodeInfo() + ")");
            return false;
        }


        int fb = getBalanceFactor(node);


        if (fb < -1 || fb > 1) {
            System.out.println("Falla AVL en nodo " + node.getNodeInfo() + ". FB: " + fb);
            return false;
        }

        return isAVL(node.getLeftChild()) && isAVL(node.getRightChild());
    }
}