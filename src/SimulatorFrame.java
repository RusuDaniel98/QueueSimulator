import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulatorFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private int WIDTH = 600, HEIGHT = 600;

    public JTextField textFieldTimer;
    JTextField textFieldQueue1;
    JTextField textFieldQueue2;
    JTextField textFieldQueue3;
    JTextField fieldTotalTime;
    JTextField fieldServers;
    JTextField fieldProcessingTime;
    public JButton startButton;

    JTextArea textAreaInfo;

    public SimulatorFrame(){
        panel = new JPanel();
        this.add(panel);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.setVisible(true);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);       //allows the use of setBounds() method
        GridBagConstraints gc = new GridBagConstraints();

        JLabel labelTotalTime;
        JLabel labelServers;
        JLabel labelProcessingTime;

        gc.gridx = 0;
        gc.gridy = 0;
        labelTotalTime = new JLabel("Total Time");
        panel.add(labelTotalTime, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        fieldTotalTime = new JTextField(5);
        panel.add(fieldTotalTime, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        labelServers = new JLabel("Number of Servers");
        panel.add(labelServers, gc);

        gc.gridx = 3;
        gc.gridy = 0;
        fieldServers = new JTextField(5);
        panel.add(fieldServers, gc);

        gc.gridx = 4;
        gc.gridy = 0;
        labelProcessingTime = new JLabel("Max Processing Time");
        panel.add(labelProcessingTime, gc);

        gc.gridx = 5;
        gc.gridy = 0;
        fieldProcessingTime = new JTextField(5);
        panel.add(fieldProcessingTime, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 6;
        textFieldQueue1 = new JTextField(25);
        panel.add(textFieldQueue1, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth = 6;
        textFieldQueue2 = new JTextField(25);
        panel.add(textFieldQueue2, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth = 6;
        textFieldQueue3 = new JTextField(25);
        panel.add(textFieldQueue3, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.gridwidth = 3;
        textFieldTimer = new JTextField(5);
        panel.add(textFieldTimer, gc);

        //start button
        gc.gridx = 2;
        gc.gridy = 4;
        gc.gridwidth = 3;
        startButton = new JButton("Start");
        panel.add(startButton, gc);

        //text area
        gc.gridx = 0;
        gc.gridy = 5;
        gc.gridwidth = 6;
        textAreaInfo = new JTextArea(25, 20);
        panel.add(textAreaInfo, gc);



        this.setVisible(true);
    }

    public void displayData(Scheduler scheduler, int time) {
        //set the global timer
        textFieldTimer.setText("Time: " + time);

        //set the queues
        if (scheduler.getServers().size() == 3) {
            textFieldQueue1.setText("Server 1 ::: " + scheduler.getServers().get(0).tasksAsString);
            textFieldQueue2.setText("Server 2 ::: " + scheduler.getServers().get(1).tasksAsString);
            textFieldQueue3.setText("Server 3 ::: " + scheduler.getServers().get(2).tasksAsString);
        } else {
            if (scheduler.getServers().size() == 2) {
                textFieldQueue1.setText("Server 1 ::: " + scheduler.getServers().get(0).tasksAsString);
                textFieldQueue2.setText("Server 2 ::: " + scheduler.getServers().get(1).tasksAsString);
            } else {
                if (scheduler.getServers().size() == 1) {
                    textFieldQueue1.setText("Server 1 ::: " + scheduler.getServers().get(0).tasksAsString);
                }
            }
        }


    }

    public void actionPerformed(ActionEvent e){

    }


}
