/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import tichu.Cards.Card;
import tichu.Cards.SimpleCard;
import tichu.Combinations.CardCombination;
import tichu.Game.Player;

public class HorizontalViewCardPanel extends ViewCardPanel {
    private Point origin = null;
    
    public HorizontalViewCardPanel(Player _player,boolean _isMirror){
        super(_player,_isMirror);
        super.setImage_dir("/tichu/images/horizontal/");
        this.setMaximumSize(new Dimension(800, 150));
        this.setPreferredSize(new Dimension(800, 150));
        this.addCards();
    }
    
    public HorizontalViewCardPanel(boolean _isMirror, Dimension theSize){
        super(_isMirror);
        super.setImage_dir("/tichu/images/horizontal/");
        this.setMaximumSize(theSize);
        this.setPreferredSize(theSize);
        this.addOnlyCards();
    }

    
    public void resetLayers(){
        int i = 0;
        Component[] comps = this.getComponents();
        List<Component> comps_list = Arrays.asList(comps);
        Collections.reverse(comps_list);
        
        for(Component c : comps_list){
            if(c instanceof ViewCard){
                this.setLayer(c, i);
                i++;
            }
        }
    }
    
    public void setOrigin(Point p){
        origin = p;
        this.removeAll();
        super.revalidate();
        super.repaint();
        this.addCards();
    }
    
    public void resetAllCards(){
      for(Component c : getComponents()){
        if(c instanceof ViewCard){
            ((ViewCard) c).resetCard();
        }
      }
    }
    
    public Card getTheSelectedCard(){
        ArrayList<Card> cards = super.getSelectedCards();
        if(!cards.isEmpty()){
            return cards.get(0);
        }
        return null;
    }
    
    private void addOnlyCards(){
        int i = 0;
        origin = new Point(10, 20);
        ArrayList <Card> table = new ArrayList<>();
        for(int j =2; j<15; j++){
            SimpleCard tmp = new SimpleCard(i,j);
            table.add(tmp);
        }
        
        for(Card c : table){
            ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir(),this);
            super.add(card,new Integer(i++));
            origin.x += 25;
        }
    }
    
    @Override
    public void showCards(){
        //System.out.println("Horizontal showCards");
    }
    
    public void HideCards(){
        this.removeAll();
        super.revalidate();
        super.repaint();
        this.origin = null;
        int i = 1;
        if(origin == null){ origin = new Point(200, 0);}
        if(super.isIsMirror()) {
            origin.y = 5;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100 , origin.y + 10, 200, 20);
            super.add(name,new Integer(i++));
        }
        else {
            origin.y = 20;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
            try{
                super.add(name,new Integer(i++)); 
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        for(Card c : super.getPlayer().getPlayersHand()){
            ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            card.setCard_image(new ImageIcon(getClass().getResource("/tichu/images/back.jpg")));
            card.setNotMove(true);
            super.add(card,new Integer(i++));
            origin.x += 25;
        }
    }
    
    @Override
    public void changePlayer(Player p){
        super.setPlayer(p);
        super.removeAll();
        super.revalidate();
        super.repaint();
        super.name.setText(p.getName());
        origin = new Point(200, 0);
        this.addCards();
    }
    
    private void addCards(){
        int i = 1;
        if(origin == null){ origin = new Point(200, 0);}
        if(super.isIsMirror()) {
            origin.y = 5;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100 , origin.y + 10, 200, 20);
            super.add(name,new Integer(i++));
        }
        else {
            origin.y = 20;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
            try{
                super.add(name,new Integer(i++)); 
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        for(Card c : super.getPlayer().getPlayersHand()){
            ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 25;
        }
    }

    public void setCards(CardCombination cb) {
        System.out.println("called : ");
        super.removeAll();
        super.revalidate();
        super.repaint();
        if(cb == null){ return; }
        int i = 0;
        Point or = new Point(10,0);
        for(Card c : cb.getCards()){
            ViewCard card = new ViewCard(c,or,Direction.DOWN,super.getImage_dir());
            card.setNotMove(true);
            System.out.println(card.getCard().toString());
            super.add(card,new Integer(i++));
            or.x += 25;
        }
        System.out.println("------------------------");
    }
}
