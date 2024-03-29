package TICTACTOE;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel tittlepanel = new JPanel();
    JPanel buttonpanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean pemain1;


    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("INK Free",Font.BOLD,25));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        tittlepanel.setLayout(new BorderLayout());
        tittlepanel.setBounds(10,10,700,100);

        buttonpanel.setLayout(new GridLayout(3,3));
        buttonpanel.setBackground(new Color(150,150,150));

        for (int i=0; i<9; i++){
            buttons[i] = new JButton();
            buttonpanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        tittlepanel.add(textfield);
        frame.add(tittlepanel,BorderLayout.NORTH);
        frame.add(buttonpanel);

        giliran();
    }

    public void actionPerformed(ActionEvent e){
        for (int i=0; i<9; i++) {
            if (e.getSource()==buttons[i]) {
                if (pemain1){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        pemain1 = false;
                        textfield.setText("0 Turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        pemain1 = true;
                        textfield.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void giliran () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2)==0){
            pemain1 = true;
            textfield.setText("X Turn");
        }
        else {
            pemain1 = false;
            textfield.setText("0 Turn");
        }
    }

    public void check() {
        //p1
        if ( (buttons[0].getText()=="X") &&
             (buttons[1].getText()=="X") &&
             (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if ( (buttons[3].getText()=="X") &&
             (buttons[4].getText()=="X") &&
             (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if ( (buttons[6].getText()=="X") &&
             (buttons[7].getText()=="X") &&
             (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if ( (buttons[0].getText()=="X") &&
             (buttons[3].getText()=="X") &&
             (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if ( (buttons[1].getText()=="X") &&
             (buttons[4].getText()=="X") &&
             (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if ( (buttons[2].getText()=="X") &&
             (buttons[5].getText()=="X") &&
             (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if ( (buttons[0].getText()=="X") &&
             (buttons[4].getText()=="X") &&
             (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if ( (buttons[2].getText()=="X") &&
             (buttons[4].getText()=="X") &&
             (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }
        
        //p2
        if ( (buttons[0].getText()=="O") &&
             (buttons[1].getText()=="O") &&
             (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if ( (buttons[3].getText()=="O") &&
             (buttons[4].getText()=="O") &&
             (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if ( (buttons[6].getText()=="O") &&
             (buttons[7].getText()=="O") &&
             (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if ( (buttons[0].getText()=="O") &&
             (buttons[3].getText()=="O") &&
             (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if ( (buttons[1].getText()=="O") &&
             (buttons[4].getText()=="O") &&
             (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if ( (buttons[2].getText()=="O") &&
             (buttons[5].getText()=="O") &&
             (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if ( (buttons[0].getText()=="O") &&
             (buttons[4].getText()=="O") &&
             (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if ( (buttons[2].getText()=="O") &&
             (buttons[4].getText()=="O") &&
             (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
        
        }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }

        textfield.setText("X Wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }

        textfield.setText("O Wins");
    }
}
