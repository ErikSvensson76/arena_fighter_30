package se.lexicon.battle;

import se.lexicon.model.Player;

public class Battle {
    private String battleLog;
    private Player player;
    private Player opponent;

    public Battle(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
        battleLog = "";
    }

    public String getBattleLog() {
        return battleLog;
    }

    public boolean battle(){

        int roundNumber = 1;
        int wonRounds = 0;
        appendRoundLog("**Battle starts between " + player.getName() + " VS " + opponent.getName() +"**\n");
        while(player.isAlive() && opponent.isAlive()){
            Round round = new Round(roundNumber);
            String outcome = round.playRound(player, opponent);
            appendRoundLog(round.getRoundLog());
            roundNumber++;
            if(outcome.equals(Round.PLAYER_WIN)){
                wonRounds++;
            }
        }
        if(player.isAlive()){
            appendRoundLog("**" + player.getName() + " wins the battle against " + opponent.getName()+ "**\n");
            int score = opponent.getStrength() + wonRounds;
            player.setScore(player.getScore() + score);
            player.setLife(player.getMaxLife());
        }else {
            appendRoundLog("**" + player.getName() + " lost the battle against " + opponent.getName() +" RIP**\n");
        }

        return player.isAlive();
    }

    void appendRoundLog(String roundLog){
        StringBuilder stringBuilder = new StringBuilder(battleLog);
        stringBuilder.append(roundLog);
        battleLog = stringBuilder.toString();
    }
}
