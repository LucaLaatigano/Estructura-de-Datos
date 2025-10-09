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


    //METODOS AGREGADOS DEL EJERCICIO 9
    public clsColaLinkedList inversa() {
        clsPilaLinkedList pilaAuxiliar = new clsPilaLinkedList();
        clsColaLinkedList colaInversa = new clsColaLinkedList();
        while (!this.colaVacia()) {
            pilaAuxiliar.meter(this.sacar());
        }

        while (!pilaAuxiliar.pilaVacia()) {
            colaInversa.meter(pilaAuxiliar.sacar());
        }

        return colaInversa;
    }

    public void concatenar(clsColaLinkedList otraCola) {
        while (!otraCola.colaVacia()) {
            this.meter(otraCola.sacar());
        }
    }

    public clsColaLinkedList intercalar(clsColaLinkedList otraCola) {
        clsColaLinkedList colaResultante = new clsColaLinkedList();
        while (!this.colaVacia() || !otraCola.colaVacia()) {
            if (!this.colaVacia()) {
                colaResultante.meter(this.sacar());
            }

            if (!otraCola.colaVacia()) {
                colaResultante.meter(otraCola.sacar());
            }
        }

        return colaResultante;
    }

    //metodos para resolver el EJ10
    void meterChar(String mensaje){
        Object caracter;

        for (int i=0;i<mensaje.length();i++) {
            caracter = mensaje.substring(i, i+1);
            if (!colaVacia()){
                this.finalC.setNextNode(new clsNode(caracter));
                this.finalC=this.finalC.getNextNode();
            }else{
                this.frenteC=this.finalC= new clsNode(caracter);
            }
        }
    }
    void Espejo(clsColaLinkedList objColaEspejo){
        clsNode temp;
        clsPilaLinkedList objPila = new clsPilaLinkedList();
        if (!colaVacia()){
            temp=this.frenteC;
            while (temp!=null){
                if (!(temp.getNodeInfo().toString().equals("a") || temp.getNodeInfo().toString().equals("e") || temp.getNodeInfo().toString().equals("i") || temp.getNodeInfo().toString().equals("o") || temp.getNodeInfo().toString().equals("u")))
                    objPila.meter(temp.getNodeInfo().toString());
                else
                {
                    while (!objPila.pilaVacia()) {
                        objColaEspejo.meter(objPila.sacar().toString());
                    }
                }
                if (objPila.pilaVacia())
                    objColaEspejo.meter(temp.getNodeInfo().toString());
                temp=temp.getNextNode();
            }
            while (!objPila.pilaVacia()) {
                objColaEspejo.meter(objPila.sacar().toString());
            }

        }else{
            System.out.println("Error muestra. Cola vacia");
        }
    }

}