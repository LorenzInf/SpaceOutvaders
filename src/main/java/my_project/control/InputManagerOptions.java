package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.view.Options;

import java.awt.event.KeyEvent;
import java.security.Key;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerOptions extends InputManager {

    private final Options options;
    private double volRemember;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerOptions(ProgramController programController, ViewController viewController, Options options, SoundManager soundManager){
        super(viewController,programController, soundManager);
        volRemember = 1.0;
        this.options = options;
        viewController.register(this, 2);
    }

    @Override
    public void keyPressed(int key){
        if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE){
            // Checkt Boolean Wert für das ändern des Symbols
            if (programController.getWindow().getOptionsIndex() == 1) {
                options.setMusicOn(!options.isMusicOn());
                SoundController.setVolume("mainMenuTheme", options.isMusicOn() ? volRemember : 0.0);
                SoundController.setVolume("gameTheme1", options.isMusicOn() ? volRemember : 0.0);
                SoundController.playSound("select");
            }
            if (programController.getWindow().getOptionsIndex() == 2) {
                options.setSoundOn(!options.isSoundOn());
                SoundController.setVolume("select",options.isSoundOn() ? volRemember : 0.0);
                SoundController.setVolume("exit",options.isSoundOn() ? volRemember : 0.0);
                SoundController.setVolume("shootPlayer",options.isSoundOn() ? volRemember : 0.0);
                SoundController.setVolume("enemyDeath",options.isSoundOn() ? volRemember : 0.0);
                SoundController.playSound("select");
            }
            if(programController.getWindow().getOptionsIndex() == 3){ // Wenn man auf dem X ist
                SoundController.playSound("exit");
                programController.getWindow().setOptionsIndex(3);
                programController.getWindow().switchScene(1);
            }
        }

        if(key == KeyEvent.VK_ESCAPE){
            SoundController.playSound("exit");
            programController.getWindow().setOptionsIndex(3);
            programController.getWindow().switchScene(1);
        }

        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){ // Markiertes Symbol nach links bewegen
            switch (programController.getWindow().getOptionsIndex()){
                case 4 -> programController.getWindow().setOptionsIndex(5);
                case 2 -> programController.getWindow().setOptionsIndex(1);
            }
            SoundController.playSound("select");
        }

        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){ // Markiertes Symbol nach rechts bewegen
            switch (programController.getWindow().getOptionsIndex()){
                case 5 -> programController.getWindow().setOptionsIndex(4);
                case 1 -> programController.getWindow().setOptionsIndex(2);
            }
            SoundController.playSound("select");
        }

        if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){
            switch (programController.getWindow().getOptionsIndex()){
                case 3 -> programController.getWindow().setOptionsIndex(2);
                case 2 -> programController.getWindow().setOptionsIndex(4);
                case 1 -> programController.getWindow().setOptionsIndex(5);
            }
            SoundController.playSound("select");
        }

        if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
            switch (programController.getWindow().getOptionsIndex()){
                case 2 -> programController.getWindow().setOptionsIndex(3);
                case 4 -> programController.getWindow().setOptionsIndex(2);
                case 5 -> programController.getWindow().setOptionsIndex(1);
            }
            SoundController.playSound("select");
        }

        // Minus und Plus Buttons
        if(key == KeyEvent.VK_SPACE){
            if(programController.getWindow().getOptionsIndex() == 4){
                soundManager.modifyVolume(0.1);
                if(volRemember != 1){
                    volRemember = volRemember + 0.1;
                }
            }
            if(programController.getWindow().getOptionsIndex() == 5){
                soundManager.modifyVolume(-0.1);
                if(volRemember != 0){
                    volRemember = volRemember - 0.1;
                }
            }
        }

        setVolume(key);
        forceMainMenu(key);
    }
}