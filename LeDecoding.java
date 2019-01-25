import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Hashtable;
/**
 * Led Decoding
 */
public class LeDecoding
{
    public static void main(String arg[])
    {
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        Scanner tc2= new Scanner(System.in);
        int lines;
        String mess;
        
        System.out.println("Líneas");
        lines= tc.nextInt();
        Queue <String> output[]= new LinkedList[lines];
        //><
        
        Hashtable <String,String> codes= new Hashtable<String, String>();
        codes.put("123457","A");
        codes.put("1234567","B");
        codes.put("456","C");
        codes.put("1580","D");
        codes.put("12456","E");
        codes.put("1249","F");
        codes.put("12569","G");
        codes.put("13457","H");
        codes.put("37","I");
        codes.put("3567","J");
        codes.put("13459","K");
        codes.put("156","L");
        codes.put("12357","M");
        codes.put("3579","N");
        codes.put("123567","O");
        codes.put("1458","P");
        codes.put("12347","Q");
        codes.put("123459","R");
        codes.put("12467","S");
        codes.put("278","T");
        codes.put("13567","U");
        codes.put("1379","V");
        codes.put("135790","W");
        codes.put("90","X");
        codes.put("1347","Y");
        codes.put("23456","Z");
        //Repite N veces
        for(int j=0; j<lines; j++)
        {
            mess= tc2.nextLine();
            mess= mess.toUpperCase();
            output[j]= new LinkedList();
            //Recorre las líneas de entrada
            for(int i=0; i<mess.length(); i++)
            {
                //Si es un caracter directo, lo guarda
                if(mess.charAt(i)>=65 && mess.charAt(i)<=90 || mess.charAt(i)==32)
                {
                    output[j].offer(Character.toString(mess.charAt(i)));
                }
                //Si es un número
                else if(mess.charAt(i)>=48 && mess.charAt(i)<=57)
                {
                    LinkedList <String> code= new LinkedList();
                    code.offer(Character.toString(mess.charAt(i)));
                    i++;
                    while(Integer.parseInt(code.getLast()) < Integer.parseInt(""+mess.charAt(i)))
                    {
                        code.offer(Character.toString(mess.charAt(i)));
                        i++;
                        if(i==mess.length())
                        {
                            break;
                        }
                    }
                    
                    if(i<mess.length())
                    {
                        if(Integer.parseInt(""+mess.charAt(i)) == 0)
                        {
                            code.offer(Character.toString(mess.charAt(i)));
                        }
                    }
                    
                    String cod2= code.poll();
                    while(code.isEmpty()==false)
                    {
                        cod2= cod2.concat(code.poll());
                    }
                    
                    String letter= codes.get(cod2);
                    if(letter!=null)
                    {
                        output[j].offer(letter);
                        if(i==mess.length()-1)
                        {
                            break;
                        }
                        else
                        {
                            i--;
                        }
                    }
                    else if(letter==null)
                    {
                        if(cod2.charAt(0) == '0')
                        {
                            output[j].offer(" ");
                            cod2= cod2.substring(1, cod2.length());
                            letter= codes.get(cod2);
                            output[j].offer(letter);
                            i--;
                        }
                        else
                        {
                            cod2= cod2.substring(0, cod2.length()-1);
                            letter= codes.get(cod2);
                            output[j].offer(letter);
                            output[j].offer(" ");
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<lines; i++)
        {
            System.out.print("Frase "+(i+1)+": ");
            while(output[i].isEmpty()==false)
            {
                System.out.print(output[i].poll());
            }
            System.out.println();
        }
        //3
        //HELL1235670WO1234591561580
        //PROGRAMMING037124670C123567123567156
        //AND MORE037124903735790278134573712467045612356735792781245612467278
    }
}
