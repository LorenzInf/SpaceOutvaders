package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;

public class SoundManager {
    //private long lastLoop;
    private boolean soundOff, soundOn;
    private double vol;

    public SoundManager(ViewController viewController) {
        SoundController mySoundController = viewController.getSoundController();
        mySoundController.loadSound("src/main/resources/sound/select.mp3","select",false);
        mySoundController.loadSound("src/main/resources/sound/exit.mp3","exit",false);
        mySoundController.loadSound("src/main/resources/sound/Joshua McLean - Mountain Trials.mp3","mainMenuTheme",true);
        mySoundController.loadSound("src/main/resources/sound/AdhesiveWombat - Night Shade.mp3","gameTheme1",true);
        mySoundController.loadSound("src/main/resources/sound/shoot.mp3","shootPlayer",false);
        mySoundController.loadSound("src/main/resources/sound/enemy_death.mp3","enemyDeath",false);
        mySoundController.loadSound("src/main/resources/sound/Undertale Game Over.mp3", "gameover", true);
        soundOff = false;
        soundOn = false;
        vol = 1;
    }

    public void modifyVolume(double volume){
        SoundController.addToMasterVolume(volume);
    }
}
