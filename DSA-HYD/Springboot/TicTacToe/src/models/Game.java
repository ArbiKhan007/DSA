package models;

import java.time.LocalDateTime;

public class Game {
    private int id;
    private String state = "IN-PROCESS";
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Player player1;
    private Player player2;
    private Player winner;
    private Character [][] board = new Character[3][3];
    private int [] row = new int[3];
    private int [] col = new int[3];
    private int dig = 0;
    private int antiDig = 0;

    public Game(int id, LocalDateTime startTime, LocalDateTime endTime, Player player1, Player player2, Player winner) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

    public Game() {
    }

    public Character[][] getBoard() {
        return board;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setBoard(Character[][] board) {
        this.board = board;
    }

    public int[] getRow() {
        return row;
    }

    public void setRow(int[] row) {
        this.row = row;
    }

    public int[] getCol() {
        return col;
    }

    public void setCol(int[] col) {
        this.col = col;
    }

    public int getDig() {
        return dig;
    }

    public void setDig(int dig) {
        this.dig = dig;
    }

    public int getAntiDig() {
        return antiDig;
    }

    public void setAntiDig(int antiDig) {
        this.antiDig = antiDig;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
