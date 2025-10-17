package EJ5;

public class arbolPrueba {
        public static void main(String[] args) {
            clsBinaryTreeNode tree1 = Arbol1();
            testCase(tree1, 2, 3,  true);

            clsBinaryTreeNode tree2 = Arbol2();
            testCase(tree2, 2, 3, false);

        }

    private static void testCase(clsBinaryTreeNode ruta, int n1, int n2, boolean esperado) {
        boolean resultado = clsBinaryTreeNode.comprobarSumaClavesDosNiveles(ruta, n1, n2);

        String estado = (resultado == esperado) ? "exitosa" : "allida";
        String igualdad = resultado ? "IGUALES" : "DIFERENTES";

        System.out.printf("Niveles comparandose: n1=%d, n2=%d.\n", n1, n2);
        System.out.printf("Resultado del algoritmo: %b (Las sumas son %s).\n", resultado, igualdad);
        System.out.printf(" Valor esperado: %b. Estatus: %s\n", esperado, estado);
    }




    private static clsBinaryTreeNode Arbol1() {
        clsBinaryTreeNode n3_izq = new clsBinaryTreeNode(1);
        clsBinaryTreeNode n3_der = new clsBinaryTreeNode(6);
        clsBinaryTreeNode n3_otro = new clsBinaryTreeNode(0);

        clsBinaryTreeNode n2_izq = new clsBinaryTreeNode(3, n3_izq, n3_der);
        clsBinaryTreeNode n2_der = new clsBinaryTreeNode(4, n3_otro, null);

        return new clsBinaryTreeNode(2, n2_izq, n2_der);
    }

    private static clsBinaryTreeNode Arbol2() {
        clsBinaryTreeNode n3_1 = new clsBinaryTreeNode(5);
        clsBinaryTreeNode n3_2 = new clsBinaryTreeNode(5);
        clsBinaryTreeNode n3_3 = new clsBinaryTreeNode(5);
        clsBinaryTreeNode n3_4 = new clsBinaryTreeNode(5);

        clsBinaryTreeNode n2_izq = new clsBinaryTreeNode(1, n3_1, n3_2);
        clsBinaryTreeNode n2_der = new clsBinaryTreeNode(1, n3_3, n3_4);

        return new clsBinaryTreeNode(0, n2_izq, n2_der);
    }

}
