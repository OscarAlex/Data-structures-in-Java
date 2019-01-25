import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
/**
 * Mostrar Conway
 */
public class Game extends JFrame implements ActionListener
{
    private JButton generacion;
    private JPanel panel;
    private int tf=60,tc=60;
    private int arr[][]=new int[tf][tc];
    private int arr2[][]=new int[tf][tc];
    private int xp=836,yp=836;
    public static void main(String args[])
    {
        Game ventana= new Game();
        ventana.setSize(860,920);
        ventana.setResizable(false);
        ventana.crearGUI();
        ventana.setVisible(true);
    }
    
    private void crearGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contenedor= getContentPane();
        contenedor.setLayout(new FlowLayout());
        
        panel= new JPanel();
        panel.setPreferredSize(new Dimension(xp,yp));
        panel.setBackground(Color.white);
        contenedor.add(panel);
        
        generacion= new JButton("Siguiente");
        contenedor.add(generacion);
        generacion.addActionListener(this);
        
        for(int v=1; v<=tf*tc*.2; v++)
        {
            int f,c;
            do
            {
                f=(int)(Math.random()*tf);
                c=(int)(Math.random()*tc);
            }
            while(arr[f][c] == 1);
            arr[f][c]= 1;
        }
    }
    

    public void actionPerformed(ActionEvent event)
    {
        Graphics papel= panel.getGraphics();
        if(event.getSource() == generacion)
        {
            for(int f=0; f<tf; f++)
            {
                for(int c=0; c<tc; c++)
                {
                    int vec=0;
                    if(f==0 && c==0)
                    {
                        if(arr[f][c+1]==1)
                        {
                            vec++;
                        }
                        if(arr[f+1][c]==1)
                        {
                            vec++;
                        }
                        if(arr[f+1][c+1]==1)
                        {
                            vec++;
                        }
                    }
                    else if(f==0 && c==tc)
                    {
                        if(arr[f][c-1]==1)
                        {
                            vec++;
                        }
                        if(arr[f+1][c]==1)
                        {
                            vec++;
                        }
                        if(arr[f+1][c-1]==1)
                        {
                            vec++;
                        }
                    }
                    else if(f==tf && c==0)
                    {
                        if(arr[f-1][c]==1)
                        {
                            vec++;
                        }
                        if(arr[f-1][c+1]==1)
                        {
                            vec++;
                        }
                        if(arr[f][c+1]==1)
                        {
                            vec++;
                        }
                    }
                    else if(f==tf && c==tc)
                    {
                        if(arr[f-1][c-1]==1)
                        {
                            vec++;
                        }
                        if(arr[f-1][c]==1)
                        {
                            vec++;
                        }
                        if(arr[f][c-1]==1)
                        {
                            vec++;
                        }
                    }
                    
                    if(f==0)
                    {
                        if(c!=0 && c!=tc-1)
                        {
                            if(arr[f][c-1]==1)
                            {
                                vec++;
                            }
                            if(arr[f][c+1]==1)
                            {
                                vec++;
                            }
                            if(arr[f+1][c-1]==1)
                            {
                                vec++;
                            }
                            if(arr[f+1][c]==1)
                            {
                                vec++;
                            }
                            if(arr[f+1][c+1]==1)
                            {
                                vec++;
                            }
                        }
                    }
                    else if(c==0)
                    {
                        if(f!=0 && f!=tc-1)
                        {
                            if(arr[f-1][c]==1)
                            {
                                vec++;
                            }
                            if(arr[f-1][c+1]==1)
                            {
                                vec++;
                            }
                            if(arr[f][c+1]==1)
                            {
                                vec++;
                            }
                            if(arr[f+1][c]==1)
                            {
                                vec++;
                            }
                            if(arr[f+1][c+1]==1)
                            {
                                vec++;
                            }
                        }
                    }
                    else if(c==tc-1)
                    {
                        if(f!=0 && f!=tc-1)
                        {
                            if(arr[f-1][c-1]==1)
                            {
                                vec++;
                            }
                            if(arr[f-1][c]==1)
                            {
                                vec++;
                            }
                            if(arr[f][c-1]==1)
                            {
                                vec++;
                            }
                            if(arr[f+1][c-1]==1)
                            {
                                vec++;
                            }
                            if(arr[f+1][c]==1)
                            {
                                vec++;
                            }
                        }
                    }
                    else if(f==tf-1)
                    {
                        if(c!=0 && c!=tc-1)
                        {
                            if(arr[f-1][c-1]==1)
                            {
                                vec++;
                            }
                            if(arr[f-1][c]==1)
                            {
                                vec++;
                            }
                            if(arr[f-1][c+1]==1)
                            {
                                vec++;
                            }
                            if(arr[f][c-1]==1)
                            {
                                vec++;
                            }
                            if(arr[f][c+1]==1)
                            {
                                vec++;
                            }
                        }
                    }
                    
                    if(f!=0 && c!=tc-1 && f!=tf-1 && c!=0)
                    {
                        if(arr[f-1][c-1]==1)
                        {
                            vec++;
                        }
                        if(arr[f-1][c]==1)
                        {
                            vec++;
                        }
                        if(arr[f-1][c+1]==1)
                        {
                            vec++;
                        }
                        if(arr[f][c-1]==1)
                        {
                            vec++;
                        }
                        if(arr[f][c+1]==1)
                        {
                            vec++;
                        }
                        if(arr[f+1][c-1]==1)
                        {
                            vec++;
                        }
                        if(arr[f+1][c]==1)
                        {
                            vec++;
                        }
                        if(arr[f+1][c+1]==1)
                        {
                            vec++;
                        }
                    }
                    
                    if(arr[f][c]==1)
                    {
                        if(vec==2 || vec==3)
                        {
                            arr2[f][c]=1;
                        }
                        else
                        {
                            arr2[f][c]=0;
                        }
                    }
                    else if(arr[f][c]==0)
                    {
                        if(vec==3)
                        {
                            arr2[f][c]=1;
                        }
                    }
                }
            }
            
            for(int f=0; f<tf; f++)
            {
                for(int c=0; c<tc; c++)
                {
                    arr[f][c]= arr2[f][c];
                }
            }
        }
        
        papel.setColor(Color.white);
        papel.fillRect(0,0,xp,yp);
        papel.setColor(Color.black);
        pintar(papel);
    }
    
    public void pintar(Graphics g) 
    {
        for(int f=0; f<tf; f++)
        {
            for(int c=0; c<tc; c++)
            {
                if(arr[f][c]==1)
                {
                    g.fillOval (14*f, 14*c, 10, 10);
                }
            }
        }
    }
    
}