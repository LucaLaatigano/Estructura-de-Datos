public class clsListaLinkedList {
    private clsNode tope, lista;

    clsListaLinkedList(){
        limpiaLista();
    }

    boolean estaVacia(){
        return (lista==null);
    }


    void limpiaLista(){
        this.tope=this.lista=null;;
    }


    // inserta elemento a la derecha
    void insertaFin(Object objElemento){
        if (!estaVacia()){
            this.lista.setNextNode(new clsNode(objElemento));
            this.lista=this.lista.getNextNode();
        }else{
            this.tope = this.lista=new clsNode(objElemento);
        }
    }

    // elimina elemento ubicado m�s a la derecha
    void eliminaFin(){
        if (!estaVacia()){
            if (this.lista==this.tope){
                // un solo elemento
                limpiaLista();
            }else{
                clsNode temp;
                for (temp=this.tope;temp.getNextNode()!=lista;temp=temp.getNextNode());
                this.lista=temp;
                this.lista.setNextNode(null);
            }
        }else{
            System.out.println("Error eliminaFin. Lista vacia");
        }
    }


    // inserta elemento a la izq
    void insertaTope(Object objElemento){
        if (!estaVacia()){
            this.tope = new clsNode(objElemento,this.tope);
        }else{
            this.tope = this.lista=new clsNode(objElemento);
        }
    }


    // elimina elemento ubicado m�s a la izq
    void eliminaTope(){
        if (!estaVacia()){
            if (this.lista==this.tope){
                // un solo elemento
                limpiaLista();
            }else{
                this.tope=this.tope.getNextNode();
            }
        }else{
            System.out.println("Error eliminaTope. Lista vacia");
        }
    }


    void muestra(){
        clsNode temp;
        if (!estaVacia()){
            temp=this.tope;
            while (temp!=null){
                System.out.println("Elemento " + temp.getNodeInfo().toString());
                temp=temp.getNextNode();
            }
        }else{
            System.out.println("Error muestra. Lista vacia");
        }
    }

    clsNode getTope(){return tope;}

}
