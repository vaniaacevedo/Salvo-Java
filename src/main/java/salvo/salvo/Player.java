package salvo.salvo; //packages are a way to collect related classes together.


//to save instances of the class in a persistent database
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;




/*Then we import and apply several JPA annotations to connect the class to a database table.

 The annotation @Entity tells Spring to create a person table for this class.
 The annotation @Id says that the id instance variable holds the database key for this class.
 The annotation @GeneratedValue tells JPA to get the Id from the DBMS.*/

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id; //long is used for numbers which can be very large
    private String userName;

    //constructors do not have return types and they must have the name of their class.

    public Player () { } //constructor with no arguments

    public Player (String userName) { //constructor with arguments
        this.userName = userName;

    }

    public String getUserName() { //methods of the class to access the properties assigned to the class
        return userName;
    }

    public void setUserName(String userName) { //void means that doesn't return anything
        this.userName = userName;
    }

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    public void addGamePlayer( GamePlayer gamePlayer) {
        gamePlayer.setPlayer(this);
        gamePlayers.add(gamePlayer);
    }
    @JsonIgnore
    public List<Game> getGames() {
        return gamePlayers.stream().map(sub -> sub.getGame()).collect(toList());
    }


    public long getId() {
        return id;
    }
}
