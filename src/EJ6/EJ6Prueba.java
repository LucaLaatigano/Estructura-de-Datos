package EJ6;

public class EJ6Prueba {


    public static clsAVLNode construirArbolEjercicio() {
        clsAVLNode n_7 = new clsAVLNode(7); n_7.setHeight(0);
        clsAVLNode n_1 = new clsAVLNode(1); n_1.setHeight(0);
        clsAVLNode n_16 = new clsAVLNode(16); n_16.setHeight(0);
        clsAVLNode n_25 = new clsAVLNode(25); n_25.setHeight(0);

        clsAVLNode n_6 = new clsAVLNode(6, null, n_7); n_6.setHeight(1);
        clsAVLNode n_13 = new clsAVLNode(13, null, n_16); n_13.setHeight(1);
        clsAVLNode n_23 = new clsAVLNode(23, null, n_25); n_23.setHeight(1);
        clsAVLNode n_35 = new clsAVLNode(35); n_35.setHeight(0);

        clsAVLNode n_5 = new clsAVLNode(5, n_1, n_6); n_5.setHeight(2);
        clsAVLNode n_30 = new clsAVLNode(30, n_23, n_35); n_30.setHeight(2);


        clsAVLNode n_10 = new clsAVLNode(10, n_5, n_13); n_10.setHeight(3);


        return new clsAVLNode(20, n_10, n_30);
    }

    public static void main(String[] args) {
        clsIntAVLTree tree = new clsIntAVLTree();
        tree.root = construirArbolEjercicio();

        System.out.println("1. Comprobación Inicial:");

        boolean esAVL = tree.isAVL();
        System.out.println("El árbol inicial es AVL: " + esAVL);


        if (!esAVL) {
            System.out.println("2. Reequilibrio del Árbol (mediante re-inserción):");
        } else {
            System.out.println("El árbol ya está balanceado.");
        }
    }
}

