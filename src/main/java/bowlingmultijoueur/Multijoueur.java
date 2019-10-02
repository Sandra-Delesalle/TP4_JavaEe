/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingmultijoueur;

/**
 *
 * @author pedago
 */
public class Multijoueur implements bowling.MultiPlayerGame{
    
    private String[] Players;
    private int ActualPlayer;
    private int NmPlayers;
    private SinglePlayerGame Partie;
    
    public Multijoueur(){
        NmPlayers = -1;
        ActualPlayer = -1;
        Players = null;
    }

    @Override
    public String startNewGame(String[] playerName) throws Exception {
        NmPlayers = playerName.length;
        Players = new String[NmPlayers];
        
        for (int i = 0 ; i<NmPlayers ; i++){
            Players[i] = playerName[i];
            Partie = new SinglePlayerGame();
        }
        ActualPlayer = 0;
        return "Prochain tir : " + Players[0] + ", tour n° 1, boule n° 1";
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        return 1;
    }
    
    /*String[] players = { "John", "Paul", "Georges", "Ringo" };
MultiPlayerGame game = new Multijoueur();
System.out.println(game.startNewGame(players));*/
    
}
