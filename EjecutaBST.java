
/**
 * EjecutaBST
 */
public class EjecutaBST
{
    static public void main(String arg[])
    {
        System.out.print('\u000c');
        //BST miLista= new BST(new NodoBST(50));
        int lista[]={50,90,70,40,60,80,10,30,20,100,75};
        BST miLista2= new BST(lista);
        
        //miLista.insertar(new NodoBST(80));
        //miLista.insertar(new NodoBST(60));
        
        //miLista2.recPre(miLista2.getRaiz());
        System.out.println();
        miLista2.recNor(miLista2.getRaiz());
        System.out.println();
        //miLista2.recPos(miLista2.getRaiz());
        System.out.println();
        miLista2.recNivel(miLista2.getRaiz());
        System.out.println();
        miLista2.buscar(40);
        System.out.println();
        miLista2.eliminar(50);
        System.out.println();
        
        char lista2[]={65,66};
        System.out.println(lista2[0]);
        System.out.println(lista2[1]);
    }
}
