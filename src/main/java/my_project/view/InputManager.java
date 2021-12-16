package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import KAGO_framework.control.ViewController;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManager extends InteractiveGraphicalObject {

    private ProgramController programController;
    private ViewController viewController;
    private Menu menu;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManager(ProgramController programController, ViewController viewController){
        this.programController = programController;
        this.viewController = viewController;
        viewController.register(this);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(int key){

        if(key == KeyEvent.VK_SPACE){
            programController.getMenu().switchScene();
        }

        if(key == KeyEvent.VK_A){
            if(programController.getMenu().getButtonIndex() != 1){
                programController.getMenu().setButtonIndex(programController.getMenu().getButtonIndex() - 1);
            }else{
                programController.getMenu().setButtonIndex(4);
            }
        }

        if(key == KeyEvent.VK_D){
            if(programController.getMenu().getButtonIndex() != 4){
                programController.getMenu().setButtonIndex(programController.getMenu().getButtonIndex() + 1);
            }else{
                programController.getMenu().setButtonIndex(1);
            }
        }

        if(key == KeyEvent.VK_LEFT){
            // ToDo: Bewege Raumschiff nach links
        }

        if(key == KeyEvent.VK_RIGHT){
            // ToDo: Bewege Raumschiff nach rechts
        }

    }
}
