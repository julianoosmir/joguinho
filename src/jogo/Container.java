
package jogo;


import javax.swing.JFrame;

public class Container extends JFrame {
   
    public Container(){   
        
    Fase um = new Fase();   
    add(um);
    setTitle("Tiro no espaço");
    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    this.setResizable(false);
    setVisible(true);
    
    }
}
