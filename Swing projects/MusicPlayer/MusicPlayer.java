package MusicPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MusicPlayer extends JFrame implements ActionListener{
    JButton playButton, pauseButton, stopButton, chooseButton;
    File selectedFile;
    Clip clip;

    MusicPlayer(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 300);
        this.setTitle("Music Player");
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));

        playButton = new JButton("Play");
        playButton.addActionListener(this);
        panel.add(playButton);

        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(this);
        panel.add(pauseButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        panel.add(stopButton);

        chooseButton = new JButton("Choose File");
        chooseButton.addActionListener(this);
        panel.add(chooseButton);


        this.add(BorderLayout.CENTER, panel);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            play();
        } else if (e.getSource() == pauseButton) {
            pause();
        } else if (e.getSource() == stopButton) {
            stop();
        } else if (e.getSource() == chooseButton) {
            selectFile();
        }
    }
    
    public void play(){
        if(selectedFile != null){
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(selectedFile);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select a file to play.");
        }
    }


    public void pause(){
        if(clip != null && clip.isRunning()){
            clip.stop();
        }
    }

    public void stop(){
        if(clip != null){
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    public void selectFile(){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Audio Files", "wav", "mp3", "ogg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile);
        }
    }

}
