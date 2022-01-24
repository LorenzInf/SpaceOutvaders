package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.view.Options;

import java.awt.event.KeyEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerOptions extends InputManager {

    private final Options options;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerOptions(ProgramController programController, ViewController viewController, Options options, SoundManager soundManager){
        super(viewController,programController, soundManager);
        this.options = options;
        viewController.register(this, 1);
    }

    @Override
    public void keyPressed(int key){
        soundManager.updateSoundController();
        if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE){
            // Checkt Boolean Wert für das ändern des Symbols
            if (programController.getWindow().getOptionsIndex() == 1) {
                options.setMusicOn(!options.isMusicOn());
                SoundController.setVolume("mainMenuTheme",options.isMusicOn() ? 1.0 : 0.0);
                SoundController.setVolume("gameTheme1",options.isMusicOn() ? 1.0 : 0.0);
                SoundController.playSound("select");
            }
            if (programController.getWindow().getOptionsIndex() == 2) {
                options.setSoundOn(!options.isSoundOn());
                SoundController.setVolume("select",options.isSoundOn() ? 1.0 : 0.0);
                SoundController.setVolume("exit",options.isSoundOn() ? 1.0 : 0.0);
                SoundController.playSound("select");
            }
            if(programController.getWindow().getOptionsIndex() == 3){ // Wenn man auf dem X ist
                SoundController.playSound("exit");
                programController.getWindow().setOptionsIndex(1);
                programController.getWindow().switchScene(0);
            }
        }

        if(key == KeyEvent.VK_ESCAPE){
            SoundController.playSound("exit");
            programController.getWindow().setOptionsIndex(1);
            programController.getWindow().switchScene(0);
        }

        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){ // Markiertes Symbol nach rechts bewegen
            if(programController.getWindow().getOptionsIndex() >= 1){
                programController.getWindow().setOptionsIndex(programController.getWindow().getOptionsIndex()-1);
            }
        }

        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){ // Markiertes Symbol nach links bewegen
            if(programController.getWindow().getOptionsIndex() == 0){
                programController.getWindow().setOptionsIndex(1);
            } else if(programController.getWindow().getOptionsIndex() < 3){
                programController.getWindow().setOptionsIndex(programController.getWindow().getOptionsIndex()+1);
            }
        }
        forceMainMenu(key);
    }
}