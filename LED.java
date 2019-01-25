
/**
 * Lista Enlazada Doble
 */
public class LED
{
    private NodoD raiz;
    private NodoD fin;
    private NodoD temp;
    private int tam;
    public NodoD getRaiz()
    {
        return raiz;
    }
    public void setRaiz(NodoD raiz)
    {
        this.raiz= raiz;
    }
    public NodoD getFin()
    {
        return fin;
    }
    public void setFin(NodoD fin)
    {
        this.fin= fin;
    }
    public int getTam()
    {
        return tam;
    }
    
    public LED()
    {
        raiz= null;
        fin= null;
        tam= 0;
    }
    public LED(NodoD nvo)
    {
        if(raiz==null)
        {
            fin=raiz=nvo;
            tam++;
        }
    }
    public LED(LED x)
    {
        if(raiz == null)
        {
            raiz= x.getRaiz();
            fin= x.getFin();
            tam= x.getTam();
        }
    }
    
    public void insertarPrincipio(NodoD nvo)
    {
        if(raiz == null)
        {
            fin=raiz=nvo;
            tam++;
        }
        else
        {
            nvo.setPtrD(raiz);
            raiz.setPtrI(nvo);
            raiz= nvo;
            tam++;
        }
    }
    public void insertarFinal(NodoD nvo)
    {
        if(raiz == null)
        {
            raiz=fin=nvo;
            tam++;
        }
        else
        {
            nvo.setPtrI(fin);
            fin.setPtrD(nvo);
            fin= nvo;
            tam++;
        }
    }
    //><
    public void insertarPos(NodoD nvo, int y)
    {
        if(tam<=tam)
        {
            if(raiz==null)
            {
                temp=raiz=nvo=fin;
                tam++;
            }
            else if(y==0)
            {
                insertarPrincipio(nvo);
            }
            else if(y==tam)
            {
                insertarFinal(nvo);
            }
            else
            {
                temp=raiz;
                for(int i=1; i<y; i++)
                {
                    temp=temp.getPtrD();
                }
                nvo.setPtrI(temp);
                nvo.setPtrD(temp.getPtrD());
                temp.getPtrD().setPtrI(nvo);
                temp.setPtrD(nvo);
                tam++;
            }
        }
        else
        {
            System.out.println("No se puede no. "+y);
        }
    }
    public NodoD eliminarPrincipio()
    {
        //raiz.setPtrI(null);
        if(raiz!=null)
        {
            temp=raiz;
            raiz= temp.getPtrD();
            temp.setPtrD(null);
            raiz.setPtrI(null);
            tam--;
        }
        return temp;
    }
    public NodoD eliminarFinal()
    {
        if(raiz!=null)
        {
            temp=fin;
            fin= temp.getPtrI();
            temp.setPtrI(null);
            fin.setPtrD(null);
            tam--;
        }
        return temp;
    }
    public NodoD eliminarPos(int y)
    {
        if(y==0)
        {
            eliminarPrincipio();
        }
        else if(raiz!=null && y<tam)
        {
            temp=raiz;
            for(int i=0;i<y;i++)
            {
                temp= temp.getPtrD();
            }
            temp.getPtrI().setPtrD(temp.getPtrD());
            temp.getPtrD().setPtrI(temp.getPtrI());
            temp.setPtrI(null);
            temp.setPtrD(null);
        }
        return temp;
    }
    
    public void imprimirR()
    {
        if(raiz!=null)
        {
            temp=raiz;
            while(temp!=null)
            {
                System.out.println(temp.getInfo());
                temp= temp.getPtrD();
            }
        }
    }
    public void imprimirF()
    {
        if(raiz!=null)
        {
            temp=fin;
            while(temp!=null)
            {
                System.out.println(temp.getInfo());
                temp= temp.getPtrI();
            }
        }
    }
}
