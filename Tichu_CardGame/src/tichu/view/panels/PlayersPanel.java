/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.panels;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tichu.Cards.Card;
import tichu.Combinations.CardCombination;
import tichu.Game.Player;
import tichu.Game.TICHU;
import tichu.Game.Team;

/**
 *
 * @author Dimitris
 */
public class PlayersPanel extends JPanel {
    
    private HorizontalViewCardPanel up;
    private HorizontalViewCardPanel down;
    private CenterPanel center;
    private VerticalViewCardPanel left;
    private VerticalViewCardPanel right;
    
    private ViewCardPanel activepanel = null;
    
    private TICHU game;
    
    public PlayersPanel(TICHU _game){
        super();
        game = _game;
        center = new CenterPanel(game,this);
        this.setLayout(new BorderLayout());
        this.addPanels();
        this.add(center, BorderLayout.CENTER);
    }
    
    public Player showDragonDialog(Team t){
        Object [] possibilities = {t.getP1().getName(),t.getP2().getName() };
        String s = (String)JOptionPane.showInputDialog(null,
                            "Select player to send the baza\n"
                            ,
                            "Send baza to",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            t.getP1().getName());
        if(s.equals(t.getP1().getName())){
            return t.getP1();
        }
        else {
            return t.getP2();
        }
    }
    
    private void addPanels(){
        if(up != null && down != null && left != null && right != null){
            this.remove(up);
            this.remove(down);
            this.remove(right);
            this.remove(left);
        }
        this.down = new HorizontalViewCardPanel(game.getFirstTeam().getP1(),false);
        this.up = new HorizontalViewCardPanel(game.getFirstTeam().getP2(),true);
        
        this.left = new VerticalViewCardPanel(game.getSecondTeam().getP1(),false);
        this.right = new VerticalViewCardPanel(game.getSecondTeam().getP2(),true);
        
        this.add(up, BorderLayout.PAGE_START);
        this.add(down, BorderLayout.PAGE_END);
        this.add(left, BorderLayout.LINE_START);
        this.add(right, BorderLayout.LINE_END);
    }
    
    public void drawTheOtherCards(){
        game.initialiazePlayersWithSixMoreCards();
        this.addPanels();
        this.findCurrentPlayer();
        System.out.println("active panel player : " +activepanel.getPlayer().getName());
        System.out.println("current player : " + game.getCurrentPlayer().getName());
    }
    
    public void clearAll(){
        center.clearAll();
    }
    
    public void findCurrentPlayer(){
        Player current = game.getCurrentPlayer();
        
        if(up.getPlayer().getName().equals(current.getName())){
            activepanel = up;
            up.changeCurrentPlayerColor();
            down.HideCards();
            left.HideCards();
            right.HideCards();
        }
        else if(down.getPlayer().getName().equals(current.getName())){
            activepanel = down;
            down.changeCurrentPlayerColor();
            left.HideCards();
            right.HideCards();
            up.HideCards();
        }
        else if(left.getPlayer().getName().equals(current.getName())){
            activepanel = left;
            left.changeCurrentPlayerColor();
            right.HideCards();
            up.HideCards();
            down.HideCards();
        }
        else{
            activepanel = right;
            right.changeCurrentPlayerColor();
            up.HideCards();
            left.HideCards();
            down.HideCards();
        }
        
        activepanel.changePlayer(current);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon back = new ImageIcon(getClass().getResource("/tichu/images/background.jpg"));
        g.drawImage(back.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public ArrayList<Card> getSelectedCards(){
        return activepanel != null ? activepanel.getSelectedCards() : null;
    }
    
    public void makeMahjongPanel(Card c){
        center.showMahjongPanel(c,activepanel.getPlayer());
    }

    public void setCards(CardCombination comb) {
        center.setCards(comb);
    }
}
