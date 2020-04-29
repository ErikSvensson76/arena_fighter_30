package se.lexicon;


import se.lexicon.battle.Battle;
import se.lexicon.model.Player;
import se.lexicon.util.NumberGenerator;

import java.util.Scanner;

public class App
{

    public static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {
        boolean playing = true;
        while (playing){
            System.out.println("Arena fighter 0.1beta");
            System.out.println("1. Play the game");
            System.out.println("Q. Quit");
            switch (scanner.nextLine().trim().toUpperCase()){
                case "1":
                    play();
                    break;
                case "Q":
                    playing = false;
                    break;
                default:
                    System.out.println("Unrecognized input");
            }
        }
    }

    public static void play(){
        boolean playing = true;
        Player player = null;
        while(playing){
            if(player == null){
                System.out.println("Enter your character name: ");
                String name = scanner.nextLine().trim();
                player = createPlayer(name, NumberGenerator.generateInt(1,10));
            }
            System.out.println(getPlayerDetails(player));
            System.out.println("1. enter the arena");
            System.out.println("Q. retire");
            switch (scanner.nextLine().toUpperCase()){
                case "1":
                    Player opponent = createPlayer("Opponent", NumberGenerator.generateInt(1,8));
                    Battle battle = new Battle(player, opponent);
                    boolean alive = battle.battle();
                    System.out.println(battle.getBattleLog());
                    if(alive){
                        player.addBattleHistory(battle.getBattleLog());
                    }else {
                        System.out.println("You are dead");
                        playing = false;
                    }
                    break;
                case "Q":
                    playing = false;
                    break;
            }

        }
    }

    private static String getPlayerDetails(Player player) {
        String details = "Strength: " + player.getStrength() + "\n"
                + "Life: " + player.getLife() + "\n"
                + "Score: " + player.getScore() + "\n"
                + "History: " + "\n";

        if(player.getHistory().length == 0){
            details = details + "No battles yet";
        }else {
            StringBuilder sb = new StringBuilder();
            for(String log : player.getHistory()){
                sb.append(log+"\n");
            }
            details = details + sb.toString();
        }
        return details;
    }

    public static Player createPlayer(String name, int strength) {
        int maxLife = strength * 3;
        return new Player(name, strength, maxLife);
    }
}
