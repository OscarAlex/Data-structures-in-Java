import java.util.LinkedList;
import java.util.Scanner;
/**
 * RaizLink
 */
public class RaizLink
{
    static public void main()
    {
        Scanner tc= new Scanner(System.in);
        System.out.print('\u000c');
        
        String dato;
        
        dato= tc.nextLine();
        char lista[]= dato.toCharArray();
        
        LinkedList listord2[]= new LinkedList[10];
        for(int i=0;i<10;i++)
        {
            listord2[i]= new LinkedList();
        }
        
        for(int i=0;i<lista.length;i++)
        {
            if(lista[i]==' ')
            {
                if(lista[i-1]=='0')
                {
                    listord2[0].add(0);
                }
                if(lista[i-1]=='1')
                {
                    listord2[1].add(1);
                }
                if(lista[i-1]=='2')
                {
                    listord2[2].add(2);
                }
                if(lista[i-1]=='3')
                {
                    listord2[3].add(3);
                }
                if(lista[i-1]=='4')
                {
                    listord2[4].add(4);
                }
                if(lista[i-1]=='5')
                {
                    listord2[5].add(5);
                }
                if(lista[i-1]=='6')
                {
                    listord2[6].add(6);
                }
                if(lista[i-1]=='7')
                {
                    listord2[7].add(7);
                }
                if(lista[i-1]=='8')
                {
                    listord2[8].add(8);
                }
                if(lista[i-1]=='9')
                {
                    listord2[9].add(9);
                }
            }
        }
        
        for(int i=0;i<listord2.length;i++)
        {
            for(int j=0;j<listord2[i].size();j++)
            {
                System.out.print(listord2[i].get(j)+", ");
            }
        }
    }
}
