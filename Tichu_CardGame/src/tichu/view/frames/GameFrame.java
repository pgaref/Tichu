/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.frames;

import tichu.view.panels.GameInfoPanel;
import tichu.view.panels.PlayersPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import tichu.Combinations.CardCombination;
import tichu.Combinations.CardSet;
import tichu.Game.Player;
import tichu.Game.TICHU;
import tichu.Game.Team;
import tichu.view.client.IGameClient;
import tichu.view.panels.WinTeam;

public class GameFrame extends JFrame implements IGameClient {
    
    private TICHU game;
    private PlayersPanel playersSpace; 
    private GameInfoPanel gameinfo;
    
    public GameFrame(){
        super("Tichu Game");
        InitPlayers players = new InitPlayers(null,true);
        Object [] playerNames =  players.getPlayers().toArray();
        this.game = new TICHU(String.valueOf(playerNames[0]), String.valueOf(playerNames[1])
                , String.valueOf(playerNames[2]), String.valueOf(playerNames[3]));
        this.game.setClient(this);
        this.game.initialiazePlayersWithEightCards();
        this.playersSpace = new PlayersPanel(game);
        this.gameinfo = new GameInfoPanel(game,playersSpace);
        this.playersSpace.setOpaque(true); 
        this.add(playersSpace,BorderLayout.CENTER);
        this.add(gameinfo, BorderLayout.EAST);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    public static void main(String [] args){
        
           GameFrame game = new GameFrame();
    }
    
    /**
     * @return the game
     */
    public TICHU getGame() {
        return game;
    }

    @Override
    public Player showTheMpazaWindow() {
        return playersSpace.showDragonDialog(getOtherTeam());
    }
    
    @Override
    public void newRound(){
        this.playersSpace.clearAll();
        this.remove(playersSpace);
        this.gameinfo.setMahjongShow(false);
        this.game.initialiazePlayersWithEightCards();
        this.playersSpace = new PlayersPanel(game);
        this.gameinfo.setPlayers(playersSpace);
        this.add(playersSpace,BorderLayout.CENTER);
        
        this.revalidate();
        this.repaint();
    }
    
    private Team getOtherTeam(){
        Player p = game.getCurrentPlayer();
        if(p == game.getFirstTeam().getP1() || 
           p == game.getFirstTeam().getP2()){
            return game.getSecondTeam();
        }
        else{
            return game.getFirstTeam();
        }
    }
    
    @Override
    public void changePlayer(CardCombination comb){
        System.out.print("change player in GameFrame");
        playersSpace.setCards(comb);
        this.gameinfo.changePlayer();
        playersSpace.findCurrentPlayer();
    }

    @Override
    public void skipPlayer() {
        this.gameinfo.changePlayer();
        playersSpace.findCurrentPlayer();
    }
    @Override
    public void showWinnerPanel(String _winner){
        
        WinTeam t = new WinTeam (this, true , _winner);
        System.out.println(_winner);
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }
    
}
