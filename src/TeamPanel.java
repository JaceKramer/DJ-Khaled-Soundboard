import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;

public class TeamPanel extends JPanel {

    private final int TEAM_SIZE = 3;
    private JLabel[] khaledLabels;
    private JLabel[] greyKhaledLabels;
    private ImageIcon[] khaledIcons;
    private ImageIcon[] greyKhaledIcons;

    JButton redButton;
    JButton yellowButton;
    JButton greenButton;

    public TeamPanel() {

        // .WAV FILE STRINGS
        String asparagusAudio = "asparagus.wav";
        String velvetAudio = "velvet.wav";
        String tennisAudio = "tennisball.wav";


        // KHALED ICONS AND LABELS
        khaledLabels = new JLabel[TEAM_SIZE];
        greyKhaledLabels = new JLabel[TEAM_SIZE];
        khaledIcons = new ImageIcon[TEAM_SIZE];
        greyKhaledIcons = new ImageIcon[TEAM_SIZE];


        // KHALED COLOR IMAGES
        ImageIcon af = new ImageIcon("asparagus.png");
        Image imagea = af.getImage();
        Image newa = imagea.getScaledInstance(290, 290, Image.SCALE_SMOOTH);
        khaledIcons[0] = new ImageIcon(newa);
        khaledLabels[0] = new JLabel(khaledIcons[0]);

        ImageIcon vf = new ImageIcon("velvet.png");
        Image imagev = vf.getImage();
        Image newv = imagev.getScaledInstance(290, 290, Image.SCALE_SMOOTH);
        khaledIcons[1] = new ImageIcon(newv);
        khaledLabels[1] = new JLabel(khaledIcons[1]);
        ImageIcon tf = new ImageIcon("tennisball.png");
        Image imaget = tf.getImage();
        Image newt = imaget.getScaledInstance(290, 290, Image.SCALE_SMOOTH);
        khaledIcons[2] = new ImageIcon(newt);
        khaledLabels[2] = new JLabel(khaledIcons[2]);

        // KHALED GREY IMAGES
        ImageIcon agf = new ImageIcon("asparagusgrey.png");
        Image imageag = agf.getImage();
        Image newag = imageag.getScaledInstance(290, 290, Image.SCALE_SMOOTH);
        greyKhaledIcons[0] = new ImageIcon(newag);
        greyKhaledLabels[0] = new JLabel(greyKhaledIcons[0]);
        ImageIcon vgf = new ImageIcon("velvetgrey.png");
        Image imagevg = vgf.getImage();
        Image newvg = imagevg.getScaledInstance(290, 290, Image.SCALE_SMOOTH);
        greyKhaledIcons[1] = new ImageIcon(newvg);
        greyKhaledLabels[1] = new JLabel(greyKhaledIcons[1]);
        ImageIcon tgf = new ImageIcon("tennisballgrey.png");
        Image imagetg = tgf.getImage();
        Image newtg = imagetg.getScaledInstance(290, 290, Image.SCALE_SMOOTH);
        greyKhaledIcons[2] = new ImageIcon(newtg);
        greyKhaledLabels[2] = new JLabel(greyKhaledIcons[2]);

        // DISPLAY GREY IMAGES
        for (JLabel member : greyKhaledLabels) {
            this.add(member);
        }

        // RED VELVET CAKE BUTTON
        redButton = new JButton("Red On");
        redButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent r) {
                if (r.getSource() == redButton)
                    redButton.setText("Red On");
                int i = 0;
                for (JLabel member : greyKhaledLabels) {
                    member.setIcon(greyKhaledIcons[i]);
                    i++;
                }
                greyKhaledLabels[1].setIcon(khaledIcons[1]);
                try
                {
                    File velvetPath = new File(velvetAudio);

                    if(velvetPath.exists())
                    {
                        AudioInputStream velvetInput = AudioSystem.getAudioInputStream(velvetPath);
                        Clip velvetClip = AudioSystem.getClip();
                        velvetClip.open(velvetInput);
                        velvetClip.start();
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        });

        // TENNIS BALL BUTTON
        yellowButton = new JButton("Yellow On");
        yellowButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent t) {
                if (t.getSource() == yellowButton)
                    yellowButton.setText("Yellow On");
                int i = 0;
                for (JLabel member : greyKhaledLabels) {
                    member.setIcon(greyKhaledIcons[i]);
                    i++;
                }
                greyKhaledLabels[2].setIcon(khaledIcons[2]);
                try
                {
                    File tennisPath = new File(tennisAudio);

                    if(tennisPath.exists())
                    {
                        AudioInputStream tennisInput = AudioSystem.getAudioInputStream(tennisPath);
                        Clip tennisClip = AudioSystem.getClip();
                        tennisClip.open(tennisInput);
                        tennisClip.start();
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        });

        // ASPARAGUS BUTTON
        greenButton = new JButton("Green On");
        greenButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                if (a.getSource() == greenButton)
                    greenButton.setText("Green On");
                int i = 0;
                for (JLabel member : greyKhaledLabels) {
                    member.setIcon(greyKhaledIcons[i]);
                    i++;
                }
                greyKhaledLabels[0].setIcon(khaledIcons[0]);
                try
                {
                    File asparagusPath = new File(asparagusAudio);

                    if(asparagusPath.exists())
                    {
                        AudioInputStream asparagusInput = AudioSystem.getAudioInputStream(asparagusPath);
                        Clip asparagusClip = AudioSystem.getClip();
                        asparagusClip.open(asparagusInput);
                        asparagusClip.start();
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        });

        // ADDS BUTTONS
        this.add(greenButton);
        this.add(redButton);
        this.add(yellowButton);


        this.setPreferredSize(new Dimension(900, 600));
        this.setBackground(Color.LIGHT_GRAY);

    }

}
