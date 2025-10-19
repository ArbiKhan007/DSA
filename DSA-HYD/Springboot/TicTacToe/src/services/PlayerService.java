package services;


import repositories.PlayerDB;

public class PlayerService {

    PlayerDB playerDB;

    public PlayerService(){
        this.playerDB = new PlayerDB();
    }


}
