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
    private final SoundManager soundManager;
    private Game game;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerGame(ProgramController programController, ViewController viewController, SoundManager soundManager, Game game){
        super(viewController,programController,soundManager);
        this.programController = programController;
        this.viewController = viewController;
        this.soundManager = soundManager;
        this.game = game;
        viewController.register(this, 2);
    }

    @Override
    public void keyPressed(int key){

        if(key == KeyEvent.VK_SPACE){
            viewController.draw(programController.getShoot(), 2);
            // ToDo: Schießen
        }

        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            if(programController.getPlayer().getX() != -191){
                programController.getPlayer().setX(programController.getPlayer().getX()-173);
            }
        }

        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            if(programController.getPlayer().getX() != 1539){
                programController.getPlayer().setX(programController.getPlayer().getX()+173);
            }
        }
        forceMainMenu(key);
    }
}