import java.util.Scanner;
import java.util.Stack;
/**
 * Calculadora de proposiciones
 */
public class Propos
{
    public static void main(String arg[])
    {
        Pars infix= new Pars();
        
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        String infijo;
        Stack <Character> items= new Stack();
        Stack <Character> posfijo= new Stack();
        Stack <Boolean> opposf= new Stack();
        int size=0;
        
        do
        {
            infijo= tc.nextLine();
        }
        while(infix.correcto(infijo) == false);
        infijo= infijo.toUpperCase();
        
        //><
        for(int i=0; i<infijo.length(); i++)
        {
            if(infijo.charAt(i) == '(')
            {
                items.push(infijo.charAt(i));
            }
            else if(infijo.charAt(i) == ')')
            {
                while(items.empty() == false)
                {
                    if(items.peek() != '(')
                    {
                        posfijo.push(items.pop());
                        size++;
                    }
                    else
                    {
                        items.pop();
                        break;
                    }
                }
            }
            else if(infijo.charAt(i) == '+' || infijo.charAt(i) == '*' || infijo.charAt(i) == '&' || infijo.charAt(i) == '%' || 
            infijo.charAt(i) == '-') //|| infijo.charAt(i) == '^')
            {
                items.push(infijo.charAt(i));
                if(items.peek()=='(')
                {
                    items.push(infijo.charAt(i));
                }
            }
            else if(infijo.charAt(i) >= 65 && infijo.charAt(i) <= 90)
            {
                posfijo.push(infijo.charAt(i));
                size++;
            }
        }
        
        while(items.empty()==false)
        {
            posfijo.push(items.pop());
            size++;
        }
        
        char post[]= new char[size];
        for(int i=size-1; i>=0; i--)
        {
            post[i]= posfijo.pop();
        }
        
        boolean vals[]= new boolean[26];
        boolean vals2[]= new boolean[26];
        for(int i=0; i<size; i++)
        {
            if(post[i]>= 65 && post[i]<=90)
            {
                if(vals2[post[i]-65]==false)
                {
                    System.out.println((char)(post[i])+":");
                    vals[post[i]-65]= tc.nextBoolean();
                    vals2[post[i]-65]=true;
                }
            }
        }
        
        System.out.println(post);
        System.out.println();
        for(int i=0; i<26; i++)
        {
            if(vals2[i] == true)
            {
                System.out.println((char)(i+65)+"= "+vals[i]);
            }
        }
        System.out.println();
        
        for(int i=0; i<post.length; i++)
        {
            if(post[i]>= 65 && post[i]<=90)
            {
                opposf.push(vals[post[i]-65]);
            }
            else if(post[i]== '+')
            {
                opposf.push(opposf.pop()|opposf.pop());
            }
            else if(post[i]=='*')
            {
                opposf.push((opposf.pop()&opposf.pop()));
            }
            else if(post[i]=='-')
            {
                opposf.push(!opposf.pop());
            }
            else if(post[i]=='&')
            {
                boolean aux1=opposf.pop();
                boolean aux2=opposf.pop();
                if(aux1==false && aux2==true)
                {
                    opposf.push(false);
                }
                else
                {
                    opposf.push(true);
                }
            }
            else if(post[i]=='%')
            {
                if(opposf.pop()==opposf.pop())
                {
                    opposf.push(true);
                }
                else
                {
                    opposf.push(false);
                }
            }
        }
        System.out.println(opposf);
        
        //+ OR
        //* AND
        //- NOT
        //& -->
        //% <-->
        
        //((p-)-)
        //(p+q)
        //(p*q)
        //((p-)*q)
        //(p&q)
        //(p%q)
        //((p-)&(q+r))
        //((p+q)&((p*q)-))
        
        //((p+q)%(p+r))
        //(((p+r)-)%r)
        
        //((p+((p-)*(q+r)-))&(p+(r+q)-))
    }
}
