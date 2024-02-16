import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Soundboard extends JPanel{

    public Soundboard() {

        ArrayList<Khaled> khaleds= new ArrayList<Khaled>();

        //Declare Khaleds
        khaleds.add(new Khaled("asparagus"));
        khaleds.add(new Khaled("tennisball"));
        khaleds.add(new Khaled("velvet"));
        khaleds.add(new Khaled("budget"));
        khaleds.add(new Khaled("cappuccino"));
        khaleds.add(new Khaled("chandelier"));
        khaleds.add(new Khaled("gatorade"));
        khaleds.add(new Khaled("goddid"));
        khaleds.add(new Khaled("golf"));
        khaleds.add(new Khaled("letsgolf"));
        khaleds.add(new Khaled("opportunity"));


        //Adds each khaled to the soundboard panel
        for (Khaled khaled : khaleds) {
            this.add(khaled.getGreyKhaledLabel());
        }

        //adds each button to the soundboard panel
        for (Khaled khaled : khaleds) {
            this.add(khaled.getButton());
        }


        //set dimensions and style of soundboard panel itself
        this.setPreferredSize(new Dimension(1500, 2400));
        this.setBackground(Color.LIGHT_GRAY);
    }
}
