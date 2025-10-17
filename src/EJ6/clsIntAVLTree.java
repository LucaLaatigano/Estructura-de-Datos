package EJ6;


public class clsIntAVLTree extends clsAVLTree{

    @Override
    public boolean iguales(Object nodeA, Object nodeB){
        boolean response=false;
        if (((Integer)nodeA).intValue()==((Integer)nodeB).intValue()){
            response=true;
        }
        return response;
    }

    @Override
    public boolean menor(Object nodeA, Object nodeB){
        boolean response=false;
        if (((Integer)nodeA).intValue()<((Integer)nodeB).intValue()){
            response=true;
        }
        return response;
    }

    @Override
    public boolean mayor(Object nodeA, Object nodeB){
        boolean response=false;
        if (((Integer)nodeA).intValue()>((Integer)nodeB).intValue()){
            response=true;
        }
        return response;
    }

    @Override
    public void imprimir(Object node){
        System.out.println("Nodo " + node.toString());

    }
}
