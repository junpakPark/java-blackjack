package domain;

import java.util.HashMap;
import java.util.Map;

import domain.participant.Dealer;
import domain.participant.Player;
import domain.result.Result;

public class PlayerResult {
    private Map<String, Result> playerResult;

    public PlayerResult() {
        playerResult = new HashMap<>();
    }

    public void deduceResult(GameParticipant participant) {
        Dealer dealer = participant.getDealer();
        Players players = participant.getPlayers();
        for (Player player : players.getPlayers()) {
            playerResult.put(player.getName(), player.beatDealer(dealer));
        }
    }

    public Map<String, Result> getResult() {
        return playerResult;
    }
}