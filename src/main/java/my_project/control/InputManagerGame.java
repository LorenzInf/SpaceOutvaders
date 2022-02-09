package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.model.Player;
import my_project.model.Shot;

import java.awt.event.KeyEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerGame extends InputManager {
    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerGame(ProgramController programController, ViewController viewController, SoundManager soundManager){
        super(viewController,programController,soundManager);
        viewController.register(this, 3);
    }

    @Override
    public void keyPressed(int key){
        if(key == KeyEvent.VK_SPACE){
            Player player = programController.getPlayer();
            if(player.getShootCooldown() == 0 && !programController.getWaveController().isShootLock()){
                SoundController.playSound("shootPlayer");
                new Shot(viewController, programController, player.getX()-28, player.getY() - 120,1300,false);
                programController.getPlayer().setShootCooldown(player.isRapidFire() ? 0.1 : 0.5);
            }
        }

        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            programController.getPlayer().setMove(0);
        }

        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            programController.getPlayer().setMove(2);
        }


        if (key == KeyEvent.VK_SHIFT) {
            if (programController.getBuffVisualQueue().getFront() != null) {
                SoundController.playSound("powerup");
                switch (programController.getBuffVisualQueue().getFront().getRandomNumber()) {
                    case 0 -> {
                        programController.createExtraLife();
                        programController.getPlayer().setExtraLife(true);
                    }
                    case 1 -> programController.getPlayer().setRapidFire(true);
                    case 2 -> programController.getPlayer().setSpeedBoost(true);
                    case 3 -> programController.getPlayer().setPiercing(true);
                    case 4 -> programController.getPlayer().setShield(true);
                }
                programController.getBuffVisualQueue().dequeue();
            }
        }
        setVolume(key);
        forceMainMenu(key);

        if(key == KeyEvent.VK_U){
            programController.getWindow().switchScene(6);
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_D || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            programController.getPlayer().setMove(1);
        }
    }
}