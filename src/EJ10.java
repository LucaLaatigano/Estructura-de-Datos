public class EJ10 {
    public static void main(String[] args) {
        clsColaLinkedList objCola = new clsColaLinkedList();
        clsColaLinkedList objColaEspejo = new clsColaLinkedList();
        objCola.meterChar("Bond, James Bond");
        objCola.Espejo(objColaEspejo);
        objColaEspejo.muestra();
    }
}
