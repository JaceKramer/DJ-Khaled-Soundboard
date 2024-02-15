import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Soundboard extends JPanel{

    public Soundboard() {

        ArrayList<Khaled> khaleds= new ArrayList<Khaled>();

        //Declare Khaleds
        khaleds.add(new Khaled("asparagus", '1'));
        khaleds.add(new Khaled("tennisball", '2'));
        khaleds.add(new Khaled("velvet", '3'));


        //Adds each khaled to the soundboard panel
        for (Khaled khaled : khaleds) {
            this.add(khaled.getGreyKhaledLabel());
        }

        //adds each button to the soundboard panel
        for (Khaled khaled : khaleds) {
            this.add(khaled.getButton());
        }


        //set dimensions and style of soundboard panel itself
        this.setPreferredSize(new Dimension(900, 600));
        this.setBackground(Color.LIGHT_GRAY);
    }
}
