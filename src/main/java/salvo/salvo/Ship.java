package salvo.salvo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Ship {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String shipType;


    @ElementCollection
    @Column(name="location")
    private List<String> locations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gamePlayer_id")
    private GamePlayer gamePlayer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public Ship (){}

    public Ship(GamePlayer gamePlayer, String shipType, List<String> locations) {
        this.gamePlayer = gamePlayer;
        this.shipType = shipType;
        this.locations= locations;

    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }


}
