
/**
 * HeapSort
 */
public class HeapSort
{
    public static void main(String arg[])
    {
        int nos[]= {10,21,12,5,7,16,25,23,8,31};
        Heap list=new Heap(nos);
        System.out.print('\u000c');
        
        list.escribir(nos);
        list.reparar(nos);
        list.insertar(32);
        list.escribir(nos);
        list.insertar(2);
        list.escribir(nos);
        list.sort(nos);
        list.escribir(nos);
    }
}
