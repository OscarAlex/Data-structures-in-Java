import java.util.Scanner;
/**
 * Recursividad
 */
public class Recursiv
{
    public int fact(int n)
    {
        if (n==1)
        {
            return 1;
        }
        else
        {
            return n*fact(n-1);
        }
    }
    
    static public void main()
    {
        Recursiv obj= new Recursiv();
        Scanner tc= new Scanner(System.in);
        System.out.print('\u000c');
        int num,res;
        
        num= tc.nextInt();
        System.out.println(obj.fact(num));
    }
}
