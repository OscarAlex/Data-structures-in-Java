import java.util.Scanner;
import java.util.ArrayList;
/**
 * Ordenamiento por Cubetas ArrayList
 */
public class CubArray
{
    static public void main()
    {
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        String dato;
        
        dato= tc.nextLine();
        char lista[]= dato.toCharArray();
        
        ArrayList listord2[]= new ArrayList[10];
        for(int i=0;i<10;i++)
        {
            listord2[i]= new ArrayList();
        }
        for(int i=0;i<lista.length;i++)
        {
            if(lista[i]=='0')
            {
                listord2[0].add(0);
            }
            if(lista[i]=='1')
            {
                listord2[1].add(1);
            }
            if(lista[i]=='2')
            {
                listord2[2].add(2);
            }
            if(lista[i]=='3')
            {
                listord2[3].add(3);
            }
            if(lista[i]=='4')
            {
                listord2[4].add(4);
            }
            if(lista[i]=='5')
            {
                listord2[5].add(5);
            }
            if(lista[i]=='6')
            {
                listord2[6].add(6);
            }
            if(lista[i]=='7')
            {
                listord2[7].add(7);
            }
            if(lista[i]=='8')
            {
                listord2[8].add(8);
            }
            if(lista[i]=='9')
            {
                listord2[9].add(9);
            }
        }
        /*
        for(int i=0;i<listord2.length;i++)
        {
            for(int j=0;j<listord2[i].size();j++)
            {
                System.out.print(listord2[i].get(j)+", ");
            }
        }
        */
        
        int w=0;
        for(int i=0;i<listord2.length;i++)
        {
            for(int j=0;j<listord2[i].size();j++)
            {
                lista[w]= (char)(48+(int)listord2[i].get(j));
                w++;
            }
        }
        
        System.out.println(lista);
    }
}
