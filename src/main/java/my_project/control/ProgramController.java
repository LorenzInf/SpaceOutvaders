package my_project.control;

import KAGO_framework.control.SoundController;
import my_project.Config;
import my_project.model.*;
import KAGO_framework.control.ViewController;
import my_project.view.*;

import java.awt.*;

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
    private Enemy[][] array;
    private VisualStack<PlayerLife> playerLifesStack;
    private VisualList<PlayerName> nameList;
    private VisualQueue<Buff> buffVisualQueue;
    private Player player;
    private PlayerLife playerLife;
    private PlayerLife emptyPlayerLife;
    private PlayerLife extraLife;
    private EnemyWave enemyWave;
    private Buff buff;
    private boolean moveTimerActive;
    private boolean gameOver;
    private boolean inGame;
    private PlayerName playerName;
    private int score;


    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
        soundManager = new SoundManager(viewController);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        array = new Enemy[11][6];
        playerLifesStack = new VisualStack<>(viewController);
        buffVisualQueue = new VisualQueue<>(viewController, 50, 950, "up");
        window = new GraphicalWindow(viewController, this);
        playerName = new PlayerName(viewController,this);


        new InputManagerMainMenu(this, viewController, soundManager);
        new InputManagerOptions(this, viewController, window.getOptions(), soundManager);
        new InputManagerGame(this, viewController, soundManager);
        new InputManagerEnterName(this, viewController, soundManager);
        new InputManagerLeaderboard(this,viewController,soundManager);
        new InputManagerGuide(this, viewController, soundManager);

        player = new Player(viewController, getWindow().programController);

        emptyPlayerLife = new PlayerLife(1810, 810, viewController, this, 1);
        emptyPlayerLife = new PlayerLife(1810, 880, viewController, this, 1);
        emptyPlayerLife = new PlayerLife(1810, 950, viewController, this, 1);

        playerLife = new PlayerLife(1810, 810, viewController, this, 0);
        playerLife = new PlayerLife(1810, 880, viewController, this, 0);
        playerLife = new PlayerLife(1810, 950, viewController, this, 0);


        SoundController.playSound("mainMenuTheme");
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        if(viewController.getCurrentSceneIndex() == GraphicalWindow.GAME_INDEX) inGame = true;
        if(viewController.getCurrentSceneIndex() != GraphicalWindow.GAME_INDEX && inGame){
            clearGame();
            gameOver = false;
        }
    }

    public void createBuff(){
        buff = new Buff(935, 0, viewController, this);
    }

    public void clearGame(){
        gameOver = true;
        player.setX(865 + 28);
        player.setY(875 + 12);
        while(getBuffVisualQueue().getCounter() != 0){
            getBuffVisualQueue().dequeue();
        }
        switch(getStack().getCounter()){
            case 0 -> {
                for(int i = 0; i < 3; i ++) new PlayerLife(1810, 950-i*70, viewController, this, 0);
            }
            case 1 -> {
                for(int i = 0; i < 2; i ++) new PlayerLife(1810, 950-i*70, viewController, this, 0);
            }
            case 2 -> {
                for(int i = 0; i < 1; i ++) new PlayerLife(1810, 950-i*70, viewController, this, 0);
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 6; j++) {
                if(array[i][j] != null){
                    viewController.removeDrawable(array[i][j]);
                    array[i][j] = null;
                }
            }
        }
    }

    public void createExtraLife(){
        extraLife = new PlayerLife(1810, 740, viewController, this, 2);
    }

    public PlayerLife getExtraLife() {
        return extraLife;
    }

    public GraphicalWindow getWindow(){
        return window;
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy[][] getArray() {
        return array;
    }

    public EnemyWave getEnemyWave(){
        return enemyWave;
    }

    public Buff getBuff() {
        return buff;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public VisualStack<PlayerLife> getStack(){
        return playerLifesStack;
    }

    public void setMoveTimerActive(boolean moveTimerActive) {
        this.moveTimerActive = moveTimerActive;
    }

    public VisualQueue<Buff> getBuffVisualQueue() {
        return buffVisualQueue;
    }
    public VisualList<PlayerName> getNameList() {
        return nameList;
    }

    public void setNameList(VisualList<PlayerName> nameList) {
        this.nameList = nameList;
    }

    public PlayerName getPlayerName() {
        return playerName;
    }
}
