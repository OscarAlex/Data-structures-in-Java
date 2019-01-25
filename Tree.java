import java.util.Scanner;
/**
 * Arbol binario
 */
public class Tree
{
    int arr2[]= new int[100];
    boolean arr3[]= new boolean[100];
    static public void main(String arg[])
    {
        Tree rec= new Tree();
        System.out.print('\u000c');
        Scanner tc2= new Scanner(System.in);
        int arr[]= new int[1000];
        int no,pos;
        
        for(int i=0; i<10; i++)
        {
            no= tc2.nextInt();
            pos=0;
            while(arr[pos]!=0)
            {
                if(no > arr[pos])
                {
                    pos=2*pos+2;
                }
                else if(no < arr[pos])
                {
                    pos=2*pos+1;
                }
            }
            arr[pos]=no;
        }
        //6 3 2 21 57 76 274 88 4 8
        //20 18 17 8 3 12 75 23 82 80
        //20 50 60 35 32 40 70 65 80 95
    }
    //Recorridos
    public void recOrden(int p, int arr[])
    {
        if(arr[p] != 0)
        {
            recOrden(p*2+1,arr);
            System.out.print(arr[p]+", ");
            recOrden(p*2+2,arr);
        }
    }
    public void recPre(int p, int arr[])
    {
        if(arr[p] != 0)
        {
            System.out.print((char)arr[p]);
            recPre(p*2+1,arr);
            recPre(p*2+2,arr);
        }
    }
    public void recPos(int p, int arr[])
    {
        if(arr[p] != 0)
        {
            recPos(p*2+1,arr);
            recPos(p*2+2,arr);
            System.out.print(arr[p]+", ");
        }
    }
    //Cosas para eliminar
    public void recPrel1(int p, int arr[])
    {
        if(arr[p] != 0)
        {
            if(arr[p*2+1]!=0)
            {
                arr[p]=arr[p*2+1];
            }
            else if(arr[p*2+2]!=0)
            {
                arr[p]=arr[p*2+2];
            }
            else if(arr[p/2]==0 && arr3[p]==false && arr3[p/2]==false)
            {
                arr[p/2]=arr[p];
                arr3[p/2]=true;
            }
            if(arr[p*2+1]==0 && arr[p*2+2]==0 && arr3[p]==false)
            {
                arr[p]=0;
            }
            recPrel1(p*2+1,arr);
            recPrel1(p*2+2,arr);
        }
    }
    public void recPrel11(int p, int arr[])
    {
        if(arr[p] != 0)
        {
            if(arr[p*2+1]!=0)
            {
                arr[p]=arr[p*2+1];
            }
            else if(arr[p*2+2]!=0)
            {
                arr[p]=arr[p*2+2];
            }
            else if(arr[p/2]==0 && arr3[p]==false && arr3[p/2]==false)
            {
                arr[p/2]=arr[p];
                arr3[p/2]=true;
            }
            if(arr[p*2+1]==0 && arr[p*2+2]==0 && arr3[p]==false)
            {
                arr[p]=0;
            }
            recPrel11(p*2+2,arr);
            recPrel11(p*2+1,arr);
        }
    }
    public void recPrel2(int p, int arr[],char d)
    {
        if(arr[p] != 0)
        {
            if(d == 'd')
            {
                int p1=p*2+2;
                while(arr[2*p1+1]!=0)
                {
                    p1=2*p1+1;
                }
                arr[p]=arr[p1];
                recPrel1(p,arr);
            }
            else
            {
                int p1=p*2+1;
                while(arr[2*p1+2]!=0)
                {
                    p1=2*p1+2;
                }
                arr[p]=arr[p1];
                recPrel11(p,arr);
            }
        }
    }
    public void eliminar(int no)
    {
        int x= buscar(no,arr2);
        int y= grado(x,arr2);
        if(y==0)
        {
            grado0(x);
        }
        else if(y==1)
        {
            recPrel1(x,arr2);
        }
        else
        {
            recPrel2(x,arr2,'i');
        }
    }
    private boolean grado0(int p)
    {
        arr2[p]=0;
        return true;
    }
    //Imprimir nodos por nivel
    public void recNivel(int arr[])
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] != 0)
            {
                System.out.print(arr[i]+", ");
            }
        }
    }
    //Buscar la posición de un valor
    public int buscar(int no, int arr[])
    {
        int pos=0;
        while(pos<arr.length && arr[pos]!=no)
        {
            if(no > arr[pos])
            {
                pos=2*pos+2;
            }
            else if(no < arr[pos])
            {
                pos=2*pos+1;
            }
            if(pos > arr.length)
            {
                return -1;
            }
        }
        return pos;
    }
    //Saber el número de hijos que tienen un nodo
    private int grado(int p,int arr[])
    {
        int cont=0;
        if(arr[p*2+1]!=0)
        {
            cont++;
        }
        if(arr[p*2+2]!=0)
        {
            cont++;
        }
        return cont;
    }
}
