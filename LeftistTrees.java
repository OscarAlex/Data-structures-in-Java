import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
/**
 * LeftistTrees
 */
public class LeftistTrees
{
    private NodoT raiz;
    private Queue <NodoT> cola= new LinkedList(); 
    private Stack <NodoT> aux= new Stack();
    public NodoT getRaiz()
    {
        return raiz;
    }
    public void setRaiz(NodoT raiz)
    {
        this.raiz = raiz;
    }
        
    public Queue getCola()
    {
        return cola;
    }

    public LeftistTrees(NodoT nuevo)
    {
        if(raiz==null)
        {
            raiz= nuevo;
        }
    }
    
    public LeftistTrees(int arr[])
    {
        for(int i =0;i<arr.length;i++)
        {
            cola.add(new NodoT(arr[i]));
        }
    }
    
    public void unite()
    {
        while(true)
        {
            if(cola.size() == 1)
            {
                break;
            }
            int size= cola.size();
            NodoT temp1= cola.poll();
            NodoT temp2= cola.poll();
            fix(temp1,temp2);
        }
    }
    
    public void fix(NodoT temp1, NodoT temp2)
    {
        if(temp1.getInfo() > temp2.getInfo())
        {
            if(temp1.getPunteroD()==null)
            {
                temp1.setPunteroD(temp2);
                fixSdx(temp1);
                verificarSdx(temp1);//-----
                cola.add(temp1);
            }
            else
            {
                aux.push(temp1);
                temp1 = temp1.getPunteroD();
                fix(temp1,temp2);         
            }            
        }
        else
        {
            if(temp2.getPunteroD()==null)
            {
                temp2.setPunteroD(temp1);
                fixSdx(temp2);
                verificarSdx(temp2);//-----
                cola.add(temp2);
            }
            else
            {
                aux.push(temp2);
                temp2 = temp2.getPunteroD();
                fix(temp2,temp1);         
            }            
        }
        NodoT temp3,temp4;
        while(aux.empty()==false)
        {
            temp3= aux.pop();
            temp4= cola.poll();
            temp3.setPunteroD(temp4);
            verificarSdx(temp3);
            cola.add(temp3);
            //cola.add(aux.peek().setPunteroD(cola.peek()));
            //temp3= aux.pop().setPunteroD(cola.poll());
        }
    }
    
    public void fixSdx(NodoT temp)
    {
        if(temp!=null)
        {
            fixSdx(temp.getPunteroI());
            fixSdx(temp.getPunteroD());
            temp.setSdx(Math.min((temp.getPunteroI()==null)?0:temp.getPunteroI().getSdx(),
                                (temp.getPunteroD()==null)?0:temp.getPunteroD().getSdx())+1);
        }       
    }  
    
    public void verificarSdx(NodoT temp)
    {
        if(temp.getPunteroI()==null)
        {
            temp.setPunteroI(temp.getPunteroD());
            temp.setPunteroD(null);
        }
        else if(temp.getPunteroI().getSdx()<temp.getPunteroD().getSdx())
        {
            NodoT aux = temp.getPunteroI();
            temp.setPunteroI(temp.getPunteroD());
            temp.setPunteroD(aux);
        }
    }
    
    public void imprimir()
    {
        NodoT temporal= this.cola.poll();
        Queue<NodoT> cola = new LinkedList();
        cola.offer(temporal);
        while(!cola.isEmpty())
        {
            temporal=cola.poll();
            System.out.println(temporal.getInfo());
            if(temporal.getPunteroI()!=null)
            {
                cola.offer(temporal.getPunteroI());
            }
            if(temporal.getPunteroD()!=null)
            {
                cola.offer(temporal.getPunteroD());
            }
        }
    }
}