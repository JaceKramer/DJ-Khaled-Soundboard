import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Khaled {

    //main image String
    private String image;
    //Grey image String
    private String imageGrey;
    //Sound (.wav) file string
    private String sound;


    private ImageIcon khaledIcon;
    private ImageIcon greyKhaledIcon;

    private JLabel khaledLabel;
    private JLabel greyKhaledLabel;
    private JButton button;

    public JLabel getGreyKhaledLabel() {
        return greyKhaledLabel;
    }
    public JButton getButton() {
        return button;
    }


    public Khaled(String name, char key) {
        this.image = name + ".png";
        this.imageGrey = name + "grey.png";
        this.sound = name + ".wav";

        //Color Image
        ImageIcon kicon = new ImageIcon(image);
        Image kimage = kicon.getImage();
        Image newv = kimage.getScaledInstance(290, 290, Image.SCALE_SMOOTH);
        khaledIcon = new ImageIcon(newv);
        khaledLabel = new JLabel(khaledIcon);

        //GREY IMAGE
        ImageIcon kiconGrey = new ImageIcon(imageGrey);
        Image kimageGrey = kiconGrey.getImage();
        Image newag = kimageGrey.getScaledInstance(290, 290, Image.SCALE_SMOOTH);
        greyKhaledIcon = new ImageIcon(newag);
        greyKhaledLabel = new JLabel(greyKhaledIcon);

        //BUTTON
        button = new JButton( name + " " + key);

        Action Execute = new AbstractAction() {
            public void actionPerformed(ActionEvent pressed) {
                //INSERT ACTION
                greyKhaledLabel.setIcon(khaledIcon);

                try
                {
                    File velvetPath = new File(sound);

                    if(velvetPath.exists())
                    {

                        //setup and play audio
                        AudioInputStream velvetInput = AudioSystem.getAudioInputStream(velvetPath);
                        Clip velvetClip = AudioSystem.getClip();
                        long length = velvetClip.getMicrosecondLength();
                        velvetClip.open(velvetInput);
                        velvetClip.start();


                        LineListener listener = new LineListener() {
                            public void update(LineEvent event) {
                                if (event.getType() != LineEvent.Type.STOP) {
                                    return;
                                }

                                greyKhaledLabel.setIcon(greyKhaledIcon);
                            }
                        };
                        velvetClip.addLineListener(listener);

                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        };
        button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), "pressed");
        button.getActionMap().put("pressed", Execute);

        /*button.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent r) {

                greyKhaledLabel.setIcon(khaledIcon);

                try
                {
                    File velvetPath = new File(sound);

                    if(velvetPath.exists())
                    {

                        //setup and play audio
                        AudioInputStream velvetInput = AudioSystem.getAudioInputStream(velvetPath);
                        Clip velvetClip = AudioSystem.getClip();
                        long length = velvetClip.getMicrosecondLength();
                        velvetClip.open(velvetInput);
                        velvetClip.start();


                        LineListener listener = new LineListener() {
                            public void update(LineEvent event) {
                                if (event.getType() != LineEvent.Type.STOP) {
                                    return;
                                }

                                greyKhaledLabel.setIcon(greyKhaledIcon);
                            }
                        };
                        velvetClip.addLineListener(listener);

                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        });*/
    }



}
