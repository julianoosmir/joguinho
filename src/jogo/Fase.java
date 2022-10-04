
package jogo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
    public Image fundo;
    public Image control;
    public Jogador player1;
    public Timer tempo;
    public Inimigo inimigo;

    public TiroInimigo tiroInimigo;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        lerImagemFundo();

        player1 = new Jogador(400, 480, new TiroPlayer(0, 0));
        inimigo = new Inimigo(300, 10, new TiroInimigo(0, 0));
        addKeyListener(new TecladoAdapter());
        tempo = new Timer(2, this);
        tempo.start();

    }

    public void lerImagemFundo() {
        URL url = getClass().getClassLoader().getResource("res//black.png");
        ImageIcon imagem = new ImageIcon(url);
        URL url2 = getClass().getClassLoader().getResource("res//keyboard key graphics.png");
        ImageIcon imagem2 = new ImageIcon(url2);
        this.fundo = imagem.getImage();
        this.control = imagem2.getImage();
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D grafico = (Graphics2D) g;
        grafico.drawImage(fundo, 0, 0, this);
        grafico.drawImage(control, 0, 0, this);
        grafico.drawImage(player1.getImagem(), player1.getX(), player1.getY(), this);
        grafico.drawImage(inimigo.getImagem(), inimigo.getX(), inimigo.getY(), this);
        if (player1.getTiro() != null) {
            grafico.drawImage(player1.getTiro().getImagem(), player1.getTiro().getX(), player1.getTiro().getY(), this);
        }
        if (inimigo.getTiro() != null) {
            grafico.drawImage(inimigo.getTiro().getImagem(), inimigo.getTiro().getX(), inimigo.getTiro().getY(), this);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player1.atualizar();
        inimigo.atualizar();
        if (player1.getTiro() != null) {
            player1.getTiro().update();
        }
        if (inimigo.getTiro() != null) {
            inimigo.getTiro().update();
        }
        checarColisao();
        repaint();
        
    }

    private void checarColisao() {
        Rectangle player1Bounds = this.player1.getBounds();
        Rectangle formaInimigo = this.inimigo.getBounds();

        if (this.player1.getTiro().getBounds().intersects(formaInimigo)) {
            this.inimigo.setImagem(null);
           // this.emJogo = false;
        }
        if (this.inimigo.getTiro().getBounds().intersects(player1Bounds)) {
            this.player1.setImagem(null);
            // this.emJogo = false;
        }
    }


    public class TecladoAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player1.teclaPressionada(e);
            inimigo.teclaPressionada(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            player1.teclaSolta(e);
            inimigo.teclaSolta(e);
        }

    }

}
