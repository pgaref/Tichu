/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import tichu.Cards.Card;
import tichu.Game.Player;

/**
 *
 * @author Dimitris
 */
public class VerticalViewCardPanel extends ViewCardPanel {
    public VerticalViewCardPanel(Player _player,boolean _isMirror){
        super(_player,_isMirror);
        super.setImage_dir("/tichu/images/vertical/");
        this.setPreferredSize(new Dimension(160, 400));
        this.setMaximumSize(new Dimension(160, 400));
        this.addCards();
    }
    
    @Override
    public void changePlayer(Player p){
        super.setPlayer(p);
        super.removeAll();
        super.revalidate();
        super.repaint();
        super.name.setText(p.getName());
        this.addCards();
    }
    
    public void HideCards(){
        this.removeAll();
        super.revalidate();
        super.repaint();
        Point origin = new Point(27, 20);
        if(!super.isIsMirror()){
            origin.x = 5;
        }
        int i = 1;
        name.setBounds(origin.x, origin.y, 200, 20);
        name.setForeground(Color.white);
        super.add(name,new Integer(i++));
        origin.y += 25;
        for(Card c : super.getPlayer().getPlayersHand()){
            ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.RIGHT : Direction.LEFT,super.getImage_dir());
            card.setCard_image(new ImageIcon(getClass().getResource("/tichu/images/back.jpg")));
            card.setNotMove(true);
            super.add(card,new Integer(i++));
            origin.y += 20;
        }
    }
    
    @Override
    public void showCards(){
        System.out.println("Vertical showCards");
    }
    
    private void addCards(){
        Point origin = new Point(27, 20);
        if(!super.isIsMirror()){
            origin.x = 5;
        }
        int i = 1;
        name.setBounds(origin.x, origin.y, 200, 20);
        name.setForeground(Color.white);
        super.add(name,new Integer(i++));
        origin.y += 25;
        for(Card c : super.getPlayer().getPlayersHand()){
            ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.RIGHT : Direction.LEFT,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.y += 20;
        }
    }
}
