package services;

import exceptions.InvalidOperationException;
import models.Game;
import models.Player;
import repositories.GameDB;

import java.util.Scanner;

/**
 * This game service is a class which is going to contain game related logics
 */

public class GameService {

    GameDB gameDB;

    public GameService(){
        this.gameDB = new GameDB();
    }

    public Game processGame(Game game, Scanner scn){
        Character [][] board = game.getBoard();
        int [] rows = game.getRow();
        int [] cols = game.getCol();
        Player curr = game.getPlayer1();
        char currCh = 'X';
        Player next = game.getPlayer2();
        char nextCh = 'O';
        int oprCount = 0;
        while(oprCount < 9){
            System.out.println(String.format("%s please enter the value of row and col", curr.getPlayerName()));
            System.out.print(String.format("%s please enter row value", curr.getPlayerName()));
            int row = scn.nextInt();
            System.out.print(String.format("%s please enter col value", curr.getPlayerName()));
            int col = scn.nextInt();
            if(row < 0  || row >= 3 || col < 0 || col >= 3 || board[row][col] != null){
                throw new InvalidOperationException(String.format("%s has made wrong move", curr.getPlayerName()));
            }
            board[row][col] = currCh;
            rows[row] += (currCh == 'X' ? 1 : -1);
            cols[col] += (currCh == 'O' ? 1 : -1);
            if(row == col){
                game.setDig(game.getDig() + (currCh == 'X' ? 1 : -1));
            }
            if((row + col) == 2){
                game.setAntiDig(game.getAntiDig() + (currCh == 'X' ? 1 : -1));
            }

            if(Math.abs(rows[row]) == 3 || Math.abs(cols[col]) == 3 || Math.abs(game.getDig()) == 3 || Math.abs(game.getAntiDig()) == 3){
                game.setState("FINISHED");
                game.setWinner(curr);
                return game;
            }

            Player temp = curr;
            curr = next;
            next = temp;

            char tempCh = currCh;
            currCh = nextCh;
            nextCh = tempCh;
            oprCount++;
        }
        game.setState("TIED");
        return game;
    }

}
