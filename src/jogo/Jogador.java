
package jogo;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.net.URL;

public class Jogador extends Nave {


    public Jogador(Integer linha, Integer coluna, Tiro tiro) {
        super(linha, coluna, tiro);
    }

    public void lerFoguete(){
        URL url = getClass().getClassLoader().getResource("res//playerShip1_red.png");
        ImageIcon imagem = new ImageIcon(url);
        this.setImagem(imagem.getImage());
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
                setTiro(new TiroPlayer(x+45,y-30));
                getTiro().load();
            }
        }
        
    }
    
}
