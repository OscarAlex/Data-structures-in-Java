
/**
 * Nodo Doble
 */
public class NodoD
{
    private int info;
    private NodoD ptrI;
    private NodoD ptrD;
    public int getInfo()
    {
        return info;
    }
    public void setInfo(int info)
    {
        this.info= info;
    }
    public NodoD getPtrI()
    {
        return ptrI;
    }
    public NodoD getPtrD()
    {
        return ptrD;
    }
    public void setPtrI(NodoD ptrI)
    {
        this.ptrI= ptrI;
    }
    public void setPtrD(NodoD ptrD)
    {
        this.ptrD= ptrD;
    }
    
    public NodoD()
    {
        info=0;
        ptrI= null;
        ptrD= null;
    }
    public NodoD(int info)
    {
        this.info= info;
        ptrI= null;
        ptrD= null;
    }
}
