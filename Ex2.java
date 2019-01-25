import java.util.Scanner;
import java.util.Stack;
/**
 * Examen BST
 */
public class Ex2
{
    static public void main(String arg[])
    {
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        String datasets;
        Stack <Character> letras= new Stack();
        Tree pre= new Tree();
        
        datasets= tc.nextLine();
        //Se convierten los caracteres a mayúsculas
        datasets= datasets.toUpperCase();
        int pos,datsize=0;
        int arr[]= new int[2048];
        for(int i=0; i<datasets.length(); i++)
        {
            //Se recorre el String y si son letras, se meten a la pila y se aumenta el tamaño
            if(datasets.charAt(i)>=65 && datasets.charAt(i)<=90)
            {
                letras.push(datasets.charAt(i));
                datsize++;
            }
            //Si es * o $, se terminan esos datos
            if(datasets.charAt(i)=='*' || datasets.charAt(i)=='$')
            {
                int max=0;
                for(int i2=0; i2<datsize; i2++)
                {
                    pos=0;
                    //Se leen las letras de la pila, la última es la raíz
                    while(arr[pos]!=0)
                    {
                        if(letras.peek() > arr[pos])
                        {
                            pos=2*pos+2;
                        }
                        else if(letras.peek() < arr[pos])
                        {
                            pos=2*pos+1;
                        }
                    }
                    //Se asignan los valores de cada letra de la pila en el arreglo árbol
                    arr[pos]=letras.pop();
                    //Se busca cual es la casilla más lejana
                    if(pos>max)
                    {
                        max=pos;
                    }
                }
                //Se invoca el recorrido PreOrden de la clase Tree
                //Se modificó para que escribiera los int como char
                pre.recPre(0,arr);
                //El tamaño de los datos se reinicia a 0 para los siguientes
                datsize=0;
                //Con el tamaño máximo no se recorre todo el arreglo
                for(int i3=0; i3<=max; i3++)
                {
                    //Se borran los datos del arreglo para los siguientes
                    if(arr[i3]!=0)
                    {
                        arr[i3]=0;
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
    //BDHPYCMGQK*ACB$
    //HKFYD*GDNA*QWERTYUIOPASDFGHJCVBNM$
}
