
/**
 * NodoBST
 */
public class NodoBST
{
    private int info;
    private NodoBST ptrI;
    private NodoBST ptrD;
    public int getInfo()
    {
        return info;
    }
    public void setInfo(int info)
    {
        this.info= info;
    }
    public NodoBST getPtrI()
    {
        return ptrI;
    }
    public NodoBST getPtrD()
    {
        return ptrD;
    }
    public void setPtrI(NodoBST ptrI)
    {
        this.ptrI= ptrI;
    }
    public void setPtrD(NodoBST ptrD)
    {
        this.ptrD= ptrD;
    }
    
    public NodoBST()
    {
        info=0;
        ptrI= null;
        ptrD= null;
    }
    public NodoBST(int info)
    {
        this.info= info;
        ptrI= null;
        ptrD= null;
    }
}
