import java.util.Queue;
import java.util.LinkedList;
/**
 * Labeling
 */
public class Label
{
    public static void main(String arg[])
    {
        System.out.print('\u000c');
        int tf=10,tc=10;
        int arr[][]= new int[tf][tc];
        Queue <Integer> fila= new LinkedList();
        Queue <Integer> col= new LinkedList();
        int cont=2;
        //Se llena la matriz de 1s
        for(int v=1; v<=tf*tc*.3; v++)
        {
            int f,c;
            do
            {
                f=(int)(Math.random()*tf);
                c=(int)(Math.random()*tc);
            }
            while(arr[f][c] == 1);
            arr[f][c]= 1;
        }
        //Se escribe la matriz con 1s
        for(int f=0; f<arr.length; f++)
        {
            for(int c=0; c<arr[f].length; c++)
            {
                System.out.print(" 0"+arr[f][c]);
            }
            System.out.println();
        }
        //Se recorre la matriz con 1s
        for(int f=0; f<arr.length; f++)
        {
            for(int c=0; c<arr[f].length; c++)
            {
                if(arr[f][c] == 1)
                {
                    //Se agregan las coordenadas a las colas
                    fila.offer(f);
                    col.offer(c);
                    while(fila.isEmpty()==false && col.isEmpty()==false)
                    {
                        int ft= fila.peek();
                        int ct= col.peek();
                        arr[ft][ct]=cont;
                        //Se escanean 4 vecinos de la coordenada (ft,ct) y se guardan como nuevas coordenadas si su valor es todavía 1
                        if(ft != arr.length-1 && arr[ft+1][ct] == 1)
                        {
                            arr[ft+1][ct]=cont;
                            fila.offer(ft+1);
                            col.offer(ct);
                        }
                        if(ct != arr.length-1 && arr[ft][ct+1] == 1)
                        {
                            arr[ft][ct+1]=cont;
                            fila.offer(ft);
                            col.offer(ct+1);
                        }
                        if(ft != 0 && arr[ft-1][ct] == 1)
                        {
                            arr[ft-1][ct]=cont;
                            fila.offer(fila.peek()-1);
                            col.offer(col.peek());
                        }
                        if(ct != 0 && arr[ft][ct-1] == 1)
                        {
                            arr[ft][ct-1]=cont;
                            fila.offer(fila.peek());
                            col.offer(col.peek()-1);
                        }
                        //Se eliminan las coordenadas una vez que se escanearon sus vecinos y se cambio su valor
                        fila.poll();
                        col.poll();
                    }
                    cont++;
                }
            }
        }
        
        //><
        System.out.println();
        for(int f=0; f<arr.length; f++)
        {
            for(int c=0; c<arr[f].length; c++)
            {
                if(arr[f][c]>=0 && arr[f][c] <10)
                System.out.print(" 0"+arr[f][c]);
                else
                System.out.print(" "+arr[f][c]);
            }
            System.out.println();
        }
    }
}
