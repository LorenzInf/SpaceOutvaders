package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManager extends InteractiveGraphicalObject {

    private ProgramController programController;
    private ViewController viewController;
    private MainMenu menu;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManager(ProgramController programController, ViewController viewController){
        this.programController = programController;
        this.viewController = viewController;

        for (int i = 0; i < 4; i++) {
            viewController.register(this, i);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(int key){
        if(key == KeyEvent.VK_SPACE) programController.getWindow().switchScene(1/*temp*/);
        if(key == KeyEvent.VK_ESCAPE) programController.getWindow().escape();

        // Selected den Button rechts
        if(key == KeyEvent.VK_A){
            if(programController.getWindow().getButtonIndex() < 4) {
                if (programController.getWindow().getButtonIndex() != 1) {
                    programController.getWindow().setButtonIndex(programController.getWindow().getButtonIndex() - 1);
                } else {
                    programController.getWindow().setButtonIndex(3);
                }
                viewController.draw(menu);
                // ToDo: Bewege Raumschiff nach links
            }
        }

        // Selected den Button Links
        if(key == KeyEvent.VK_D){
            if(programController.getWindow().getButtonIndex() < 4) {
                if (programController.getWindow().getButtonIndex() != 3) {
                    programController.getWindow().setButtonIndex(programController.getWindow().getButtonIndex() + 1);
                } else {
                    programController.getWindow().setButtonIndex(1);
                }
                viewController.draw(menu);
                // ToDo: Bewege Raumschiff nach rechts
            }
        }

        // Selected den Button oben
        if(key == KeyEvent.VK_W){
            if(programController.getWindow().getButtonIndex() == 5){
                programController.getWindow().setButtonIndex(2);
            } else {
                programController.getWindow().setButtonIndex(4);
            }
            viewController.draw(menu);
        }

        // Selected den Button unten
        if(key == KeyEvent.VK_S){
            if(programController.getWindow().getButtonIndex() == 4){
                programController.getWindow().setButtonIndex(2);
            } else {
                programController.getWindow().setButtonIndex(5);
            }
            viewController.draw(menu);
        }
    }
}