/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingmultijoueur;

import bowling.SinglePlayerGame;

/**
 *
 * @author pedago
 */
public class Multijoueur implements bowling.MultiPlayerGame{
    
    private String[] Players;
    private int ActualPlayer;
    private int NmPlayers;
    public SinglePlayerGame partie;
    public SinglePlayerGame[] partiejoueur;
    
    public Multijoueur(){
        NmPlayers = -1;
        ActualPlayer = -1;
        Players = null;
    }

    @Override
    public String startNewGame(String[] playerName) throws Exception {
        NmPlayers = playerName.length;
        Players = new String[NmPlayers];
        partiejoueur = new SinglePlayerGame[NmPlayers];
        
        for (int i = 0 ; i<NmPlayers ; i++){
            Players[i] = playerName[i];
            partie = new SinglePlayerGame();
            partiejoueur[i] = partie;
        }
        ActualPlayer = 0;
        return "Prochain tir : " + Players[0] + ", tour n° 1, boule n° 1";
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        partiejoueur[ActualPlayer].lancer(nombreDeQuillesAbattues);
        if (partiejoueur[ActualPlayer].isFinished() || partiejoueur[ActualPlayer].hasCompletedFrame()){
            ActualPlayer = (ActualPlayer+1)%Players.length;
            if(partiejoueur[ActualPlayer].isFinished()){
                return "Fin de la partie";
            }
        }
        return "Prochain tir : " + Players[ActualPlayer] + ", tour n° "+partiejoueur[ActualPlayer].getFrameNumber()+", boule n° "+partiejoueur[ActualPlayer].getNextBallNumber();
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        int j = -1;
        for (int i=0; i<Players.length; i++){
            j = i;
        }
        return partiejoueur[j].score();
    }
    
    /*String[] players = { "John", "Paul", "Georges", "Ringo" };
MultiPlayerGame game = new Multijoueur();
System.out.println(game.startNewGame(players));*/
    
}
