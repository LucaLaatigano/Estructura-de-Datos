package EJ6;

public class clsAVLNode {
    private Object nodeInfo;
    private clsAVLNode leftChild, rightChild;
    public int altura;


    public clsAVLNode(){
        setNodeInfo(null);
        setLeftChild(null);
        setRightChild(null);
        setHeight(0);
    }

    public clsAVLNode(Object nodeInfo){
        this(nodeInfo, null,null);
    }

    public clsAVLNode(Object nodeInfo, clsAVLNode leftChild, clsAVLNode rightChild){
        setNodeInfo(nodeInfo);
        setLeftChild(leftChild);
        setRightChild(rightChild);
    }


    public void setNodeInfo(Object nodeInfo){
        this.nodeInfo=nodeInfo;
    }

    public Object getNodeInfo(){
        return this.nodeInfo;
    }

    public void setLeftChild(clsAVLNode leftChild){
        this.leftChild=leftChild;
    }

    public void setRightChild(clsAVLNode rightChild){
        this.rightChild=rightChild;
    }


    public clsAVLNode getLeftChild(){
        return this.leftChild;
    }

    public clsAVLNode getRightChild(){
        return this.rightChild;
    }

    public int getHeight(){
        return altura;
    }

    public void setHeight(int altura){
        this.altura=altura;
    }

}
