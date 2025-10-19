package repositories;

import models.Player;

import java.util.HashMap;
import java.util.Optional;

public class PlayerDB {

    HashMap<String, Player> playerHashMap;

    public PlayerDB(){
        this.playerHashMap = new HashMap<>();
    }

    public Player getPlayerById(String id){
        return playerHashMap.get(id);
    }

    public void savePlayer(String id, Player player){
        playerHashMap.put(id, player);
    }

    public int generateNextId(){
        return playerHashMap.size() + 1;
    }

}
