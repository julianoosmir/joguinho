
package jogo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;

public class Jogador implements ActionListener {

   
    private Image imagem;
    private int x;
    private int y;
    
    private int incrementoX;   
    private int IncrementoY;
    private Tiro tiro;
    
    
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
    public Jogador(Integer linha, Integer coluna){
        x = linha;
        y=coluna;
        lerFoguete();
        incrementoX=0;
        IncrementoY=0;
        
    }
    
    public void lerFoguete(){
        URL url = getClass().getClassLoader().getResource("res//playerShip1_red.png");
        ImageIcon imagem = new ImageIcon(url);
        this.setImagem(imagem.getImage());
    }

   
    public Image getImagem() {
        return imagem;
    }
    
    
    
    public void atualizar(){
        x += getIncrementoX();
        y += getIncrementoY();
    }
    
    public void morrer(int ix,int iy){
        if(ix == getX() && iy == getY()){
            setImagem(null);
        }
    }
    public void teclaPressionada( KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        setIncrementoY(codigo == KeyEvent.VK_UP ? IncrementoY -=3 : getIncrementoY());
        setIncrementoY(codigo == KeyEvent.VK_DOWN ? IncrementoY +=3 : getIncrementoY());
        setIncrementoX(codigo == KeyEvent.VK_LEFT ? incrementoX-=3 : getIncrementoX());
        setIncrementoX(codigo == KeyEvent.VK_RIGHT ? incrementoX+=3 : getIncrementoX());
        
    }
    public void teclaSolta(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        setIncrementoY(codigo == KeyEvent.VK_UP ? 0 : getIncrementoY());
        setIncrementoY(codigo == KeyEvent.VK_DOWN ? 0 : getIncrementoY());
        setIncrementoX(codigo == KeyEvent.VK_LEFT ? 0 : getIncrementoX());
        setIncrementoX(codigo == KeyEvent.VK_RIGHT ? 0 : getIncrementoX());
        
        if(codigo == KeyEvent.VK_ENTER){
            var t = getTiro();
            if(t==null || t.y <30){
                setTiro(new Tiro(x+45,y-30));
                getTiro().load();
            }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

 
    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

   
    public int getIncrementoX() {
        return incrementoX;
    }

    public void setIncrementoX(int incrementoX) {
        this.incrementoX = incrementoX;
    }

    public int getIncrementoY() {
        return IncrementoY;
    }

    public void setIncrementoY(int IncrementoY) {
        this.IncrementoY = IncrementoY;
    }

   
    public Tiro getTiro() {
        return tiro;
    }

    public void setTiro(Tiro tiro) {
        this.tiro = tiro;
    }
    
}
