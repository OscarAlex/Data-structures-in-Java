import java.util.Queue;
import java.util.LinkedList;
/**
 * NodoC
 */
public class NodoC
{
    private int frec;
    private char let;
    private NodoC ptrI;
    private NodoC ptrD;
    private boolean val;
    public void setVal(boolean n)
    {
        val=n;
    }
    
    public int getFrec()
    {
        return frec;
    }
    public void setFrec(int info)
    {
        frec= info;
    }
    public void setLet(char info)
    {
        let= info;
    }
    
    public NodoC getPtrI()
    {
        return ptrI;
    }
    public NodoC getPtrD()
    {
        return ptrD;
    }
    public void setPtrI(NodoC ptrI)
    {
        this.ptrI= ptrI;
    }
    public void setPtrD(NodoC ptrD)
    {
        this.ptrD= ptrD;
    }
    
    public NodoC(int info, char letra)
    {
        frec= info;
        let= letra;
        ptrI= null;
        ptrD= null;
    }
}
