import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Laber2
 */
public class Laber2
{
    public static void main(String arg[])
    {
        System.out.print('\u000c');
        int lab[][]= {{-1,-1,-1,-1,-1,-1,-1,-1,-1,01,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                      {-1,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,00,00,00,00,-1},
                      {-1,00,-1,-1,00,-1,-1,-1,-1,00,-1,-1,00,-1,-1,-1,00,-1,00,-1},
                      {-1,00,-1,-1,00,00,00,00,-1,00,-1,-1,00,-1,00,-1,00,-1,00,-1},
                      {-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1,00,00,00,-1},
                      {-1,00,-1,-1,00,-1,-1,00,-1,-1,00,-1,-1,-1,00,-1,00,-1,00,-1},
                      {-1,00,-1,-1,00,-1,-1,-1,-1,-1,00,-1,-1,00,00,00,00,-1,00,-1},
                      {-1,00,00,00,00,00,00,00,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1},
                      {-1,-1,-1,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,-1,-1,00,00,00,-1},
                      {-1,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,-1,-1},
                      {-1,-1,-1,00,-1,00,-1,-1,00,00,00,00,00,00,00,00,00,00,00,-1},
                      {-1,-1,-1,00,-1,00,-1,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,-1,-1},
                      {-1,00,00,00,-1,00,-1,-1,00,-1,00,00,00,00,00,00,00,00,00,-1},
                      {-1,-1,-1,-1,-1,00,-1,-1,00,00,00,-1,-1,-1,00,-1,-1,-1,00,-1},
                      {-1,-1,00,00,00,00,00,00,00,-1,00,-1,00,00,00,00,00,00,00,-1},
                      {-1,-1,00,-1,00,-1,-1,-1,00,00,00,-1,-1,-1,-1,-1,-1,00,-1,-1},
                      {-1,00,00,-1,-1,-1,-1,-1,00,-1,00,00,00,00,00,00,00,00,-1,-1},
                      {-1,-1,00,00,00,00,00,00,00,00,00,-1,00,-1,-1,00,-1,00,00,-1},
                      {-1,-1,-1,-1,-1,-1,-1,00,-1,-1,00,00,00,00,00,00,-1,-1,00,-1},
                      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,99,-1}};
                      
        Queue <Integer> fila= new LinkedList();
        Queue <Integer> col= new LinkedList();
        Stack <Integer> coordf= new Stack();
        Stack <Integer> coordc= new Stack();
        
        fila.offer(0);
        col.offer(9);
        
        int cont=0;
        while(fila.peek()+col.peek() != 36)
        {
            if(fila.isEmpty()==false && col.isEmpty()==false)
            {
                if(fila.peek() != lab.length-1 && lab[fila.peek()+1][col.peek()] == 0)
                {
                    lab[fila.peek()+1][col.peek()]=lab[fila.peek()][col.peek()]+1;
                    fila.offer(fila.peek()+1);
                    col.offer(col.peek());
                }
                if(col.peek() != lab.length-1 && lab[fila.peek()][col.peek()+1] == 0)
                {
                    lab[fila.peek()][col.peek()+1]=lab[fila.peek()][col.peek()]+1;
                    fila.offer(fila.peek());
                    col.offer(col.peek()+1);
                }
                if(fila.peek() != 0 && lab[fila.peek()-1][col.peek()] == 0)
                {
                    lab[fila.peek()-1][col.peek()]=lab[fila.peek()][col.peek()]+1;
                    fila.offer(fila.peek()-1);
                    col.offer(col.peek());
                }
                if(col.peek() != 0 && lab[fila.peek()][col.peek()-1] == 0)
                {
                    lab[fila.peek()][col.peek()-1]=lab[fila.peek()][col.peek()]+1;
                    fila.offer(fila.peek());
                    col.offer(col.peek()-1);
                }
                cont= lab[fila.peek()][col.peek()]+1;
                fila.poll();
                col.poll();
            }
        }
        
        //><
        for(int f=0; f<lab.length; f++)
        {
            for(int c=0; c<lab[f].length; c++)
            {
                if(lab[f][c] >= 0 && lab[f][c] < 10)
                System.out.print(lab[f][c]+"0 ");
                else
                System.out.print(lab[f][c]+" ");
            }
            System.out.println();
        }
        coordf.push(fila.poll());
        coordc.push(col.poll());
        System.out.println();
        
        for(int i=0;i<cont;i++)
        {
            if(coordf.peek() != lab.length-1 && lab[coordf.peek()+1][coordc.peek()] == lab[coordf.peek()][coordc.peek()]-1)
            {
                coordf.push(coordf.peek()+1);
                coordc.push(coordc.peek());
            }
            else if(coordc.peek() != lab.length-1 && lab[coordf.peek()][coordc.peek()+1] == lab[coordf.peek()][coordc.peek()]-1)
            {
                coordf.push(coordf.peek());
                coordc.push(coordc.peek()+1);
            }
            else if(coordf.peek() != 0 && lab[coordf.peek()-1][coordc.peek()] == lab[coordf.peek()][coordc.peek()]-1)
            {
                coordf.push(coordf.peek()-1);
                coordc.push(coordc.peek());
            }
            else if(coordc.peek() != 0 && lab[coordf.peek()][coordc.peek()-1] == lab[coordf.peek()][coordc.peek()]-1)
            {
                coordf.push(coordf.peek());
                coordc.push(coordc.peek()-1);
            }
        }
        
        for(int i=0; i<cont; i++)
        {
            System.out.println("["+coordf.pop()+","+coordc.pop()+"]");
        }
    }
}
