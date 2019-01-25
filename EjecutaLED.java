
/**
 * EjecutaLED
 */
public class EjecutaLED
{
    static public void main(String arg[])
    {
        System.out.print('\u000c');
        LED miLista= new LED();
        
        //miLista.insertarPrincipio(new NodoD(10));
        //miLista.insertarPrincipio(new NodoD(110));
        //miLista.insertarPrincipio(new NodoD(90));
        
        miLista.insertarFinal(new NodoD(40));
        miLista.insertarFinal(new NodoD(60));
        miLista.insertarFinal(new NodoD(70));
        
        miLista.insertarPos(new NodoD(50),2);
        miLista.insertarPos(new NodoD(30),2);
        
        miLista.eliminarPrincipio();
        //miLista.eliminarPos(2);
        
        miLista.imprimirR();
        //System.out.println();
        //miLista.imprimirF();
    }
}
