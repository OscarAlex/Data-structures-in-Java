
/**
 * HBLT
 */
public class HBLT
{
    public static void main()
    {
        System.out.print('\u000c');
        int lista[]= {4,8,10,9,1,3,5,6,11};
        LeftistTrees tree= new LeftistTrees(lista);
        tree.unite();
        tree.imprimir();
        System.out.println();
    }
}
