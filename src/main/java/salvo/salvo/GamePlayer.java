package salvo.salvo;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;


    @OneToMany(mappedBy="gamePlayer", fetch=FetchType.EAGER)
    Set<Ship> ships= new HashSet<>();

    public GamePlayer() { }

    public GamePlayer( Player player, Game game, Date date) {
        this.player = player;
        this.game = game;
        this.date = date;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public long getId() {
        return id;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    public void addShip( Ship ship) {
        ship.setGamePlayer(this);
        this.ships.add(ship); // why this?
    }



}


