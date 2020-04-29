package se.lexicon.battle;

import se.lexicon.model.Player;
import se.lexicon.util.NumberGenerator;

public class Round {
    public static final String PLAYER_WIN = "player";
    public static final String OPPONENT_WIN = "opponent";
    public static final String DRAW = "draw";

    private String roundLog;
    private int roundNumber;

    public Round(int roundNumber) {
        this.roundNumber = roundNumber;
        roundLog = "--Round " + this.roundNumber + "--\n";
    }

    public String playRound(Player player, Player opponent){
        String outcome;
        StringBuilder stringBuilder = new StringBuilder(roundLog);
        int playerRoll = NumberGenerator.generateInt(1, 6);
        int opponentRoll = NumberGenerator.generateInt(1, 6);
        int playerAttack = player.attack(playerRoll);
        int opponentAttack = opponent.attack(opponentRoll);

        if(playerAttack > opponentAttack){
            opponent.setLife(opponent.getLife() - player.getStrength());
            stringBuilder.append(player.getName() + " dealt " + player.getStrength() + " damage to " + opponent.getName());
            outcome = PLAYER_WIN;
        }else if(playerAttack < opponentAttack){
            player.setLife(player.getLife() - opponent.getStrength());
            stringBuilder.append(opponent.getName() + " dealt " + opponent.getStrength() + " damage to " + player.getName());
            outcome = OPPONENT_WIN;
        }else {
            stringBuilder.append("The round is a draw between " + player.getName() + " and "+ opponent.getName());
            outcome = DRAW;
        }
        stringBuilder.append("\n");
        stringBuilder.append("--End of round " + roundNumber + "--\n");
        roundLog = stringBuilder.toString();
        return outcome;
    }

    public String getRoundLog() {
        return roundLog;
    }
}
