import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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


    public Khaled(String name) {
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
        button = new JButton( name + " on");
        button.addActionListener( new ActionListener() {
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
                        /*//change icon when audio is done
                        while(velvetClip.getMicrosecondLength() != velvetClip.getMicrosecondPosition())
                        {

                        }
                        greyKhaledLabel.setIcon(greyKhaledIcon);*/
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        });

        // KHALED IMAGE AS BUTTON
        greyKhaledLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
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
                        /*//change icon when audio is done
                        while(velvetClip.getMicrosecondLength() != velvetClip.getMicrosecondPosition())
                        {

                        }
                        greyKhaledLabel.setIcon(greyKhaledIcon);*/
                    }
                }
                catch(Exception w)
                {
                    System.out.println(w);
                }
            }
        });
    }

}
