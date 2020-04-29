package se.lexicon.model;

import java.util.Arrays;

public class Player {
    private String name;
    private int strength;
    private int maxLife;
    private int life;
    private int score;
    private String[] history;

    public Player(String name, int strength, int maxLife) {
        this.name = name;
        this.maxLife = maxLife;
        this.strength = strength;
        history = new String[0];
        setLife(maxLife);
    }

    public boolean isAlive(){
        return life > 0;
    }

    public int attack(int random){
        return strength + random;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String[] getHistory() {
        return history;
    }

    public void addBattleHistory(String battleHistory){
        String[] temp = Arrays.copyOf(history, history.length+1);
        temp[temp.length-1] = battleHistory;
        this.history = temp;
    }

}
