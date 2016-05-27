package com.rupert.tennis;

import com.rupert.tennis.TennisGame4;

public class TennisGame4 implements TennisGame {
  
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisGame4(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
    	if (playerName == player1Name) {
            this.player1Score += 1;
        } else {
            this.player2Score += 1;
        }
    }    
    
    public String getScore() { 	   	
        if (checkIfEitherPlayerHasReached40()) {
            return pre40Scores();
        } else if (player1Score == player2Score) {
        	return "Deuce";
        } else {
            return post40Scores();
        }
    }

	private boolean checkIfEitherPlayerHasReached40() {
		if (player1Score < 4 && player2Score < 4 && !(player1Score + player2Score == 6)) {
			return true;
		}
		return false;
	}
   
	private String pre40Scores() {
		String[] tennisScore = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
		return (player1Score != player2Score) ? tennisScore[player1Score] + "-" + tennisScore[player2Score] : tennisScore[player1Score] + "-All" ;
	}
	
	private String post40Scores() {
		String leadingPlayer;
		leadingPlayer = player1Score > player2Score ? player1Name : player2Name;
		return (Math.abs(player1Score-player2Score) == 1) ? "Advantage " + leadingPlayer : "Win for " + leadingPlayer;
	}
}