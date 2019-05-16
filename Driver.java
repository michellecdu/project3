import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Driver
  {
  public static void main(String[] args) throws Exception
   {
      JFrame frame = new JFrame("Dance Dance Revolution");
      frame.setSize(600, 600);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Scoreboard scoreboard = new Scoreboard();
      frame.setContentPane(scoreboard);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JButton b=new JButton("START");  
      frame.add(b, BorderLayout.NORTH);
      Display m = new Display();
      frame.add(m); 
      frame.setVisible(true);
      b.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
            Sound.play("Frozen - Do You Want to Build a Snowman.wav");
        }
      });    
      b.setFocusable(false);
      boolean first = true;
      while (true) {
         long startTime = System.currentTimeMillis();
         TimeUnit.MILLISECONDS.sleep(5000);
         if (m.getDifference() == -10000)
            scoreboard.penalize(m, scoreboard.getScoreLabel());
         else
            scoreboard.update(m, scoreboard.getScoreLabel(), first);
         first = false;
         m.setY(1000);
         m.changeArrow();
         m.timer.restart();
      }    
   } 
}