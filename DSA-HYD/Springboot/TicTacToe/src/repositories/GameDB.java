package repositories;

import models.Game;

import java.util.HashMap;

/**
 * This class is responsible for storing game details.
 */
public class GameDB {

    private HashMap<Integer, Game> gameMap;

    public GameDB(){
        this.gameMap = new HashMap<>();
    }

    public void saveGame(int id, Game game){
        gameMap.put(id, game);
    }

    public int generateNextId(){
       return gameMap.size() + 1;
    }

    public Game getGameById(int id){
        return gameMap.get(id);
    }
}
