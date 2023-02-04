import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    Container container = this.getContentPane();
    JLabel text = new JLabel();
    JLabel map = new JLabel();
    public GUI(){

        super("Client ");//установка имени окна
        this.setBounds(840, 150, 480, 400);//место и размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//операция при закрытии
        container.setLayout(new FlowLayout( FlowLayout.LEFT, 10, 10));
        container.add(text);
        map.setText("<html>");

        container.add(map);

    }

}
