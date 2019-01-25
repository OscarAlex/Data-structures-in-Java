/**
 * Write a description of class LeftistTrees here.
 */
public class NodoT
{
    private int info, sdx;
    private NodoT punteroD;
    private NodoT punteroI;
    
    public int getInfo(){
        return info;
    }
    public void setInfo(int info){
        this.info = info;
    }
    
    public int getSdx(){
        return sdx;
    }
    public void setSdx(int sdx){
        this.sdx = sdx;
    }
    
    public NodoT getPunteroD(){
        return punteroD;
    }
    public void setPunteroD(NodoT punteroD){
        this.punteroD = punteroD;
    }  
    
    public NodoT getPunteroI(){
        return punteroI;
    }
    public void setPunteroI(NodoT punteroI){
        this.punteroI = punteroI;
    }
    
    public NodoT(int info)
    {
        this.info = info;
        this.sdx = 1;
        punteroD = null;
        punteroI = null;
    }
}