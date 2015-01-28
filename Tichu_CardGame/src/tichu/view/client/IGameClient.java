/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.client;

import tichu.Combinations.CardCombination;
import tichu.Game.Player;


/**
 *
 * @author Dimitris
 */
public interface IGameClient {
    public Player showTheMpazaWindow();
    public void skipPlayer();
    public void changePlayer(CardCombination comb);
    public void newRound();
    public void showWinnerPanel(String _winner);
}
