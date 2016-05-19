package com.rupert.tennis;

import com.rupert.tennis.TennisGame;

public interface TennisGame {
    void wonPoint(String playerName);
    String getScore();
}