
/**
 * Ordenamiento por Raíz (LES)
 */
import java.util.Random;
public class RaizLES
{
    public static void main (String [] args)
    {
        Random aleatorio=new Random();
        //creación de una lista
        LES2 mlista = new LES2();
        //creación del arreglo
        LES2 [] array = new LES2 [10];
        //arreglo de números
        //int [] numeros = {1000,4567,7000,2550,1435,8832,6001,8009,4785};
        //limpiar pantalla
        System.out.println('\u000C');

        //asignar a cada posición del arreglo una nueva lista
        for(int i=0; i<array.length; i++) 
        {
            array[i] = new LES2();
        }

        //agregar los números del arreglo a la lista
        for (int i=0; i<=10; i++){
            mlista.agregarPrincipio(new Nodo2(aleatorio.nextInt(9999)+1));
        }

        //ciclo para recorrer cada posción del número
        for(int i=1; i<=4; i++){
            System.out.println("\n\nciclo " + i);
            while(mlista.getRaiz()!=null)
            {
                //se elminnan los elementos de la lista
                Nodo2 t = mlista.eliminaPrincipio();
                //se agregan los elementos de la lista al Array
                array[t.getInfo()% (int)Math.pow(10,i)/(int)Math.pow(10,i-1)].agregarPrincipio(t);
            }

            //ciclo para recorrer el arreglo
            for(int j=array.length-1; j>=0; j--)
            {
                while(array[j].getRaiz()!=null)
                {
                    //se eliminan los elementos del array
                    Nodo2 t = array[j].eliminaPrincipio();
                    //se agregan los elementos del array a la lista
                    mlista.agregarPrincipio(t);
                }
            }

            //imprimir la lista
            Nodo2 tmp=mlista.getRaiz();
            while(tmp!=null)
            {
                System.out.println(tmp.getInfo());
                tmp = tmp.getPtr();
            }
        }
    }
}