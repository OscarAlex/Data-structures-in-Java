import java.util.Stack;
/**
 * Laber
 */
public class Laber
{
    public static void main()
    {
        System.out.print('\u000c');
        int lab[][]= {{-1,-1,-1,-1,-1,-1,-1,-1,-1,04,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
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
                      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,05,-1}};
        //int act,sig;
        //int act;
        Stack <Integer> fila= new Stack();
        Stack <Integer> col= new Stack();
        
        
        fila.push(0);
        col.push(9);
        lab[0][9]=3;
        
        //while(fila.peek()!=19 && col.peek()!=18)
        while(fila.peek()+col.peek() != 36)
        {
            if(fila.peek() != lab.length-1 && lab[fila.peek()+1][col.peek()] == 0)
            {
                lab[fila.peek()+1][col.peek()]=3;
                lab[fila.peek()][col.peek()]=1;
                fila.push(fila.peek()+1);
                col.push(col.peek()); 
            }
            else if(col.peek() != lab.length-1 && lab[fila.peek()][col.peek()+1] == 0)
            {
                lab[fila.peek()][col.peek()+1]=3;
                lab[fila.peek()][col.peek()]=1;
                fila.push(fila.peek());
                col.push(col.peek()+1);
            }
            else if(fila.peek() != 0 && lab[fila.peek()-1][col.peek()] == 0)
            {
                lab[fila.peek()-1][col.peek()]=3;
                lab[fila.peek()][col.peek()]=1;
                fila.push(fila.peek()-1);
                col.push(col.peek());
            }
            else if(col.peek() != 0 && lab[fila.peek()][col.peek()-1] == 0)
            {
                lab[fila.peek()][col.peek()-1]=3;
                lab[fila.peek()][col.peek()]=1;
                fila.push(fila.peek());
                col.push(col.peek()-1);
            }
            else
            {
                lab[fila.peek()][col.peek()]=2;
                fila.pop();
                col.pop();
            }
            for(int f=0; f<lab.length; f++)
            {
                for(int c=0; c<lab[f].length; c++)
                {
                    if(lab[f][c] == 0 || lab[f][c] == 1 || lab[f][c] == 3)
                    System.out.print(lab[f][c]+"0 ");
                    else
                    System.out.print(lab[f][c]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        for(int f=0; f<lab.length; f++)
        {
            for(int c=0; c<lab[f].length; c++)
            {
                if(lab[f][c] == 0 || lab[f][c] == 1)
                System.out.print(lab[f][c]+"0 ");
                else
                System.out.print(lab[f][c]+" ");
            }
            System.out.println();
        }
        //><
        for(int i=0; i<=26; i++)
        {
            System.out.println(fila.pop()+","+col.pop());
        }
        
        
        
        //System.out.println(col);
    }
}
