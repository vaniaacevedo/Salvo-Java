package salvo.salvo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//JPA makes it fairly easy to specify how simple Java classes map to tables and columns in a database.
//A Repository class is analogous to a table, i.e., it is a class that manages a collection of instances.
@RepositoryRestResource


public interface GameRepository extends JpaRepository<Game, Long> {
}
