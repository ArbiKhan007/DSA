package controllers;

import models.Player;
import services.GameService;
import services.PlayerService;

import java.util.Scanner;

/**
 * This game controller class will be the starting point of our game.
 * This class will be responsible for taking the user input and begin the game.
 */
public class GameController {

    Scanner scn;
    GameService gameService;
    PlayerService playerService;

    public GameController(){
        this.scn = new Scanner(System.in);
        this.gameService = new GameService();
        this.playerService = new PlayerService();
    }



    public Player takePlayerDetailsInput(int playeNum){
        System.out.println(String.format("Enter details for player%d: ", playeNum));
        System.out.print(String.format("Player%d: Are you a already registered user ? (Yes/No) : ", playeNum));
        String playerResp = scn.next();
        if (playerResp.equals("Yes")){
            System.out.print(String.format("Player%d: Please enter your emailId: ", playeNum));
            String p1EmailResp = scn.next();
            System.out.println();
            // We should get player details from our storage class.
        }else{
            System.out.print(String.format("Player%d: Please enter your Name: ", playeNum));
            String name = scn.next();
            System.out.println();
            System.out.print(String.format("Player%d: Please enter your email: ", playeNum));
            String email = scn.next();
            System.out.println();
            Player player = new Player();
            player.setPlayerName(name);
            player.setEmailId(email);
            return player;
        }
    }

    // 0 or 1

    public boolean toss(){
        int max = 1;
        int min = 0;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return rand == 0;
    }

    public void startGame(){
        // I want this program to run infinitely.
        // If a game will end a new game will begin.

        while(true){
            System.out.println("Welcome to AccioJob TicTacToe Game !!");
            System.out.println("Please enter details for Players");
            Player p1 = this.takePlayerDetailsInput(1);
            Player p2 = this.takePlayerDetailsInput(2);
            boolean tossRes = this.toss();
            Player f;
            Player s;
            if(tossRes){
                f = p1;
                s = p2;
            }else{
                f = p2;
                s = p1;
            }
            System.out.println(String.format("%s won the toss", f.getPlayerName()));
        }
    }
}
