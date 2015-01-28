/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.panels;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import tichu.Cards.Card;
import tichu.Game.Player;

/**
 *
 * @author Dimitris
 */
public class ViewCardPanel extends JLayeredPane {
    
    private Player player;
    private boolean isMirror;
    private String image_dir;
    protected JLabel name;
    
    public ViewCardPanel(Player _player,boolean _isMirror){
        this.player = _player;
        this.isMirror = _isMirror;
        name = new JLabel(_player.getName());
    }
    
   public ViewCardPanel(boolean _isMirror){
        this.player = null;
        this.isMirror = _isMirror;
    }
    
    public void changeCurrentPlayerColor(){
        name.setForeground(Color.YELLOW);
    }
    
    public void changePlayer(Player p){}
    
    public void showCards(){}

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the image_dir
     */
    public String getImage_dir() {
        return image_dir;
    }

    /**
     * @param image_dir the image_dir to set
     */
    public void setImage_dir(String image_dir) {
        this.image_dir = image_dir;
    }

    /**
     * @return the isMirror
     */
    public boolean isIsMirror() {
        return isMirror;
    }
    
    public ArrayList<Card> getSelectedCards(){
        ArrayList<Card> cards = new ArrayList<>();
        for(Component c : getComponents()){
            if(c instanceof ViewCard){
                if(((ViewCard) c).isRaised()){
                    cards.add(((ViewCard) c).getCard());
                }
            }
        }
        return cards;
    }
    
}
