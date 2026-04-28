
package view;

import java.awt.*;
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
   
    
    public FrmJogoVelha(){
        super("Jogo da Velha");
        //-----Painel superior------
        JPanel pnlCima = new JPanel();
        pnlCima.add(btnNovoJogo);
        pnlCima.add(rbX);
        pnlCima.add(rbO);
        this.getContentPane().add(pnlCima, BorderLayout.NORTH);
        //------------
        
        //-----Painel Meio-------
        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setLayout(new GridLayout(3,3));
        for(int i=0;i<9; i++){
            botoes[i] = new JButton(Integer.toString(i+1));
            pnlBotoes.add(botoes[i]);
        }
        this.getContentPane().add(pnlBotoes, BorderLayout.CENTER);
        //------------
        
        
        //------Parte Baixo------
        
        this.getContentPane().add(txt, BorderLayout.SOUTH);
        
        //------------
        this.setBounds(100,100,450, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
