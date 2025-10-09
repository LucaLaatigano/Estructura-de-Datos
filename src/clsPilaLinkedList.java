public class clsPilaLinkedList {
    private clsNode pila;

    clsPilaLinkedList(){
        limpiaPila();
    }

    boolean pilaVacia(){
        return (this.pila==null);
    }

    void limpiaPila(){
        this.pila=null;
    }

    // inserta elemento a la derecha
    void meter(Object objElemento){
        this.pila=new clsNode(objElemento, this.pila);
        // la cabeza es el elemento ingresado
    }

    // elimina elemento ubicado m�s a la iaq
    Object sacar(){
        Object objElemento = null;
        if (!pilaVacia()){
            objElemento=this.pila.getNodeInfo();
            this.pila=this.pila.getNextNode();
        }else{
            System.out.println("Error sacar. Pila vacia");
        }
        return objElemento;
    }


    void muestra(){
        clsNode temp;
        if (!pilaVacia()){
            temp=this.pila;
            while (temp!=null){
                System.out.println("Elemento " + temp.getNodeInfo().toString());
                temp=temp.getNextNode();
            }
        }else{
            System.out.println("Error muestra. Pila vacia");
        }
    }
    Object verTope(){
        if (!pilaVacia()){
            return this.pila.getNodeInfo();
        }
        return null;
    }
    clsPilaLinkedList Coincide() {
        clsPilaLinkedList pilaAux= new clsPilaLinkedList();
        clsPilaLinkedList pilaFinal= new clsPilaLinkedList();
        int posicion=1;
        while(!pilaVacia()) {
            Object elemento = sacar();
            if(!elemento.equals(posicion)) {
                pilaAux.meter(elemento);
            }
            posicion++;
        }
        while(!pilaAux.pilaVacia()) {
            pilaFinal.meter(pilaAux.sacar());
        }
        return pilaFinal;
    }

    boolean reconocerFormato(String palabra) {
        limpiaPila();
        int i=0;
        int longitud = palabra.length();
        if(i>=longitud || palabra.charAt(i)!='a') {
            return false;
        }
        while(i< longitud && palabra.charAt(i)=='a') {
            meter('a');
            i++;

        }

        if(i>=longitud||palabra.charAt(i)!='b') {
            return false;
        }
        i++;

        if(i>=longitud || palabra.charAt(i)!='a') {
            return false;
        }
        while(i<longitud && palabra.charAt(i)=='a') {
            meter('a');
            i++;
        }
        if(i>=longitud||palabra.charAt(i)!='b') {
            return false;
        }
        i++;

        while(i<longitud && palabra.charAt(i)=='a') {
            if(pilaVacia()) {
                return false;
            }
            sacar();
            i++;

        }
        return(i==longitud && pilaVacia());

    }

}
