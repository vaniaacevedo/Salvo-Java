package salvo.salvo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class SalvoController {

    @Autowired

    private GamePlayerRepository gamePlayerRepository;

    @Autowired

    private GameRepository gameRepository;

    @RequestMapping("/games")
    public List<Object> getAll() {
        return gameRepository.findAll().stream().map(game -> makeGamesDTO(game)).collect(Collectors.toList()); //to create the array displaying all the objects
    }

    private Map<String, Object> makeGamesDTO(Game game) { // to create the map with the key/value pairs of the games
        Map<String, Object> makeGames = new LinkedHashMap<String,Object>();
        makeGames.put("id", game.getId());
        makeGames.put("date",game.getDate());


        List<Map<String, Object>> gamePlayers = game.getGamePlayers().stream().map(gamePlayer -> makeGamePlayerDTO(gamePlayer)).collect(Collectors.toList()); // nested array

        makeGames.put("gamePlayers",gamePlayers);// variable holding the list that displays the information important to gameplayers
        return  makeGames;
    }

    private Map<String, Object> makeGamePlayerDTO(GamePlayer gamePlayer) {
        Map<String, Object> makeGamePlayer = new LinkedHashMap<String,Object>();
        makeGamePlayer .put("id",gamePlayer.getId());
        makeGamePlayer .put("player",makePlayerDTO(gamePlayer.getPlayer()));

        return makeGamePlayer ;
    }

    private Map<String, Object> makePlayerDTO(Player player) {
        Map<String, Object> makePlayer= new LinkedHashMap<String,Object>();
        makePlayer.put("id",player.getId());
        makePlayer.put("email" , player.getUserName());
        return makePlayer;

    }

    @RequestMapping("/game_view/{gamePlayerId}")
    public Map<String, Object> getGameView(@PathVariable Long gamePlayerId) {
        return makeGamesViewDTO(gamePlayerRepository.findGamePlayerById(gamePlayerId));
    }


    private Map<String, Object> makeGamesViewDTO(GamePlayer activeGamePlayer) {
        Map<String, Object> makeGamesView = makeGamesDTO(activeGamePlayer.getGame());

        List<Map<String, Object>> gameShips = activeGamePlayer.getShips().stream().map(ship -> makeShipsDTO(ship)).collect(Collectors.toList()); // nested array
        makeGamesView.put("ships", gameShips);
        return makeGamesView;
    }

    private Map<String, Object> makeShipsDTO(Ship ship) {
        Map<String, Object> makeShips = new LinkedHashMap<String,Object>();
        makeShips.put("type",ship.getShipType());
        makeShips.put("location",ship.getLocations());

        return makeShips;
    }


}