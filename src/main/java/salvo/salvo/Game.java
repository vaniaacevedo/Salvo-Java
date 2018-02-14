package salvo.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


@Entity

public class Game {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id; //long is used for numbers which can be very large

    private Date date;


    public Game () { } //constructor with no arguments

    public Game ( Date date) { //constructor with arguments
        this.date = date;

    }

    public Date getDate() { //methods of the class to access the properties assigned to the class
        return date;
    }


    public void setDate( Date date) { //void means that doesn't return anything
        this.date = date;
    }

    public long getId() {
        return id;
    }

    @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    public void addGamePlayer( GamePlayer gamePlayer) {
        gamePlayer.setGame(this);
        gamePlayers.add(gamePlayer);
    }
    @JsonIgnore

    public List<Player> getPlayers() {
        return gamePlayers.stream().map(sub -> sub.getPlayer()).collect(toList());
    }


    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }
}
