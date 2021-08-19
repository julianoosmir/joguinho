
package jogo;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class TiroInimigo {
    private int x;
    int y;
    private Image imagem;
    
    public TiroInimigo(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    
    
    public void update(){
        this.y +=10;
    }
    
    public void load(){
          URL url = getClass().getClassLoader().getResource("res//laserRed03.png");
        ImageIcon imagem = new ImageIcon(url);
        this.imagem = imagem.getImage();
    }
      
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    
    public int getY() {
        return y;
    }

    
    public void setY(int y) {
        this.y = y;
    }

   
    public Image getImagem() {
        return imagem;
    }

    
    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }
}
