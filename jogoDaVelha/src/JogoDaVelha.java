//imports para o sistema
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//implementando o action listener interface
public class JogoDaVelha implements ActionListener{

    //declarando usabilidades
    Random aleatorio = new Random();
    JFrame quadro = new JFrame();
    JPanel painel_titulo = new JPanel();
    JPanel painel_botao = new JPanel();
    JLabel caixaDeTexto = new JLabel();
    //no jogo da velha só precisamos de 9 botoes
    JButton[] botoes = new JButton[9];
    //boolean para o turno dos jogadores
    boolean turno_player1;

    JogoDaVelha(){
        //criando e customizando o quadro

        quadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quadro.setSize(800,800);
        quadro.getContentPane().setBackground(new Color(50, 50, 50));
        quadro.setLayout(new BorderLayout());
        quadro.setVisible(true);

        //criando e customizando o texto
        caixaDeTexto.setBackground(new Color(25,25,25));
        caixaDeTexto.setForeground(new Color(25, 255, 0));
        caixaDeTexto.setFont(new Font("Ink Free",Font.BOLD,75));
        caixaDeTexto.setHorizontalAlignment(JLabel.CENTER);
        caixaDeTexto.setText("O Jogo da Velha");
        caixaDeTexto.setOpaque(true);

        //criando e customizando o título
        painel_titulo.setLayout(new BorderLayout());
        painel_titulo.setBounds(0,0,800,100);

        //criando e customizando o botao
        painel_botao.setLayout(new GridLayout(3,3));
        painel_botao.setBackground(new Color(150,150,150));

        painel_titulo.add(caixaDeTexto);
        quadro.add(painel_titulo, BorderLayout.NORTH);
        quadro.add(painel_botao);


    }
    public void actionPerformed(ActionEvent e){


    }

    //metodo aleatorio para decidir quem vai primeiro X ││ O
    public void primeiroTurno(){

    }
    //checando condições de vitória
    public void checagem(){

    }

    //checando vitória de X
    public void xVence(int a, int b, int c){

    }
    //checando viótia de O
    public void oVence(int a, int b, int c){

    }

}
