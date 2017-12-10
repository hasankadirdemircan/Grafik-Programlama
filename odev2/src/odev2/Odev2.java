/*
 Random olarak belirlenecek olan pencereye;
 Her seferinde 20px içeriye doğru olacak şekilde
 Random renkte diz spiral çizgiler çizdiriniz.
 
 */

package odev2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        
        float[] dash1 = { 1f, 0f, 1f };
        
       int w = getWidth();
       int h = getHeight();
        
       Random r = new Random();
       int z=1;
       for(int i=1; i<w ; i++)
        {
           g2d.setPaint(new Color(r.nextInt())); 
           BasicStroke bs1 = new BasicStroke(4, BasicStroke.CAP_ROUND, 
                BasicStroke.JOIN_BEVEL);
     
            g2d.setStroke(bs1);
            g2d.drawLine(20*i, 20*i, w-(20*i), 20*i);
            g2d.drawLine(w-(20*i), 20*i, w-(20*i), h-(20*i));
            g2d.drawLine(w-(20*i), h-(20*i),20*(i+z) ,h-(20*i) );
            g2d.drawLine(20*(i+z), h-(20*i), 20*(i+z), 20*(i+z));

            if(w/2<(20*(i+2)) || h/2<20*(i+2))
            {
                break;
            }
        }   
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Odev2 extends JFrame {

    public Odev2() {

        initUI();
    }
    
    private void initUI() {

        add(new Surface());
        Random r1 = new Random();
        int x=r1.nextInt(2000);
        int y=r1.nextInt(2000);
        
        setTitle("Odev2");
        setSize(x,y);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Odev2 ex = new Odev2();
                ex.setVisible(true);
            }
        });
    }
}
