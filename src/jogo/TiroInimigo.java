
package jogo;

import java.net.URL;

import javax.swing.ImageIcon;

public class TiroInimigo extends Tiro {
        

    public TiroInimigo(int x, int y) {
        super(x, y);
        //TODO Auto-generated constructor stub
    }

    public void update(){
        this.y +=10;
    }
    
    public void load(){
        URL url = getClass().getClassLoader().getResource("res//laserRed03.png");
        ImageIcon imagem = new ImageIcon(url);
        this.imagem = imagem.getImage();
    }
      
    
}
