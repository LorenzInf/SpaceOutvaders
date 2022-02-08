package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;

public class SoundManager {
    //private long lastLoop;
    private boolean soundOff, soundOn;
    private double vol;

    public SoundManager(ViewController viewController) {
        SoundController mySoundController = viewController.getSoundController();
        String path = "src/main/resources/sound/";
        mySoundController.loadSound(path + "select.mp3","select",false);
        mySoundController.loadSound(path + "exit.mp3","exit",false);
     //   mySoundController.loadSound(path + "Joshua McLean - Mountain Trials.mp3","mainMenuTheme",true);
    //    mySoundController.loadSound(path + "AdhesiveWombat - Night Shade.mp3","gameTheme1",true);
        mySoundController.loadSound(path + "shoot.mp3","shootPlayer",false);
        mySoundController.loadSound(path + "enemy_death.mp3","enemyDeath",false);
        mySoundController.loadSound(path + "Undertale Game Over.mp3", "gameover", true);
        mySoundController.loadSound(path + "instant_shot.mp3","instantShot",false);
        mySoundController.loadSound(path + "pickup.mp3","pickup",false);
        mySoundController.loadSound(path + "shield_hit.mp3","shieldHit",false);
        mySoundController.loadSound(path + "shot_charge.mp3","shotCharge",false);
        soundOff = false;
        soundOn = false;
        vol = 1;
    }

    public void modifyVolume(double volume){
        SoundController.addToMasterVolume(volume);
    }
}
