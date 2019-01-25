
/**
 * Nodo
 */
public class Nodo
{
    private int info;
    private Nodo ptr;
    public int getInfo()
    {
        return info;
    }
    public void setInfo(int info)
    {
        this.info= info;
    }
    public Nodo getPtr()
    {
        return ptr;
    }
    public void setPtr(Nodo ptr)
    {
        this.ptr= ptr;
    }
    
    public Nodo(int info)
    {
        this.info= info;
        ptr= null;
    }
}
