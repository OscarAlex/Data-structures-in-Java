
/**
 * Lista Enlazada Simple
 */
public class LES
{
    private Nodo raiz;
    private Nodo fin;
    private Nodo temp;
    private int tam;
    public Nodo getRaiz()
    {
        return raiz;
    }
    public void setRaiz(Nodo raiz)
    {
        this.raiz= raiz;
    }
    public Nodo getFin()
    {
        return fin;
    }
    public void setFin(Nodo fin)
    {
        this.fin= fin;
    }
    public int getTam()
    {
        return tam;
    }
    
    public LES()
    {
        raiz= null;
        fin= null;
        tam= 0;
    }
    public LES(Nodo nvo)
    {
        if(raiz==null)
        {
            fin=raiz=nvo;
            tam++;
        }
    }
    public LES(LES x)
    {
        if(raiz == null)
        {
            raiz= x.getRaiz();
            fin= x.getFin();
            tam= x.getTam();
        }
    }
    //Enlaza primero los nuevos y luego mueve los necesarios
    //NUNCA mover la raíz
    public void insertarPrincipio(Nodo nvo)
    {
        if(raiz==null)
        {
            fin=raiz=nvo;
            tam++;
        }
        else
        {
            nvo.setPtr(raiz);
            raiz=nvo;
            tam++;
        }
    }
    public void insertarFinal(Nodo nvo)
    {
        if(raiz==null)
        {
            raiz=nvo=fin;
            tam++;
        }
        else
        {
            fin.setPtr(nvo);
            fin=nvo;
            tam++;
        }
    }
    public void insertarPos(Nodo nvo, int y)
    {
        if(y<=tam)
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
                    temp=temp.getPtr();
                }
                nvo.setPtr(temp.getPtr());
                temp.setPtr(nvo);
                tam++;
            }
        }
        else
        {
            System.out.println("No se puede no. "+y);
        }
    }
    public Nodo eliminarPrincipio()
    {
        if(raiz!=null)
        {
            temp=raiz;
            raiz=temp.getPtr();
            temp.setPtr(null);
            tam--;
        }
        return temp;
    }
    public Nodo eliminarFinal()
    {
        if(raiz!=null)
        {
            temp=raiz;
            while(temp.getPtr()!=fin)
            {
                temp=temp.getPtr();
            }
            fin=temp;
            temp=temp.getPtr();
            fin.setPtr(null);
            tam--;
        }
        return temp;
    }
    public Nodo eliminarPos(int y)
    {
        if(y==0)
        {
            eliminarPrincipio();
        }
        else if(raiz!=null && y<tam)
        {
            temp=raiz;
            Nodo ant=raiz;
            for(int i=1;i<y;i++)
            {
                ant=ant.getPtr();
            }
            temp=ant.getPtr();
            ant.setPtr(temp.getPtr());
            temp.setPtr(null);
            tam--;
        }
        else
        {
            System.out.println("No se puede borrar lo que no existe");
        }
        return temp;
    }
    
    public void imprimir()
    {
        if(raiz!=null)
        {
            Nodo tmp= raiz;
            while(tmp!=null)
            {
                System.out.println(tmp.getInfo());
                tmp=tmp.getPtr();
            }
        }
    }
}
