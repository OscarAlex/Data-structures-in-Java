import java.util.Queue;
import java.util.LinkedList;
/**
 * BST
 */
public class BST
{
    private NodoBST raiz;
    private NodoBST padre;//=raiz;
    public BST(NodoBST Nodo)
    {
        raiz= Nodo;
    }
    public BST(int[] arr)
    {
        //Se recorre el arreglo
        for(int i=0; i<arr.length; i++)
        {
            //Se crea un nodo nuevo por cada valor del arreglo
            NodoBST n =new NodoBST(arr[i]);
            //Se inserta en el árbol
            insertar(n);
        }
    }
    public BST(char[] arr)
    {
        //Se recorre el arreglo
        for(int i=0; i<arr.length; i++)
        {
            //Se crea un nodo nuevo por cada valor del arreglo
            NodoBST n =new NodoBST(arr[i]);
            //Se inserta en el árbol
            insertar(n);
        }
    }
    
    public NodoBST getRaiz()
    {
        return raiz;
    }
    public void setRaiz(NodoBST raiz)
    {
        this.raiz= raiz;
    }
    //Método para insertar
    //><
    public void insertar(NodoBST Nvo)
    {
        if(raiz==null)
        {
            raiz= Nvo;
        }
        else
        {
            NodoBST tmp= raiz;
            while(true)
            {
                //Se comparan los valores del nodo temporal y el nuevo
                if(Nvo.getInfo()>tmp.getInfo())
                {
                    //Mientras el puntero derecho esté vacío, se cambia la posición del temporal
                    if(tmp.getPtrD()!=null)
                    {
                        tmp= tmp.getPtrD();
                    }
                    //Cuando esté vacío, se unen el temporal y el nuevo y se sale del ciclo
                    else
                    {
                        tmp.setPtrD(Nvo);
                        break;
                    }
                }
                else
                {
                    if(tmp.getPtrI()!=null)
                    {
                        tmp= tmp.getPtrI();
                    }
                    else
                    {
                        tmp.setPtrI(Nvo);
                        break;
                    }
                }
            }
        }
    }
    //Recorridos
    public void recPre(NodoBST nodo)
    {
        if(nodo!=null)
        {
            System.out.println(nodo.getInfo());
            recPre(nodo.getPtrI());
            recPre(nodo.getPtrD());
        }
    }
    public void recNor(NodoBST nodo)
    {
        if(nodo!=null)
        {
            recNor(nodo.getPtrI());
            System.out.println(nodo.getInfo());
            recNor(nodo.getPtrD());
        }
    }
    public void recPos(NodoBST nodo)
    {
        if(nodo!=null)
        {
            recPos(nodo.getPtrI());
            recPos(nodo.getPtrD());
            System.out.println(nodo.getInfo());
        }
    }
    public void recNivel(NodoBST nodo)
    {
        if(nodo!=null)
        {
            Queue <NodoBST> vals= new LinkedList();
            //NodoBST tmp= nodo;
            vals.offer(nodo);
            while(vals.isEmpty()==false)
            {
                nodo= vals.poll();
                System.out.println(nodo.getInfo());
                if(nodo.getPtrI()!=null)
                {
                    vals.offer(nodo.getPtrI());
                }
                if(nodo.getPtrD()!=null)
                {
                    vals.offer(nodo.getPtrD());
                }
                //vals.poll();
            }
            
        }
    }
    
    public int grado(NodoBST nodo)
    {
        int cont=0;
        if(nodo.getPtrI()!=null)
        {
            cont++;
        }
        if(nodo.getPtrD()!=null)
        {
            cont++;
        }
        return cont;
    }
    //Eliminar
    private void el0(NodoBST tmp)
    {
        if(padre.getPtrD()!=null)
        {
            padre.setPtrD(null);
        }
        else
        {
            padre.setPtrI(null);
        }
    }
    private void el1(NodoBST tmp)
    {
        if(padre.getPtrD()==tmp)
        {
            if(tmp.getPtrD()!=null)
            {
                padre.setPtrD(tmp.getPtrD());
                tmp.setPtrD(null);
            }
            else
            {
                padre.setPtrD(tmp.getPtrI());
                tmp.setPtrI(null);
            }
        }
        else
        {
            if(tmp.getPtrI()!=null)
            {
                padre.setPtrI(tmp.getPtrI());
                tmp.setPtrI(null);
            }
            else
            {
                padre.setPtrI(tmp.getPtrD());
                tmp.setPtrD(null);
            }
        }
    }
    private void el2(NodoBST tmp)
    {
        NodoBST raiz2= tmp;
        //Eliminar camino izquierda
        tmp=raiz2.getPtrI();
        while(tmp.getPtrD()!=null)
        {
            padre=tmp;
            tmp=tmp.getPtrD();
        }
        raiz2.setInfo(tmp.getInfo());
        if(grado(tmp)==0)
        {
            el0(tmp);
        }
        else
        {
            el1(tmp);
        }
    }
    public void eliminar(int val)
    {
        NodoBST tmp= buscar(val);
        if(grado(tmp)==0)
        {
            el0(tmp);
        }
        else if(grado(tmp)==1)
        {
            el1(tmp);
        }
        else
        {
            el2(tmp);
        }
    }
    //><
    public NodoBST buscar(int val)
    {
        NodoBST tmp= raiz;
        padre=raiz;
        while(tmp.getInfo()!=val)
        {
            //Si el valor es mayor o menor a los de los nodos, se hace el recorrido hasta encontrarlo
            padre=tmp;
            if(val>tmp.getInfo())
            {
                tmp= tmp.getPtrD();
            }
            else
            {
                tmp= tmp.getPtrI();
            }
            //Si el valor no está en el árbol, devuelve null
            if(tmp==null)
            {
                return null;
            }
        }
        return tmp;
    }
}
