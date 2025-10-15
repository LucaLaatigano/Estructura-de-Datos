package arboles;
/*
 * 
 * Arbol binario
 * 
 */
import java.util.Optional;


public class TreeTest {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.add(5);
        root.add(15);
        root.add(8);
 
        Optional<Node> result = root.find(11);// Elemento a buscar!!!
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Valor no encontrado");
        }
 
        result = root.find(8);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Valor no encontrado");
        }
        System.out.println();
        System.out.println("Imprime: in order");
      
        root.printInOrder();
        
        System.out.println();
        System.out.println("Imprime: pos order");
        
        root.printPosOrder();
        
        System.out.println();
        System.out.println("Imprime: pre order");
        
        root.printPreOrder();
    }
}