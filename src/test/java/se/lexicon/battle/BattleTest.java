package se.lexicon.battle;

import org.junit.Test;
import se.lexicon.model.Player;

import static org.junit.Assert.*;

public class BattleTest {

    @Test
    public void given_player_and_maxi_battle_return_false_and_battleLog_notEmpty(){
        Player player = new Player("player", 1, 3);
        Player maxi = new Player("maxi", 7, 21);

        Battle battle = new Battle(player, maxi);

        assertFalse(battle.battle());
        assertFalse(battle.getBattleLog().isEmpty());
    }

    @Test
    public void given_player_and_mini_battle_return_true_and_battleLog_and_score_added_to_player(){
        Player player = new Player("player", 7, 21);
        Player mini = new Player("mini", 1, 3);

        int expectedPlayerScore = 2;

        Battle battle = new Battle(player, mini);

        assertTrue(battle.battle());
        assertEquals(expectedPlayerScore, player.getScore());

    }

}
