package models;

public class Player {
    private int id;
    private String playerName;
    private String emailId;

    public Player(int id, String playerName, String emailId) {
        this.id = id;
        this.playerName = playerName;
        this.emailId = emailId;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
