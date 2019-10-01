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
    
    public Multijoueur(){
        this.NmPlayers = -1;
        this.ActualPlayer = -1;
        this.Players = null;
    }

    @Override
    public String startNewGame(String[] playerName) throws Exception {
        this.NmPlayers = playerName.length;
        this.Players = new String[this.NmPlayers];
        
        for (int i = 0 ; i<this.NmPlayers ; i++){
            this.Players[i] = playerName[i];
        }
        this.ActualPlayer = 0;
        return "Prochain tir:";
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
