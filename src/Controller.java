import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Controller  {

    View view;
    Model model;


    public Controller() {
        model = new Model();
        view = new View();
        AddButtonActionListener addButtonActionListener = new AddButtonActionListener();
        view.setAddButtonActionListener(addButtonActionListener);

    }
    class AddButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String input =  view.getInputText();
            view.setOutput(model.sendData(input));
        }
    }


}









