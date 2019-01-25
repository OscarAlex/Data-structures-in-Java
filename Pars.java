import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Paréntesis
 */
public class Pars
{
    //Stack pos= new Stack();
    //ArrayList pos1= new ArrayList(2);
    //ArrayList pos2= new ArrayList(2);
    public boolean correcto(String pars)
    {
        //><
        Stack pos= new Stack();
        ArrayList pos1= new ArrayList(2);
        ArrayList pos2= new ArrayList(2);
        for(int i=0; i<pars.length(); i++)
        {
            if(pars.charAt(i) == '(')
            {
                pos.push(i);
            }
            else if(pars.charAt(i) == ')')
            {
                if(pos.empty() == false)
                {
                    pos1.add(pos.pop());
                    pos1.add(i);
                }
                else
                {
                    pos2.add(i);
                }
            }
        }
        
        int i=0;
        System.out.println("Con pareja");
        while(i < pos1.size())
        {
            System.out.println("["+pos1.get(i)+","+pos1.get(i+1)+"]");
            i+=2;
        }
        
        if(pos.empty()==true && pos2.isEmpty()==true)
        {
            return true;
        }
        else
        {
            System.out.println("\nSin pareja");
            if(pos.isEmpty()==false)
            {
                System.out.println(pos);
            }
            else
            {
                System.out.println(pos2);
            }
            return false;
        }
    }
    
    public static void main(String arg[])
    {
        Pars pars= new Pars();
        System.out.print('\u000c');
        
        Scanner tc2= new Scanner(System.in);
        String op;
        op= tc2.nextLine();
        
        System.out.print("\n"+pars.correcto(op));
        
        //(a+b)
        //(c+d))
        //((e+f)
        //((g+h)))+(i*j))
        //((k+l)+(m*n))
        //((o+p)+(q*r)-s)
    }
}
