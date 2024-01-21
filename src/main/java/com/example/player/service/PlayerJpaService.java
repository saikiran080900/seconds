package com.example.player.service;

import com.example.player.model.Player;
import com.example.player.repository.PlayerJpaRepository;
import com.example.player.repository.PlayerRepository;
import com.sun.xml.bind.annotation.OverrideAnnotationOf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class PlayerJpaService implements PlayerRepository {
    @Autowired
    public PlayerJpaRepository PlayerJpaRepository;

    @Override
    public ArrayList<Player> getPlayers() {
        List<Player> playerList = PlayerJpaRepository.findAll();
        ArrayList<Player> players = new ArrayList<>(playerList);
        return players;
    }

    @Override
    public Player getPlayerId(int playerId) {
        try {
            Player player = PlayerJpaRepository.findById(playerId).get();
            return player;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Player addPlayer(Player player) {
        PlayerJpaRepository.save(player);
        return player;
    }

    @Override
    public Player updatePlayer(int playerId, Player player) {
        try {
            Player newPlayer = PlayerJpaRepository.findById(playerId).get();
            if (player.getPlayerName() != null) {
                newPlayer.setPlayerName(player.getPlayerName());
            }
            if (player.getJerseyNumber() != 0) {
                newPlayer.setJerseyNumber(player.getJerseyNumber());
            }
            if (player.getRole() != null) {
                newPlayer.setRole(player.getRole());
            }
            PlayerJpaRepository.save(newPlayer);

            return newPlayer;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        try {
            PlayerJpaRepository.deleteById(playerId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
