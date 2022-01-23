package my_project.control;

import KAGO_framework.control.SoundController;
import my_project.Config;
import my_project.model.Player;
import KAGO_framework.control.ViewController;
import my_project.model.Shoot;
import my_project.view.Game;
import my_project.view.Visual2DArray;

import java.awt.*;
import java.lang.reflect.Array;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private final ViewController viewController;
    private final SoundManager soundManager;
    private GraphicalWindow window;
    private Visual2DArray array;
    private Player player;
    private Shoot shoot;


    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
        soundManager = new SoundManager();
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        // Zu dem Array, die X Koordinate der Mitte ist 674 und 772, wird ein bisschen blöd mit den Koordinaten dann rumzuspielen wegen den Enemys
        array = new Visual2DArray<Game>(11, Config.WINDOW_HEIGHT / 175, 0 , 0, new Visual2DArray.VisualizationConfig(0,0, 173, 175, 0, true, false, false, null, Color.WHITE, new Color(0,0,0,0)));
        window = new GraphicalWindow(viewController, this);
        new InputManagerMainMenu(this, viewController, soundManager);
        new InputManagerOptions(this, viewController, window.getOptions(), soundManager);
        new InputManagerGame(this, viewController, soundManager, getWindow().getGame());
        player = new Player(674,772,0,0,false, 0, viewController, getWindow().programController);
        shoot = new Shoot(viewController, 300, 300, 100 ,100, 1, 255, 0 ,0 , 0 ,0, 255, false, this);
        viewController.draw(array, 2);
        viewController.register(array);
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }

    public GraphicalWindow getWindow(){
        return window;
    }

    public Player getPlayer() {
        return player;
    }

    public Shoot getShoot(){
        return shoot;
    }

}
