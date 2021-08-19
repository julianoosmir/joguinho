
package jogo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;

public class Inimigo implements ActionListener {

   
    private Image imagem;
    private int x;
    private int y;
    
    private int incrementoX;   
    private int IncrementoY;
    private TiroInimigo tiro;
    
    
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
    public Inimigo(Integer linha, Integer coluna){
        x = linha;
        y=coluna;
        lerFoguete();
        incrementoX=0;
        IncrementoY=0;
        
    }
    
    public void lerFoguete(){
        URL url = getClass().getClassLoader().getResource("res//enemyBlue2.png");
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
    
    public void teclaPressionada( KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        setIncrementoY(codigo == KeyEvent.VK_W ? IncrementoY -=3 : getIncrementoY());
        setIncrementoY(codigo == KeyEvent.VK_S ? IncrementoY +=3 : getIncrementoY());
        setIncrementoX(codigo == KeyEvent.VK_A ? incrementoX-=3 : getIncrementoX());
        setIncrementoX(codigo == KeyEvent.VK_D ? incrementoX+=3 : getIncrementoX());
        
    }
    public void teclaSolta(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        setIncrementoY(codigo == KeyEvent.VK_W ? 0 : getIncrementoY());
        setIncrementoY(codigo == KeyEvent.VK_S ? 0 : getIncrementoY());
        setIncrementoX(codigo == KeyEvent.VK_A ? 0 : getIncrementoX());
        setIncrementoX(codigo == KeyEvent.VK_D ? 0 : getIncrementoX());
        
        if(codigo == KeyEvent.VK_M){
            var t = getTiro();
            if(t==null || t.y >10){
                setTiro(new TiroInimigo(x+45,y+30));
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

    /**
     * @return the tiro
     */
    public TiroInimigo getTiro() {
        return tiro;
    }

    /**
     * @param tiro the tiro to set
     */
    public void setTiro(TiroInimigo tiro) {
        this.tiro = tiro;
    }

   
    
    
}
