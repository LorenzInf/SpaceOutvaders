package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.view.MainMenu;
import my_project.view.Options;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.security.Key;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerOptions extends InteractiveGraphicalObject {

    private ProgramController programController;
    private ViewController viewController;
    private Options options;
    private long elapsedTime,lastLoop;
    private SoundController soundController;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerOptions(ProgramController programController, ViewController viewController, Options options, SoundController soundController){
        this.programController = programController;
        this.viewController = viewController;
        this.options = options;
        this.soundController = soundController;
        this.soundController.loadSound("src/main/resources/sound/select.mp3","select",false);
        this.soundController.loadSound("src/main/resources/sound/exit.mp3","exit",false);
        viewController.register(this, 1);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(int key){

        elapsedTime = System.nanoTime() - lastLoop;
        lastLoop = System.nanoTime();
        int dt = (int) ((elapsedTime / 1000000L));
        double dtSeconds = (double)dt/1000;
        if ( dtSeconds == 0 ) dtSeconds = 0.01;
        if(soundController != null) soundController.update(dtSeconds);

        if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE){
            // Checkt Boolean Wert für das ändern des Symbols
            if (programController.getWindow().getOptionsIndex() == 1) {
                options.setMusicOn(!options.isMusicOn());
                SoundController.playSound("select");
            }
            if (programController.getWindow().getOptionsIndex() == 2) {
                options.setSoundOn(!options.isSoundOn());
                SoundController.playSound("select");
            }
            if(programController.getWindow().getOptionsIndex() == 3){ // Wenn man auf dem X ist
                SoundController.playSound("exit");
                programController.getWindow().setOptionsIndex(1);
                viewController.draw(options); // Damit das X nicht rot markiert ist
                programController.getWindow().switchScene(0);
            }
        }

        if(key == KeyEvent.VK_ESCAPE){
            SoundController.playSound("exit");
            programController.getWindow().setOptionsIndex(1);
            viewController.draw(options); // Damit das X nicht rot markiert ist
            programController.getWindow().switchScene(0);
        }

        if(key == KeyEvent.VK_A){ // Markiertes Symbol nach rechts bewegen
            if(programController.getWindow().getOptionsIndex() >= 1){
                programController.getWindow().setOptionsIndex(programController.getWindow().getOptionsIndex()-1);
            }
        }

        if(key == KeyEvent.VK_D){ // Markiertes Symbol nach links bewegen
            if(programController.getWindow().getOptionsIndex() == 0){
                programController.getWindow().setOptionsIndex(1);
            } else if(programController.getWindow().getOptionsIndex() < 3){
                programController.getWindow().setOptionsIndex(programController.getWindow().getOptionsIndex()+1);
            }
        }
    }
}