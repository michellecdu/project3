import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;
 
public class Display extends JPanel implements ActionListener {
 
    int x, y;
    long startTime = System.currentTimeMillis();
    Timer timer;
    long difference;
    boolean pressed = false;
    Random r = new Random(); 
    int rand = r.nextInt(4);
    Display() {
        x = 0;
        y = 1000;
        timer = new Timer(2, this);
    }
    
    public void setY(int a) {
      y = a;
    }
    
    public long getDifference() {
      return difference;
    }
    
    public void changeArrow() {
      startTime = System.currentTimeMillis();
      pressed = false;
      rand = r.nextInt(4);
    }
     
    public void actionPerformed(ActionEvent e) {
        y--;
        repaint();
    }
     
    public void paintComponent(Graphics g) {
     g.setColor(Color.WHITE);
     g.fillRect(0, 0, 1000, 1000);
     ImageIcon snow = new ImageIcon("images/fallingsnow.gif");
     g.drawImage(snow.getImage(), 0, 0, null);
     ImageIcon background = new ImageIcon("images/olaf.gif");
     g.drawImage(background.getImage(), 50, 200, null);
     ImageIcon arrow = new ImageIcon("images/arrowkeys.jpg");
     g.drawImage(arrow.getImage(), 175, 0, null);
     
     
     ImageIcon[] movingArrows = {
         new ImageIcon("images/leftarrow.png"),
         new ImageIcon("images/downarrow.png"),
         new ImageIcon("images/uparrow.png"),
         new ImageIcon("images/rightarrow.png") 
     }; 
     // ADDED NEXT TWO LINES
     addKeyListener(new Key());
     setFocusable(true);
     ImageIcon currArrow = movingArrows[rand];
     if (rand == 0) {
      g.drawImage(currArrow.getImage(), 180, y, 50, 50, null); 
     }
     else if (rand == 1) {
      g.drawImage(currArrow.getImage(), 240, y, 50, 50, null); 
     }
     else if (rand == 2) {
      g.drawImage(currArrow.getImage(), 300, y, 50, 50, null); 
     }
     else {
      g.drawImage(currArrow.getImage(), 360, y, 50, 50, null); 
     }
     
     
 }
 // ADDED KEY CLASS
 private class Key extends KeyAdapter {
   public void keyPressed (KeyEvent e) {
      if (!pressed) {
         if (rand == 0 && e.getKeyCode() == KeyEvent.VK_LEFT)
            difference = difference(startTime, System.currentTimeMillis());
         else if (rand == 1 && e.getKeyCode() == KeyEvent.VK_DOWN)
            difference = difference(startTime, System.currentTimeMillis());
         else if (rand == 2 && e.getKeyCode() == KeyEvent.VK_UP)
            difference = difference(startTime, System.currentTimeMillis());
         else if (rand == 3 && e.getKeyCode() == KeyEvent.VK_RIGHT)
            difference = difference(startTime, System.currentTimeMillis());
         else
            difference = -10000;
         pressed = true;
      }
    

   }
 }

public long difference(long start, long end) {
   return end - start;
}

 
}

    
