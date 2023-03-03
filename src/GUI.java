import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame {
    Container container = this.getContentPane();
    JLabel text = new JLabel();
    JLabel map = new JLabel();
    public GUI(){

        super("Client ");//установка имени окна
        this.setBounds(840, 150, 480, 400);//место и размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//операция при закрытии
        container.setLayout(new FlowLayout( FlowLayout.LEFT, 10, 10));
        TextField textField = new TextField();
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyText(e.getKeyCode()).equals("w"))
                {
                    Main.setMss("w");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        container.add(textField);

        container.add(text);
        map.setText("<html>");

        container.add(map);

    }

}
