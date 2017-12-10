/*
 Random yerlerde, farklı boyutlarda ve farkklı renklerde ekrana
    10 tane çizgi çizdiriniz.
 */
package odev1;

/**
 *
 * @author Hkadir
 */
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

       int w = getWidth();
       int h = getHeight();
        
        Random r = new Random();
        
        for(int i=0; i<10; i++)
        {
            int x1 = Math.abs(r.nextInt())%w;
            int y1 = Math.abs(r.nextInt())%h;
            int x2 = Math.abs(r.nextInt())%w;
            int y2 = Math.abs(r.nextInt())%h;
            int kalın = Math.abs(r.nextInt(9));
            
            BasicStroke bs1 = new BasicStroke(kalın);
            g2d.setPaint(new  Color(r.nextInt()));
            g2d.setStroke(bs1);
            g2d.drawLine(x1, y1, x2, y2);
        }
        g2d.dispose();
        
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Odev1 extends JFrame {

    public Odev1() {

        initUI();
    }
    
    private void initUI() {

        add(new Surface());

        setTitle("ODEV1");
        setSize(1000, 700);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Odev1 ex = new Odev1();
                ex.setVisible(true);
            }
        });
    }
}