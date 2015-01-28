/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tichu.Cards.Card;

public class ViewCard extends JLabel implements MouseListener{
    
    private ImageIcon card_image;
    private Card  card;
    private boolean raised;
    private Dimension size;
    private Point origin;
    private Direction direction;
    private boolean notMove;
    
    private HorizontalViewCardPanel parent = null;
    
    public ViewCard(Card _card,Point _origin, Direction _direction,String imagepath){
        this.card = _card;
        this.notMove = false;
        this.direction = _direction;
        this.raised = false;
        this.origin = new Point(_origin.x , _origin.y);
        this.card_image = new ImageIcon(getClass().getResource(imagepath + _card.toString()));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, false));
        this.size = new Dimension((getCard_image().getImage().getWidth(null) * 8) / 10, 
                                   (getCard_image().getImage().getHeight(null) * 8) /10);
        this.setBounds(this.origin.x, this.origin.y, this.size.width, this.size.height);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }
    
    public ViewCard(Card _card,Point _origin, Direction _direction,String imagepath, HorizontalViewCardPanel _parent){
        this.card = _card;
        this.notMove = true;
        parent = _parent;
        this.direction = _direction;
        this.raised = false;
        this.origin = new Point(_origin.x , _origin.y);
        this.card_image = new ImageIcon(getClass().getResource(imagepath + _card.toString()));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, false));
        this.size = new Dimension((getCard_image().getImage().getWidth(null) * 8) / 10, 
                                   (getCard_image().getImage().getHeight(null) * 8) /10);
        this.setBounds(this.origin.x, this.origin.y, this.size.width, this.size.height);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getCard_image().getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
    }

    /**
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.isNotMove()){
            if(this.parent != null){
                this.parent.resetAllCards();
                moveCard(0);             
            }
            return;
        }
        moveCard(0);

    }

    public void resetCard(){
        this.setBounds(origin.x , origin.y, size.width, size.height);
        raised = false;
    }
    
    private void moveCard(int points){
        if(isRaised()){
            this.setBounds(origin.x , origin.y, size.width, size.height);
            raised = false;
        }
        else{
            this.setBounds(origin.x + this.direction.getPoint().x, origin.y + this.direction.getPoint().y + points, size.width, size.height);
            raised = true;
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * @return the notMove
     */
    public boolean isNotMove() {
        return notMove;
    }

    /**
     * @param notMove the notMove to set
     */
    public void setNotMove(boolean notMove) {
        this.notMove = notMove;
    }

    /**
     * @return the card_image
     */
    private ImageIcon getCard_image() {
        return card_image;
    }

    /**
     * @param card_image the card_image to set
     */
    public void setCard_image(ImageIcon card_image) {
        this.card_image = card_image;
    }

    /**
     * @return the raised
     */
    public boolean isRaised() {
        return raised;
    }
    

}
