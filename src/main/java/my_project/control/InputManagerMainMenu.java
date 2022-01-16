package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.model.Sound;
import my_project.view.MainMenu;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerMainMenu extends InteractiveGraphicalObject {

    private final ProgramController programController;
    private final ViewController viewController;
    private MainMenu menu;
    private final SoundController soundController;
    private long lastLoop,elapsedTime;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerMainMenu(ProgramController programController, ViewController viewController, SoundController soundController){
        this.programController = programController;
        this.viewController = viewController;
        this.soundController = soundController;
        this.soundController.loadSound("src/main/resources/sound/select.mp3","select",false);
        this.soundController.loadSound("src/main/resources/sound/exit.mp3","exit",false);
        viewController.register(this, 0);
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
            if(programController.getWindow().getMainMenuIndex() == 5) programController.getWindow().escape();
            if(programController.getWindow().getMainMenuIndex() > 0){
                SoundController.playSound("select");
                programController.getWindow().switchScene(programController.getWindow().getMainMenuIndex());
            }
        }

        if(key == KeyEvent.VK_ESCAPE) {
            SoundController.playSound("exit");
            programController.getWindow().escape();
        }

        // Selected den Button rechts
        if(key == KeyEvent.VK_A){
            if(programController.getWindow().getMainMenuIndex() < 4) {
                if (programController.getWindow().getMainMenuIndex() != 1) {
                    programController.getWindow().setMainMenuIndex(programController.getWindow().getMainMenuIndex() - 1);
                } else {
                    programController.getWindow().setMainMenuIndex(3);
                }
                viewController.draw(menu);
                // ToDo: Bewege Raumschiff nach links
            }
        }

        // Selected den Button Links
        if(key == KeyEvent.VK_D){
            if(programController.getWindow().getMainMenuIndex() < 4) {
                if (programController.getWindow().getMainMenuIndex() != 3) {
                    programController.getWindow().setMainMenuIndex(programController.getWindow().getMainMenuIndex() + 1);
                } else {
                    programController.getWindow().setMainMenuIndex(1);
                }
                viewController.draw(menu);
                // ToDo: Bewege Raumschiff nach rechts
            }
        }

        // Selected den Button oben
        if(key == KeyEvent.VK_W){
            if(programController.getWindow().getMainMenuIndex() == 4){
                programController.getWindow().setMainMenuIndex(2);
            } else {
                programController.getWindow().setMainMenuIndex(5);
            }
            viewController.draw(menu);
        }

        // Selected den Button unten
        if(key == KeyEvent.VK_S){
            if(programController.getWindow().getMainMenuIndex() == 5){
                programController.getWindow().setMainMenuIndex(2);
            } else {
                programController.getWindow().setMainMenuIndex(4);
            }
            viewController.draw(menu);
        }
    }
}