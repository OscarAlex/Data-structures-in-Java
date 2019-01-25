import java.util.Scanner;
import java.util.Stack;
/**
 * Baskets
 */
public class Baskets
{
    static public void main(String arg[])
    {
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        int n, diam;
        Stack <Integer> baskets= new Stack();
        //><
        
        do
        {
            //System.out.println("n");
            baskets.clear();
            do
            {
                n= tc.nextInt();
            }
            while(n>=1000);
            for(int i=0; i<n; i++)
            {
                diam= tc.nextInt();
                if(baskets.empty() == true)
                {
                    baskets.push(diam);
                }
                else if(diam > baskets.peek())
                {
                    baskets.push(diam);
                }
            }
            System.out.println(baskets.size());
        }
        while(n != -1);
        //12 200 1300 1800 1000 100 2000 2500 2900 1100 3000 1200 2400
        //5 200 300 500 100 3000
        //4 1000 700 500 200        
    }
}
