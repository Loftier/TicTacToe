import javafx.beans.binding.When;
import javafx.scene.layout.Background;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.Color.*;

class TicTacToe {
    public static void main(String[] args){
        UIManager.getDefaults().put("Button.disabledText",new ColorUIResource(BLUE));
        new FrameEx();
    }
}

class FrameEx extends JFrame implements ActionListener {

    private JButton[][] box = new JButton[3][3];
    private int[][] values = new int[3][3];
    private JButton reset = new JButton("Reset");
    private int click=0;
    private Label text1 = new Label("PLAYER 1");
    private Label text2 = new Label("PLAYER 2");

    FrameEx(){

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                values[i][j]=2;

        setTitle("Tic Tac Toe");
        setLayout(new BorderLayout(0,0));
        setBackground(WHITE);

        //Labels
        JPanel player = new JPanel();
        player.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        player.setBackground(WHITE);

        text1.setBackground(RED);
        text1.setAlignment(Label.CENTER);
        text1.setFont(new Font("Arial", Font.BOLD,18));
        text1.setPreferredSize(new Dimension(100,40));
        player.add(text1);

        text2.setForeground(WHITE);
        text2.setAlignment(Label.CENTER);
        text2.setFont(new Font("Arial", Font.BOLD,18));
        text2.setPreferredSize(new Dimension(100,40));
        player.add(text2);

        //Buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel.setBackground(WHITE);

        //Reset
        JPanel resetpanel = new JPanel();
        resetpanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        resetpanel.setBackground(WHITE);

        reset.setPreferredSize(new Dimension(100,40));
        reset.setBackground(BLUE);
        reset.setFont(new Font("Arial", Font.BOLD, 20));
        reset.setForeground(WHITE);
        resetpanel.add(reset);

        //Adding Panels to the Frame
        add(player, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(resetpanel, BorderLayout.SOUTH);
        for(int i=0;i<3;i++)
            for(int j=0; j<3; j++){
                box[i][j]=new JButton();
                box[i][j].setPreferredSize(new Dimension(130,120));
                box[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 50));
                box[i][j].addActionListener(this);
                panel.add(box[i][j]);
        }
        reset.addActionListener(this);
        setSize(500,500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void check_win(){
        for(int i=0; i<3; i++) {
            if (values[i][0] == values[i][1] && values[i][1] == values[i][2] && values[i][2] == 0) {
                int result = JOptionPane.showConfirmDialog(this,"Player 2 Wins!","Winner", JOptionPane.OK_CANCEL_OPTION);
                if(result == JOptionPane.OK_OPTION) {
                    restart();
                }
                else if(result == JOptionPane.CANCEL_OPTION){
                    System.exit(0);
                }
            } else if (values[i][0] == values[i][1] && values[i][1] == values[i][2] && values[i][2] == 1) {
                int result = JOptionPane.showConfirmDialog(this,"Player 1 Wins!","Winner", JOptionPane.OK_CANCEL_OPTION);
                if(result == JOptionPane.OK_OPTION) {
                    restart();
                }
                else if(result == JOptionPane.CANCEL_OPTION){
                    System.exit(0);
                }
            }
        }
        for(int i=0; i<3; i++) {
            if (values[0][i] == values[1][i] && values[1][i] == values[2][i] && values[2][i] == 0) {
                int result = JOptionPane.showConfirmDialog(this,"Player 2 Wins!","Winner", JOptionPane.OK_CANCEL_OPTION);
                if(result == JOptionPane.OK_OPTION) {
                    restart();
                }
                else if(result == JOptionPane.CANCEL_OPTION){
                    System.exit(0);
                }
            } else if (values[0][i] == values[1][i] && values[1][i] == values[2][i] && values[2][i] == 1) {
                int result = JOptionPane.showConfirmDialog(this,"Player 1 Wins!","Winner", JOptionPane.OK_CANCEL_OPTION);
                if(result == JOptionPane.OK_OPTION) {
                    restart();
                }
                else if(result == JOptionPane.CANCEL_OPTION){
                    System.exit(0);
                }
            }
        }
        if(values[0][0]==values[1][1] && values[1][1]==values[2][2] && values[2][2]==0){
            int result = JOptionPane.showConfirmDialog(this,"Player 2 Wins!","Winner", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION) {
                restart();
            }
            else if(result == JOptionPane.CANCEL_OPTION){
                System.exit(0);
            }
        }
        else
        if(values[0][0]==values[1][1] && values[1][1]==values[2][2] && values[2][2]==1){
            int result = JOptionPane.showConfirmDialog(this,"Player 1 Wins!","Winner", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION) {
                restart();
            }
            else if(result == JOptionPane.CANCEL_OPTION){
                System.exit(0);
            }
        }
        else
        if(values[2][0]==values[1][1] && values[1][1]==values[0][2] && values[0][2]==0){
            int result = JOptionPane.showConfirmDialog(this,"Player 2 Wins!","Winner", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION) {
                restart();
            }
            else if(result == JOptionPane.CANCEL_OPTION){
                System.exit(0);
            }
        }
        else
        if(values[2][0]==values[1][1] && values[1][1]==values[0][2] && values[0][2]==1){
            int result = JOptionPane.showConfirmDialog(this,"Player 1 Wins!","Winner", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION) {
                restart();
            }
            else if(result == JOptionPane.CANCEL_OPTION){
                System.exit(0);
            }
        }
    }

    private void restart(){
        click=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                values[i][j]=2;
                box[i][j].setEnabled(true);
                box[i][j].setText("");
                text1.setBackground(RED);
                text1.setForeground(BLACK);
                text2.setBackground(WHITE);
                text2.setForeground(WHITE);
            }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        click++;
        if (e.getSource() instanceof JButton){
            if(e.getSource()==reset)
                restart();
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++){
                if (e.getSource()==box[i][j]){
                    if(click<10) {
                        box[i][j].setEnabled(false);
                        if (click % 2 == 0) {
                            box[i][j].setText("0");
                            values[i][j] = 0;
                            text1.setBackground(RED);
                            text1.setForeground(BLACK);
                            text2.setBackground(WHITE);
                            text2.setForeground(WHITE);
                        }
                        else {
                            box[i][j].setText("X");
                            values[i][j] = 1;
                            text2.setBackground(RED);
                            text2.setForeground(BLACK);
                            text1.setBackground(WHITE);
                            text1.setForeground(WHITE);
                        }
                        if(click>4)
                            check_win();
                    }
                    if(click==9){
                        int result = JOptionPane.showConfirmDialog(this,"Draw","Result", JOptionPane.OK_CANCEL_OPTION);
                        if(result == JOptionPane.OK_OPTION) {
                            restart();
                        }
                        else if(result == JOptionPane.CANCEL_OPTION){
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
}
