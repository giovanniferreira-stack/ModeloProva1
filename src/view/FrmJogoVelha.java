package view;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import javax.swing.*;

/**
 *
 * @author m86390
 */
public class FrmJogoVelha extends JFrame {
    //objetos graficos usados
    private JButton btnNovoJogo = new JButton ("Novo Jogo");
    private JRadioButton rbX = new JRadioButton("Jogador X");
    private JRadioButton rbO = new JRadioButton("Jogador O", true);
    private JButton[] botoes = new JButton[9]; 
    private JTextArea txt = new JTextArea(5,10);
    private ButtonGroup grupo = new ButtonGroup();
    private model.ControleJogoVelha regras = new model.ControleJogoVelha();
    
    public FrmJogoVelha(){
        super("Jogo da Velha");
        //----Painel superior-----
        JPanel pnlCima = new JPanel();
        pnlCima.add(btnNovoJogo);
        btnNovoJogo.addActionListener(new Ouvinte());//vincular o botao ao listener
        
        
        pnlCima.add(rbX).setEnabled(false);
        pnlCima.add(rbO).setEnabled(false);
        grupo.add(rbX);
        grupo.add(rbO);
        this.getContentPane().add(pnlCima, BorderLayout.NORTH);
        //-----------------------
        
        //------Painel Meio------
        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setLayout(new GridLayout(3,3));
        for(int i=0;i<9; i++){
            botoes[i] = new JButton(Integer.toString(i+1));
            botoes[i].addActionListener(new Ouvinte());
            pnlBotoes.add(botoes[i]);
        }
        this.getContentPane().add(pnlBotoes, BorderLayout.CENTER);
        //-----------------------
        
        
        //------Parte Baixo------
        
        this.getContentPane().add(txt, BorderLayout.SOUTH);
        
        //-----------------------
        this.setBounds(100,100,450, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    //classe interna para eventos
    private class Ouvinte implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == btnNovoJogo){
                for(int i=0; i<9; i++){
            botoes[i].setEnabled(true);
            botoes[i].setText(Integer.toString(i + 1));
            }
            regras.iniciarPartida();
            txt.setText(regras.getStatusPartida());
        }else{
            Character letra;
            if(rbX.isSelected()){
                letra = 'X';
                rbO.setSelected(true);
            }
            else{
                letra = 'O';
            rbX.setSelected(true);
            }
            int pos = Integer.parseInt(e.getActionCommand());
             regras.adicionarMovimento(letra, pos-1);
             
             botoes[pos-1].setEnabled(false);
             botoes[pos-1].setText(letra.toString());
             
             txt.setText(regras.getStatusPartida());
            }
                    
                    }
    
    
}
}
