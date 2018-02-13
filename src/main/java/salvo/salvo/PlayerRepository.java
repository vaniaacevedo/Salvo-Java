package salvo.salvo;

//imported and added the annotation @RepositoryRestResource and Spring Boot did the rest of the work

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource; //the yellow is the class


@RepositoryRestResource // we can see the data as a readable url
//the annotation @RepositoryRestResource turns PlayerRepository into a Rest Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}


//A Java interface is like a class, but it has no fields and does not include code for any methods