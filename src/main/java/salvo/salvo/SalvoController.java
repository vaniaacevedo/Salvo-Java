package salvo.salvo;


import org.springframework.beans.factory.annotation.Autowired;
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

    private GameRepository repo;

    @RequestMapping("/games")
    public List<Object> getAll() {
        return repo.findAll().stream().map(game -> makeGamesDTO(game)).collect(Collectors.toList()); //to create the array displaying all the objects
    }

    private Map<String, Object> makeGamesDTO(Game game) { // to create the map with the key/value pairs of the games
        Map<String, Object> dto = new LinkedHashMap<String,Object>();
        dto.put("id", game.getId());
        dto.put("date",game.getDate());


        List<Map<String, Object>> gamePlayers = game.getGamePlayers().stream().map(gamePlayer -> makeGamePlayerDTO(gamePlayer)).collect(Collectors.toList()); // nested array

        dto.put("gamePlayers",gamePlayers);// variable holding the list that displays the information important to gameplayers
        return dto;
    }

    private Map<String, Object> makeGamePlayerDTO(GamePlayer gamePlayer) {
        Map<String, Object> dto = new LinkedHashMap<String,Object>();
        dto.put("id",gamePlayer.getId());
        dto.put("player",makePlayerDTO(gamePlayer.getPlayer()));

        return dto;
    }

    private Map<String, Object> makePlayerDTO(Player player) {
        Map<String, Object> dto = new LinkedHashMap<String,Object>();
        dto.put("id",player.getId());
        dto.put("email" , player.getUserName());
        return dto;

    }

}