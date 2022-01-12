package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import my_project.view.MainMenu;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerMainMenu extends InteractiveGraphicalObject {

    private ProgramController programController;
    private ViewController viewController;
    private MainMenu menu;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerMainMenu(ProgramController programController, ViewController viewController){
        this.programController = programController;
        this.viewController = viewController;
        viewController.register(this, 0);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(int key){
        if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE){
            if(programController.getWindow().getMainMenuIndex() == 5) programController.getWindow().escape();
            if(programController.getWindow().getMainMenuIndex() > 0){
                programController.getWindow().switchScene(programController.getWindow().getMainMenuIndex());
            }
        }

        if(key == KeyEvent.VK_ESCAPE) programController.getWindow().escape();

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