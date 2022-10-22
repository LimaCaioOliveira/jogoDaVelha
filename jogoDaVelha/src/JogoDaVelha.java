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

        //criando e customizando o painel de botao
        painel_botao.setLayout(new GridLayout(3,3));
        painel_botao.setBackground(new Color(150,150,150));

        //criando o for loop para os botoes de 1 a 9 e criando os botoes
        for(int i = 0; i<9; i++){
            botoes[i] = new JButton();
            painel_botao.add(botoes[i]); //adicionando os botoes ao painel
            botoes[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            botoes[i].setFocusable(false);
            botoes[i].addActionListener(this);

        }

        painel_titulo.add(caixaDeTexto);
        quadro.add(painel_titulo, BorderLayout.NORTH);
        quadro.add(painel_botao);
        primeiroTurno();


    }
    public void actionPerformed(ActionEvent e){

        for(int i=0; i<9; i++){
            if (e.getSource()==botoes[i]){
                if(turno_player1){
                    if(botoes[i].getText()==""){
                        botoes[i].setForeground(new Color(255,0,0));
                        botoes[i].setText("X");
                        turno_player1=false;
                        caixaDeTexto.setText("Turno do O");
                        checagem();
                    }
                }
                else{
                    if(botoes[i].getText()==""){
                        botoes[i].setForeground(new Color(0,0,255));
                        botoes[i].setText("O");
                        turno_player1=true;
                        caixaDeTexto.setText("Turno do X");
                        checagem();
                    }
                }
            }
        }


    }

    //metodo aleatorio para decidir quem vai primeiro X ││ O
    public void primeiroTurno(){
        //Para exibir primeiro o texto do jogo e depois o turno do jogador
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if(aleatorio.nextInt(2)==0){
            turno_player1=true;
            caixaDeTexto.setText("Turno do X");
        }else {
            turno_player1=false;
            caixaDeTexto.setText("Turno do O");
        }

    }
    //checando condições de vitória
    public void checagem(){
        //checando se X vence verificando as combinações possiveis de 3 em 3 de 0 a 8
        if(
                (botoes[0].getText()=="X") &&
                (botoes[1].getText()=="X") &&
                (botoes[2].getText()=="X") 
                ){
            xVence(0,1,2);
        }
        if(
                (botoes[3].getText()=="X") &&
                (botoes[4].getText()=="X") &&
                (botoes[5].getText()=="X") 
                ){
            xVence(3,4,5);
        }
        if(
                (botoes[6].getText()=="X") &&
                (botoes[7].getText()=="X") &&
                (botoes[8].getText()=="X") 
                ){
            xVence(6,7,8);
        }
        if(
                (botoes[0].getText()=="X") &&
                (botoes[3].getText()=="X") &&
                (botoes[6].getText()=="X") 
                ){
            xVence(0,3,6);
        }
        if(
                (botoes[1].getText()=="X") &&
                (botoes[4].getText()=="X") &&
                (botoes[7].getText()=="X") 
                ){
            xVence(1,4,7);
        }
        if(
                (botoes[2].getText()=="X") &&
                (botoes[5].getText()=="X") &&
                (botoes[8].getText()=="X") 
                ){
            xVence(2,5,8);
        }
        if(
                (botoes[0].getText()=="X") &&
                (botoes[4].getText()=="X") &&
                (botoes[8].getText()=="X") 
                ){
            xVence(0,4,8);
        }
        if(
                (botoes[2].getText()=="X") &&
                (botoes[4].getText()=="X") &&
                (botoes[6].getText()=="X") 
                ){
            xVence(2,4,6);
        }
    

        //checando se O vence
        if(
                (botoes[0].getText()=="O") &&
                (botoes[1].getText()=="O") &&
                (botoes[2].getText()=="O") 
                ){
            oVence(0,1,2);
        }
        if(
                (botoes[3].getText()=="O") &&
                (botoes[4].getText()=="O") &&
                (botoes[5].getText()=="O") 
                ){
            oVence(3,4,5);
        }
        if(
                (botoes[6].getText()=="O") &&
                (botoes[7].getText()=="O") &&
                (botoes[8].getText()=="O") 
                ){
            oVence(6,7,8);
        }
        if(
                (botoes[0].getText()=="O") &&
                (botoes[3].getText()=="O") &&
                (botoes[6].getText()=="O") 
                ){
            oVence(0,3,6);
        }
        if(
                (botoes[1].getText()=="O") &&
                (botoes[4].getText()=="O") &&
                (botoes[7].getText()=="O") 
                ){
            oVence(1,4,7);
        }
        if(
                (botoes[2].getText()=="O") &&
                (botoes[5].getText()=="O") &&
                (botoes[8].getText()=="O") 
                ){
            oVence(2,5,8);
        }
        if(
                (botoes[0].getText()=="O") &&
                (botoes[4].getText()=="O") &&
                (botoes[8].getText()=="O") 
                ){
            oVence(0,4,8);
        }
        if(
                (botoes[2].getText()=="O") &&
                (botoes[4].getText()=="O") &&
                (botoes[6].getText()=="O") 
                ){
            oVence(2,4,6);
        }
    }


    

    //checando vitória de X
    public void xVence(int a, int b, int c){
        botoes[a].setBackground(Color.GREEN);
        botoes[b].setBackground(Color.GREEN);
        botoes[c].setBackground(Color.GREEN);

        for (int i=0; i<9; i++){
            botoes[i].setEnabled(false);
        }
        caixaDeTexto.setText("Vitória do X");

    }
    //checando viótia de O
    public void oVence(int a, int b, int c){
        botoes[a].setBackground(Color.GREEN);
        botoes[b].setBackground(Color.GREEN);
        botoes[c].setBackground(Color.GREEN);

        for (int i=0; i<9; i++){
            botoes[i].setEnabled(false);
        }
        caixaDeTexto.setText("Vitória do O");

    }
}


