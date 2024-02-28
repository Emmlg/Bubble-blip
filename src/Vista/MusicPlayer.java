/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author abiga
 */
public class MusicPlayer {
    private static Clip clip;

    public static void playMusic(String filePath) {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                MusicPlayer.class.getResourceAsStream(filePath)
            );
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
