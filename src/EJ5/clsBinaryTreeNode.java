package EJ5;


public class clsBinaryTreeNode {
    private Object nodeInfo;
    private clsBinaryTreeNode leftChild, rightChild;
    public Object clsBinaryTreeNode;


    clsBinaryTreeNode(){
        setNodeInfo(null);
        setLeftChild(null);
        setRightChild(null);
    }

    clsBinaryTreeNode(Object nodeInfo){
        this(nodeInfo, null,null);
    }

    clsBinaryTreeNode(Object nodeInfo, clsBinaryTreeNode leftChild, clsBinaryTreeNode rightChild){
        setNodeInfo(nodeInfo);
        setLeftChild(leftChild);
        setRightChild(rightChild);
    }


    void setNodeInfo(Object nodeInfo){
        this.nodeInfo=nodeInfo;
    }

    Object getNodeInfo(){
        return this.nodeInfo;
    }

    void setLeftChild(clsBinaryTreeNode leftChild){
        this.leftChild=leftChild;
    }

    void setRightChild(clsBinaryTreeNode rightChild){
        this.rightChild=rightChild;
    }


    clsBinaryTreeNode getLeftChild(){
        return this.leftChild;
    }

    clsBinaryTreeNode getRightChild(){
        return this.rightChild;
    }

    public static int sumaDiferenciaNiveles (clsBinaryTreeNode arbol, int n1, int n2, int nivel) {
        int aux = 0;

        if (arbol != null) {
            int clave = arbol.getNodeInfo() != null ? (int) arbol.getNodeInfo() : 0;

            if (nivel == n1) {
                aux = clave;
            } else if (nivel == n2) {
                aux = -clave;
            } else {
                aux = 0;
            }

            if ((nivel < n1) || (nivel < n2)) {
                aux = aux
                        + sumaDiferenciaNiveles(arbol.getLeftChild(), n1, n2, nivel + 1)
                        + sumaDiferenciaNiveles(arbol.getRightChild(), n1, n2, nivel + 1);
            }
        }
        return aux;
    }


    public static boolean comprobarSumaClavesDosNiveles (clsBinaryTreeNode raiz, int n1, int n2) {
        int diferenciaTotal = sumaDiferenciaNiveles(raiz, n1, n2, 1);

        return (diferenciaTotal == 0);
    }
}

