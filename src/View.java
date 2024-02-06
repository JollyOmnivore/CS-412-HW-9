import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    JFrame jFrame;
    JPanel body;
    JPanel top;

    JPanel bottom;

    JTextField Top;
    JTextField Bottom;
    DefaultListModel defaultListModel;
    JButton add;
    JList<String> jList;


    View() {
        jFrame = new JFrame();

        body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));

        top = new JPanel();
        jFrame.add(BorderLayout.NORTH, top);
        jFrame.add(BorderLayout.CENTER, body);
        bottom = new JPanel();
        jFrame.add(BorderLayout.SOUTH, bottom);

        Top = new JTextField(20);
        Bottom = new JTextField(20);

        defaultListModel = new DefaultListModel<String>();
        jList = new JList<>(defaultListModel);

        add = new JButton("Add");


        bottom.add(BorderLayout.CENTER, Bottom);
        top.add(BorderLayout.WEST, Top);
        top.add(BorderLayout.EAST, add);
        body.add(BorderLayout.CENTER, jList);

        jFrame.setSize(400, 400);
        jFrame.setVisible(true);


    }


    public void setListData(String[] data) {
        jList.setListData(data);
    }


    public String getInputText() {
        return Top.getText();
    }
    public void setOutput(String outputstr){
        Bottom.setText(outputstr);
    }

    public void setAddButtonActionListener(ActionListener AL) {
        add.addActionListener(AL);
    }
}


