
public class LES2
{
    private Nodo2 raiz;
    private int tamaño;

    public LES2(){
        tamaño++;
    } 

    public Nodo2 getRaiz(){
        return raiz;
    }
    public void setRaiz(Nodo2 raiz){
        this.raiz=raiz;
    }

    public int getTamaño(){
        return tamaño;
    }
    public void setTamaño(int tamaño){
        this.tamaño=tamaño;
    }
    
    public LES2(Nodo2 nuevo){
        raiz=nuevo;
        tamaño++;
    }

    public void agregarPrincipio(Nodo2 nuevo){
        if(raiz !=null){
            nuevo.setPtr(raiz);
            raiz=nuevo;
        } else {
            raiz=nuevo;
        }
        tamaño++;
    }

    public void agregarFinal(Nodo2 nuevo){
        if(raiz==null){
            raiz=nuevo;
        }else{
            Nodo2 tmp=raiz;
            while(tmp.getPtr()!=null){
                tmp=tmp.getPtr();

            }
            tmp.setPtr(nuevo);
        }
        tamaño++;
    }

    public void agregarEnPos(Nodo2 nuevo, int p){
        if(p==0){
            agregarPrincipio(nuevo);
        } else if (p==tamaño){
            agregarFinal(nuevo);
        } else if (p>0&&p<tamaño-1){
            Nodo2 tmp = raiz;
            int cont = 0;
            while(cont<p-1){
                tmp=tmp.getPtr();
                cont++;
            }
            nuevo.setPtr(tmp.getPtr());
            tmp.setPtr(nuevo);
            tamaño++;
        }else{
            System.out.println("No se pudo");

        }

    }
    
    public Nodo2 eliminaPrincipio(){
        Nodo2 tmp = raiz;
        if(tamaño==0){
            raiz.setPtr(null);
        }else {
            raiz = raiz.getPtr();
            tmp.setPtr(null);

        }
        tamaño--;
        return tmp;
    }
}