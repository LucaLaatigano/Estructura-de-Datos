package ArbolBinarioGrafico;



import java.awt.*;
import java.util.*;
import javax.swing.*;


public class ArbolExpresionGrafico extends JPanel 
{
  private ArbolBG miArbol;
  private HashMap posicionNodos = null;
  private HashMap subtreeSizes = null;
  private boolean dirty = true;
  private int parent2child = 20, child2child = 30;
  private Dimension empty = new Dimension(0,0);
  private FontMetrics fm = null;
  
  
  /**
   * Constructor de la clase ArbolExpresionGrafico.
   * El constructor permite inicializar los atributos de la clase ArbolExpresionGrafico
   * y llama al m�todo repaint(), que es el encargado de pintar el Arbol.
   * @param miExpresion: dato de tipo ArbolExpresion que contiene el Arbol a
   * dibujar.
   */
  
  public ArbolExpresionGrafico(ArbolBG miArbol) 
  {
        this.miArbol = miArbol;
        this.setBackground(Color.WHITE);
        posicionNodos = new HashMap();
        subtreeSizes = new HashMap();
        dirty = true;
        repaint();      
  }


  /**
   * Calcula las posiciones de los respectivos sub�rboles y de cada nodo que 
   * forma parte de ese sub�rbol, para conocer en que posici�n van a ir dibujados
   * los rect�ngulos representativos del �rbol de la expresi�n.
   */
  private void calcularPosiciones() 
  {
       posicionNodos.clear();
       subtreeSizes.clear();
       Nodo root = this.miArbol.getRaiz();
       if (root != null) 
       {
           calcularTamañoSubarbol(root);
           calcularPosicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
       }
  }
  
  /**
   * Calcula el tama�o de cada sub�rbol y lo agrega al objeto subtreeSizes de la clase
   * de tipo HashMap que va a contener la coleccion de todos los 
   * sub�rboles que contiene un arbol.
   * @param n:Objeto de la clase NodoB <T> que se utiliza como
   * referencia calcular el tama�o de cada sub�rbol.
   * @return Dimension con el tama�o de cada sub�rbol.
   */
  private Dimension calcularTamañoSubarbol(Nodo n) 
  {
        if (n == null) 
            return new Dimension(0,0);

        Dimension ld = calcularTamañoSubarbol(n.getIzq());
        Dimension rd = calcularTamañoSubarbol(n.getDer());
        
        int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
        int w = ld.width + child2child + rd.width;
        
        Dimension d = new Dimension(w, h);
        subtreeSizes.put(n, d);
        
        return d;
  }
  
  
  /**
   * Calcula la ubicaci�n de cada nodo de cada sub�rbol y agrega cada nodo con 
   * un objeto de tipo Rectangule que tiene la ubicaci�n y la informaci�n espec�fica de d�nde 
   * va a ser dibujado.
   * @param n: Objeto de tipo NodoB <T> que se utiliza como
   * referencia para calcular la ubicaci�n de cada nodo.
   * @param left: int con alineaci�n y orientaci�n a la izquierda.
   * @param right: int con alineaci�n y orientaci�n a la derecha.
   * @param top: int con el tope.
   */
  private void calcularPosicion(Nodo n, int left, int right, int top) 
  {
    if (n == null) 
        return;
    
    Dimension ld = (Dimension) subtreeSizes.get(n.getIzq());
    if (ld == null) 
        ld = empty;
    
    Dimension rd = (Dimension) subtreeSizes.get(n.getDer());
    if (rd == null) 
        rd = empty;
    
    int center = 0;
    
    if (right != Integer.MAX_VALUE)
        center = right - rd.width - child2child/2;
    else if (left != Integer.MAX_VALUE)
        center = left + ld.width + child2child/2;
    int width = fm.stringWidth(n.getDato()+"");

    posicionNodos.put(n,new Rectangle(center - width/2 - 3, top, width + 6, fm.getHeight()));
    
    calcularPosicion(n.getIzq(), Integer.MAX_VALUE, center - child2child/2, top + fm.getHeight() + parent2child);
    calcularPosicion(n.getDer(), center + child2child/2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
  }
  
  /**
   * Dibuja el �rbol teniendo en cuenta las ubicaciones de los nodos y los 
   * sub�rboles calculadas anteriormente.
   * @param g: Objeto de la clase Graphics2D que permite realizar el dibujo de las l�neas, rectangulos y del String de la informaci�n que contiene el Nodo.
   * @param n: Objeto de la clase NodoB <T> que se utiliza como referencia para dibujar el �rbol.
   * @param puntox: int con la posici�n en x desde donde se va a dibujar la l�nea hasta el siguiente hijo.
   * @param puntoy: int con la posici�n en y desde donde se va a dibujar la l�nea hasta el siguiente hijo.
   * @param yoffs: int con la altura del FontMetrics.
   */
  private void dibujarArbol(Graphics2D g, Nodo n, int puntox, int puntoy, int yoffs) 
  {
   if (n == null) 
       return;
   
   Rectangle r = (Rectangle) posicionNodos.get(n);
   g.draw(r);
   g.drawString(n.getDato()+"", r.x + 3, r.y + yoffs);
 
   if (puntox != Integer.MAX_VALUE)
     
   g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);
   
   dibujarArbol(g, n.getIzq(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
   dibujarArbol(g, n.getDer(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
   
 }
  

 /**
   * Sobreescribe el metodo paint y se encarga de pintar todo el �rbol.
   * @param g: Objeto de la clase Graphics.
   */
  @Override
 public void paint(Graphics g) 
 {
       super.paint(g);
       fm = g.getFontMetrics();

       if (dirty) 
       {
         calcularPosiciones();
         dirty = false;
       }
       
       Graphics2D g2d = (Graphics2D) g;
       g2d.translate(getWidth() / 2, parent2child);
       dibujarArbol(g2d, this.miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, 
                fm.getLeading() + fm.getAscent());
       fm = null;
 }
 
}




