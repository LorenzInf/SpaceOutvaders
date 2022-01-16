package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.view.MainMenu;

import java.awt.event.KeyEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerMainMenu extends InputManager {

    private final ProgramController programController;
    private final ViewController viewController;
    private MainMenu menu;
    private final SoundController soundController;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerMainMenu(ProgramController programController, ViewController viewController, SoundController soundController){
        super(viewController, programController, soundController);
        this.programController = programController;
        this.viewController = viewController;
        this.soundController = soundController;
        viewController.register(this, 0);
    }

    @Override
    public void keyPressed(int key){
        updateSoundController();
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
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            if(programController.getWindow().getMainMenuIndex() < 4) {
                if (programController.getWindow().getMainMenuIndex() != 1) {
                    programController.getWindow().setMainMenuIndex(programController.getWindow().getMainMenuIndex() - 1);
                } else {
                    programController.getWindow().setMainMenuIndex(3);
                }
            }
        }

        // Selected den Button Links
        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            if(programController.getWindow().getMainMenuIndex() < 4) {
                if (programController.getWindow().getMainMenuIndex() != 3) {
                    programController.getWindow().setMainMenuIndex(programController.getWindow().getMainMenuIndex() + 1);
                } else {
                    programController.getWindow().setMainMenuIndex(1);
                }
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
        }
        forceMainMenu(key);
    }
}