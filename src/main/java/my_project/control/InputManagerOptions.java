package my_project.control;

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

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerOptions(ProgramController programController, ViewController viewController, Options options){
        this.programController = programController;
        this.viewController = viewController;
        this.options = options;
        viewController.register(this, 1);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(int key){
        if(key == KeyEvent.VK_SPACE){
            switch(programController.getWindow().getOptionsIndex()) { // Checkt Boolean Wert für das ändern des Symbols
                case 1 -> options.setMusicOn(!options.isMusicOn());
                case 2 -> options.setSoundOn(!options.isSoundOn());
                }
            viewController.draw(options);
            if(programController.getWindow().getOptionsIndex() == 3){ // Wenn man auf dem X ist
                programController.getWindow().setOptionsIndex(0);
                viewController.draw(options); // Damit das X nicht rot markiert ist
                programController.getWindow().switchScene(0);
            }
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