/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import tichu.Cards.Card;
import tichu.Cards.Mahjong;
import tichu.Combinations.CardCombination;
import tichu.Combinations.CardSet;
import tichu.Game.Player;
import tichu.Game.TICHU;

/**
 *
 * @author Dimitris
 */
public class CenterPanel extends javax.swing.JPanel {

    /**
     * Creates new form CenterPanel
     */
    private TICHU game;
    private HorizontalViewCardPanel panel;
    private int playersCount = 0;
    private Player p;
    private PlayersPanel f;
    
    public CenterPanel(TICHU _game , PlayersPanel theFrame) {
        initComponents();
        game = _game;
        f = theFrame;
        p = this.game.getFirstTeam().getP1();
        panel = new HorizontalViewCardPanel(p, false);
        panel.setMaximumSize(new Dimension(400, 150));
        panel.setPreferredSize(new Dimension(400, 150));
        panel.setOrigin(new Point(100,0));
        panel.changeCurrentPlayerColor();
        this.wishcard.setVisible(false);
        this.jPanel1.setOpaque(false);
        this.jPanel1.setVisible(true);
        this.jPanel1.setLayout(new BorderLayout());
        this.jPanel1.add(panel,BorderLayout.CENTER);
    }

    
    public void clearAll(){

    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon back = new ImageIcon(getClass().getResource("/tichu/images/tichu.jpg"));
        g.drawImage(back.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    public void showMahjongPanel(Card c, Player p){
        System.out.println("called " + p.getName());
        panel = new HorizontalViewCardPanel(false,new Dimension(400, 150));
        this.jPanel1.add(panel , BorderLayout.CENTER);
        this.wishcard.setVisible(true);
        this.wishcard.setEnabled(true);
    }
    
    private void changeThePlayer(){
        playersCount++;
        
        switch(playersCount){
            case 1:
                p = this.game.getSecondTeam().getP1();
                panel = new HorizontalViewCardPanel(p,false);
                break;
            case 2:
                p = this.game.getFirstTeam().getP2();
                panel = new HorizontalViewCardPanel(p,false);
                break;
            case 3:
                p = this.game.getSecondTeam().getP2(); 
                panel = new HorizontalViewCardPanel(p,false);
                break;
            case 4:
                skip.setEnabled(false);
                grand.setEnabled(false);
                grand.setVisible(false);
                skip.setVisible(false);
            default:
                break;
        }
        this.jPanel1.removeAll();
        if(playersCount < 4){
            panel.setOrigin(new Point(100,0));
            this.jPanel1.add(panel,BorderLayout.CENTER);
        }
        
        if(playersCount == 4){
            f.drawTheOtherCards();
        }
        
        this.jPanel1.revalidate();
        this.jPanel1.repaint();
        
    }
    
    public void setCards(CardCombination comb){
        System.out.println("set CARDS Center panel -> ");
        this.panel.setCards(comb);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grand = new javax.swing.JButton();
        skip = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        wishcard = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        grand.setText("Grand");
        grand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grandActionPerformed(evt);
            }
        });

        skip.setText("Skip");
        skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        wishcard.setText("Select Wishcard");
        wishcard.setEnabled(false);
        wishcard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wishcardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(wishcard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(grand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skip, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skip)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(grand)
                        .addComponent(wishcard)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void grandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandActionPerformed
        // TODO add your handling code here:
        p.setSaidGrandTichu(true);
        changeThePlayer();
    }//GEN-LAST:event_grandActionPerformed

    private void skipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipActionPerformed
        // TODO add your handling code here:
        changeThePlayer();
    }//GEN-LAST:event_skipActionPerformed

    private void wishcardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wishcardActionPerformed
        // TODO add your handling code here:
        Card c = panel.getTheSelectedCard();
        ArrayList<Card> tmp= new ArrayList<>();
        tmp.add(c);
        
        
        if(c != null){
            try {
                ArrayList<Card> maj = new ArrayList<>();
                maj.add(new Mahjong());
                this.wishcard.setVisible(false);
                this.wishcard.setEnabled(false);
                CardCombination cb = new CardSet(maj);
                System.out.println("wishcardActionPerformed called " + game.getState());
                game.PlayersAction(p, cb, c.getValue());
            } catch (Exception ex) {
                Logger.getLogger(CenterPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_wishcardActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton grand;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton skip;
    private javax.swing.JButton wishcard;
    // End of variables declaration//GEN-END:variables
}