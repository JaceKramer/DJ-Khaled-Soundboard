import javax.swing.*;

public class GUITester {


    public static void main(String[] args) {
        //Actual current working code
        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel displayPanel = new JPanel();
        displayPanel.add(new TeamPanel());

        testFrame.getContentPane().add(displayPanel);
        testFrame.pack();
        testFrame.setVisible(true);

        //Test code testing khaled and soundboard class
        JFrame coolFrame = new JFrame();
        coolFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel coolPanel = new JPanel();
        coolPanel.add(new Soundboard());

        coolFrame.getContentPane().add(coolPanel);
        coolFrame.pack();
        coolFrame.setVisible(true);

    }

}
