import java.util.Scanner;
import java.util.Stack;
/**
 * Postfix
 */
public class Postfix
{
    public static void main(String arg[])
    {
        Pars infix= new Pars();
        
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        String infijo;
        Stack <Character> items= new Stack();
        Stack <Character> posfijo= new Stack();
        Stack <Integer> opposf= new Stack();
        int size=0;
        
        do
        {
            infijo= tc.nextLine();
        }
        while(infix.correcto(infijo) == false);
        
        //infijo= tc.nextLine();
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
            else if(infijo.charAt(i) == '+' || infijo.charAt(i) == '-' || infijo.charAt(i) == '*' || infijo.charAt(i) == '/' || 
            infijo.charAt(i) == '|' || infijo.charAt(i) == '^')
            {
                //if(items.empty()==true)------
                //{------
                    items.push(infijo.charAt(i));
                //}-------
                //else------
                //{----------
                    if(items.peek()=='(')
                    {
                        items.push(infijo.charAt(i));
                        
                    }
                //}---------
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
        
        int vals[]= new int[26];
        boolean vals2[]= new boolean[26];
        for(int i=0; i<size; i++)
        {
            if(post[i]>= 65 && post[i]<=90)
            {
                if(vals2[post[i]-65]==false)
                {
                    vals[post[i]-65]= tc.nextInt();
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
                opposf.push(opposf.pop()+opposf.pop());
            }
            else if(post[i]=='-')
            {
                opposf.push((-1)*(opposf.pop()-opposf.pop()));
            }
            else if(post[i]=='*')
            {
                opposf.push(opposf.pop()*opposf.pop());
            }
            else if(post[i]=='/')
            {
                int aux=opposf.pop();
                opposf.push(opposf.pop()/aux);
            }
            else if(post[i]=='^')
            {
                opposf.push((int)Math.pow(opposf.pop(),2));
            }
            else if(post[i]=='|')
            {
                opposf.push((int)Math.sqrt(opposf.pop()));
            }
        }
        System.out.println(opposf);
        
        //^ eleva al cuadrado
        //| saca raíz cuadrada
        //((a+b)-(c*d))
        //((a+b)/(c*d))
        //((a+b)-((c^)*d))
        //((a+b)-(c*(d^)))
        //(((x+y)|)-(w*v))
        //(((a+a)-(c*d))+a)
        //(((a+b)|)-(c*(d^)))
        //(((a+b)|)-((c*d)^))
    }
}
