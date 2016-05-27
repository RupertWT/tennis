package com.rupert.tennis;

import com.rupert.tennis.TennisGame4;

public class TennisGame4 implements TennisGame {
  
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;
	private static final String[] TENNIS_SCORE = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 

    
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
        if (checkIfNeitherPlayerHasReachedAScoreOfForty()) {
            return preFortyScores();
        } 
        
        if (player1Score == player2Score) {
        	return "Deuce";
        }
        
        return postFortyScores();
    }

	private boolean checkIfNeitherPlayerHasReachedAScoreOfForty() {
		return (player1Score < 4 && player2Score < 4 && (player1Score + player2Score != 6));
	}
   
	private String preFortyScores() {
		return (player1Score != player2Score) ? TENNIS_SCORE[player1Score] + "-" + TENNIS_SCORE[player2Score] : TENNIS_SCORE[player1Score] + "-All" ;
	}
	
	private String postFortyScores() {
		String leadingPlayer = player1Score > player2Score ? player1Name : player2Name;
		return (Math.abs(player1Score-player2Score) > 1) ? "Win for " + leadingPlayer : "Advantage " + leadingPlayer ;
	}
}