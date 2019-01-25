import java.util.Arrays;
/**
 * Heap
 */
public class Heap
{
    private int arr[];
    public int[] getArr()
    {
        return arr;
    }
    public void setArr(int arr[])
    {
        this.arr=arr;
    }
    public Heap(int arr[])
    {
        setArr(arr);
    }
    //><
    //Método para reparar el árbol
    public void reparar(int arr[])
    {
        //Comienza por la mitad del árbol, i es el papá en ese momento
        for(int i=arr.length/2-1; i>=0; i--)
        {
            recorr(i);
        }
    }
    
    public void recorr(int p)
    {
        if(p*2+1 < arr.length)
        {
            //Si su grado es 1, siempre va a ser el hijo izquierdo
            if(grado(p,arr)==1)
            {
                //Si es mayor el hijo, entonces que cambie los valores
                if(arr[p*2+1]>arr[p])
                {
                    int aux=arr[p];
                    arr[p]=arr[p*2+1];
                    arr[p*2+1]=aux;
                    recorr(p*2+1);
                }
            }
            //Si su grado es 2,
            else if(grado(p,arr)==2)
            {
                int i,d;
                i=arr[p*2+1];
                d=arr[p*2+2];
                //Calcula cúal hijo es el mayor y si también lo es para el papá
                if(i>d && i>arr[p])
                {
                    int aux=arr[p];
                    arr[p]=arr[p*2+1];
                    arr[p*2+1]=aux;
                    recorr(p*2+1);
                }
                else if(d>i && d>arr[p])
                {
                    int aux=arr[p];
                    arr[p]=arr[p*2+2];
                    arr[p*2+2]=aux;
                    recorr(p*2+2);
                }
            }
            //Cuando hace el cambio, se pasa el índice a sus hijos para ver si afectó a los montículos de más abajo
            //recorr(p*2+1);
            //recorr(p*2+2);
        }
    }
    //Insertar
    public void insertar(int d)
    {
        int arr2[]= new int[arr.length+1];
        arr2= Arrays.copyOf(arr,arr2.length);
        arr2[arr2.length-1]=d;
        
        int p=arr2.length-1;
        while(arr2[p] > arr2[(p-1)/2])
        {
            int aux=arr2[p];
            arr2[p]=arr2[(p-1)/2];
            arr2[(p-1)/2]=aux;
            p=(p-1)/2;
        }
        arr=arr2;
    }
    //Eliminar
    public void eliminar(int arr[])
    {   
        arr=this.arr;
        arr[0]=arr[arr.length-1];
        arr[arr.length-1]=0;
        recorr(0);
        int arr2[]= new int[arr.length-1];
        arr2= Arrays.copyOf(arr,arr2.length);
        this.arr=arr2;
    }
    
    private int arr2[];
    public void sort(int arr[])
    {
        arr=this.arr;
        this.arr2=this.arr;
        int arror[]= new int[arr.length];
        for(int i=0 ;i<arr.length; i++)
        {
            arror[i]=this.arr[0];
            eliminar(this.arr);
            System.out.print(arror[i]+", ");
        }
        System.out.println();
        this.arr=this.arr2;
    }
    //Grados
    private int grado(int p,int arr[])
    {
        arr=this.arr;
        int h=0;
        if(arr[p*2+1]!=0)
        {
            h++;
        }
        if(p*2+2 < arr.length)
        {
            h++;
        }
        return h;
    }
    //Escribir el arreglo
    public void escribir(int arr[])
    {
        arr=this.arr;
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }
    
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
        list.eliminar(nos);
        list.escribir(nos);
    }
}
