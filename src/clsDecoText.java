public class clsDecoText {
    private clsColaLinkedList lista;
    private clsPilaLinkedList pila;
    private String entrada, salida;
    clsDecoText(String texto){
        lista=new clsColaLinkedList();
        pila=new clsPilaLinkedList();
        entrada=texto;
        salida="";
    }

    String decodificar(){
        cargarLista();
        String ban="00";
        char letra;
        Object elemento;
        while (!lista.colaVacia()){
            elemento=lista.sacar();
            letra=((Character)elemento).charValue();
            switch (ban){
                case "00":{
                    if(letra=='Z') ban="Z";
                };
                break;

                case "Z":{
                    if(letra!='Z'){
                        if(letra=='X')ban="ZX";
                        else ban="00";
                    }
                };
                break;

                case "ZX":{//clave para el ingreso de datos
                    pila.meter(new Character(letra));
                    if (letra=='X') ban="X";
                };
                break;

                case "X":{
                    if (letra=='Z'){//fin de palabra
                        vaciarPila();
                        ban="00";
                    }else{
                        pila.meter(new Character(letra));
                        if (letra!='X') ban="ZX";
                    }
                };
                break;
            }

        }
        return salida;
    }

    private void cargarLista(){
        for(int k=0;k<entrada.length();k++){
            lista.meter(new Character(entrada.charAt(k)));
        }
    }

    private void vaciarPila(){
        pila.sacar();
        while (!pila.pilaVacia()){
            salida+=((Character)pila.sacar()).toString();
        }
        salida+=" ";
    }
}
