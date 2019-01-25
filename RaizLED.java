import java.util.Random;
public class RaizLED
{
    public static void main (String [] args)
    {    
        //random para los numeros de la lista
        Random aleatorio =new Random();
        //creación de una lista
        LED mlista = new LED();
        //creación del arreglo
        LED [] array = new LED [10];
        //arreglo de números
        //int [] numeros = {1000,7,7000,2550,145,8832,60,8009,4785,9999,14};
        //limpiar pantalla
        System.out.println('\u000C');
        
        //asignar a cada posición del arreglo una nueva lista
        for(int i=0; i<array.length; i++)
        {
            array[i] = new LED();
        }
        
        //agregar los números del arreglo a la lista
        for (int i=0; i<=10;i++)
        {
            mlista.insertarPrincipio(new NodoD(aleatorio.nextInt(9999)+1));
        }
        
        //ciclo para recorrer cada posición del número
        for(int i=1; i<=4; i++)
        {
            System.out.println("\n\nciclo " + i);
            while(mlista.getRaiz()!=null)
            {
                //se elminnan los elementos de la lista
                NodoD t= mlista.eliminarPrincipio();
                
                //se agregan los elementos de la lista al Array
                array[t.getInfo()% (int)Math.pow(10,i)/(int)Math.pow(10,i-1)].insertarPrincipio(t);
            }
            
            //ciclo para recorrer el arreglo
            for(int j=array.length-1; j>=0; j--)
            {
                while(array[j].getRaiz()!=null)
                {
                    //se eliminan los elementos del array
                    NodoD t = array[j].eliminarPrincipio();
                    t.setPtrI(null);
                    //se agregan los elementos del array a la lista
                    mlista.insertarPrincipio(t);
                }
            }
            
            //imprimir la lista
            NodoD tmp=mlista.getRaiz();
            while(tmp!=null)
            {
                System.out.println(tmp.getInfo());
                tmp= tmp.getPtrD();
            }
        }
    }
}