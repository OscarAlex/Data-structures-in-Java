import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
/**
 * Huffman
 */
public class Huffman
{
    int frec[]= new int[26];
    int cod[]= new int[26];
    LinkedList <NodoC> cola= new LinkedList();
    NodoC raiz;
    //><
    public void capturar(String arr)
    {
        arr= arr.toUpperCase();
        for(int i=0; i<arr.length(); i++)
        {
            frec[(int)arr.charAt(i)-65]= frec[(int)arr.charAt(i)-65]+=1;
        }
    }
    
    public void queue()
    {
        int max= Arrays.stream(frec).max().getAsInt();
        for(int i=1; i<=max; i++)
        {
            for(int j=0; j<frec.length; j++)
            {
                if(frec[j]==i)
                {
                    cola.add(new NodoC(i,(char)(j+65)));
                }
            }
        }
    }
    
    public void wep()
    {
        //NodoC raiz;
        cic:
        while(true)
        {
            NodoC tmp1= cola.poll();
            NodoC tmp2= cola.poll();
            
            raiz= new NodoC((tmp1.getFrec()+tmp2.getFrec()), (char)0);
            raiz.setPtrI(tmp1);
            raiz.setPtrD(tmp2);
            
            int i=0;
            while(true)
            {
                if(cola.isEmpty() == true)
                {
                    cola.add(raiz);
                    break cic;
                }
                if(raiz.getFrec() >= cola.getLast().getFrec())
                {
                    cola.add(raiz);
                    break;
                }
                if(raiz.getFrec() >= cola.get(i).getFrec())
                {
                    i++;
                }
                else
                {
                    cola.add(i,raiz);
                    break;
                }
            }
        }
    }
    
    public void codBin()
    {
        recPre(raiz);
    }
    private Stack <Integer> bin= new Stack();
    public void recPre(NodoC nodo)
    {
        
        if(nodo!=null)
        {
            if(nodo==raiz)
            recPre(nodo.getPtrI());
            bin.push(0);
            recPre(nodo.getPtrI());
            //if(nodo.getPtrI()==null && nodo.getPtrD()==null)
            //{
                bin.pop();
            //}
            recPre(nodo.getPtrD());
            bin.push(1);
            //if(nodo.getPtrI()==null && nodo.getPtrD()==null)
            //{
                bin.pop();
            //}
        }
    }
    
    static public void main(String arg[])
    {
        System.out.print('\u000c');
        Huffman tree= new Huffman();
        Scanner tc= new Scanner(System.in);
        String cad;
        
        cad= tc.nextLine();
        tree.capturar(cad);
        tree.queue();
        tree.wep();
        tree.codBin();
    }
    //TODOLOPUEDOENCRISTOQUEmefortalece
}
