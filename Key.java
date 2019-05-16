import java.awt.event.*;
public class Key implements KeyListener {
   public void keyPressed (KeyEvent e) {
      int keyCode = e.getKeyCode();
      if (keyCode == KeyEvent.VK_A) {
         System.out.println("sjdklfsjlkfjsdklfjs");
      }
   }
   public void keyReleased (KeyEvent e) {
      int keyCode = e.getKeyCode();
      if (keyCode == KeyEvent.VK_A) {
         System.out.println("sjdklfsjlkfjsdklfjs");
      }
   }
   public void keyTyped (KeyEvent e) {
      int keyCode = e.getKeyCode();
      if (keyCode == KeyEvent.VK_A) {
         System.out.println("sjdklfsjlkfjsdklfjs");
      }
   }
}