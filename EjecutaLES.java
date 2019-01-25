
/**
 * EjecutaLES
 */
public class EjecutaLES
{
    static public void main(String arg[])
    {
        System.out.print('\u000c');
        LES miLista= new LES(new Nodo(100));
        //miLista.imprimir();
        
        miLista.insertarPrincipio(new Nodo(110));
        miLista.insertarPrincipio(new Nodo(90));
        miLista.insertarPrincipio(new Nodo(130));
        
        miLista.insertarFinal(new Nodo(120));
        miLista.insertarFinal(new Nodo(140));
        miLista.insertarFinal(new Nodo(70));
        
        miLista.insertarPrincipio(new Nodo(200));
        miLista.insertarFinal(new Nodo(150));
        miLista.insertarPrincipio(new Nodo(40));
        miLista.insertarFinal(new Nodo(60));
        miLista.insertarFinal(new Nodo(80));
        miLista.insertarPrincipio(new Nodo(100));
        
        //miLista.eliminarPrincipio();
        //miLista.eliminarFinal();
        //miLista.eliminarPos(0);
        
        //miLista.insertarPos(new Nodo(1),7);
        //miLista.insertarPos(new Nodo(2),15);
        //miLista.insertarPos(new Nodo(3),33);
        
        miLista.imprimir();
        System.out.println();
        System.out.print(miLista.getTam());
    }
}
