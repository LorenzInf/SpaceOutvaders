package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.model.Player;
import my_project.view.Game;

import java.awt.event.KeyEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerGame extends InputManager {

    private final ProgramController programController;
    private final ViewController viewController;
    private final SoundController soundController;
    private Game game;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerGame(ProgramController programController, ViewController viewController, SoundController soundController, Game game){
        super(viewController,programController,soundController);
        this.programController = programController;
        this.viewController = viewController;
        this.soundController = soundController;
        this.game = game;
        viewController.register(this, 2);
    }

    @Override
    public void keyPressed(int key){

        if(key == KeyEvent.VK_SPACE){
        }

        if(key == KeyEvent.VK_A){
        }

        if(key == KeyEvent.VK_D){
            game.getPlayer().setX(getX()+11);
            // Player um die Breite eines Array Feldes verschieben.
        }
        forceMainMenu(key);
    }
}