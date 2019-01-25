
public class Nodo2
{
    private int info;
    private Nodo2 ptr;
    
    public Nodo2(int info) {
        this.info=info;
    }
    
    public Nodo2 getPtr(){
        return ptr;
    }
    public void setPtr(Nodo2 ptr){
        this.ptr=ptr;
    }
    
    public int getInfo(){
        return info;
    }
    public void setInfo(int info){
        this.info=info;
    }
}