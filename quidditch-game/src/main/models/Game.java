package src.main.models;

import java.util.HashMap;

public class Game {

    private HashMap<Team, Integer> scoreBoard;

    public Game(Team home, Team away) {
        this.scoreBoard = new HashMap<Team, Integer>();

        scoreBoard.put(new Team(home), 0);
        scoreBoard.put(new Team(away), 0);

    }

    public Integer getScore(Team team) {
        return scoreBoard.get(team);
    }

    public void setScore(Team team, Integer score) {
        scoreBoard.put(team, score);
    }

}
