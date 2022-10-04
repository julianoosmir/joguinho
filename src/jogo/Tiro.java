package jogo;

import java.awt.*;

abstract class Tiro {
    private int x;
    int y;
    protected Image imagem;
    private int altura;
    private int largura;
      
    public Tiro(int x,int y){
        load();
        this.x=x;
        this.y=y;
        setLargura(getImagem().getWidth(null));
        setAltura(getImagem().getHeight(null));
    }
    
    abstract void update();

    abstract void load();

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

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return this.largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getAltura(), getLargura());
    }
}
