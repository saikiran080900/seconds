package com.example.player.repository;

import java.util.ArrayList;
import com.example.player.model.Player;

public interface PlayerRepository {
    ArrayList<Player> getPlayers();

    Player getPlayerId(int playerId);

    Player addPlayer(Player,player);

    Player uodatePlayer(int playerId, Player player);

    void deletePlayer(int playerId);
}