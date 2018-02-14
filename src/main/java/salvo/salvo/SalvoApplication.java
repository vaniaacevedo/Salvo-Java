package salvo.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;


@SpringBootApplication //annotation
public class SalvoApplication {

	//My main file from which the other classes will be called
	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);

	}

	@Bean
	//In Java, a bean is just a normal Java class, written to follow a few important rules.
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository) {
		return (args) -> {

			Player tony= new Player(); //creates an instance of the class Player
			tony.setUserName("t.almeida@ctu.gov");
			playerRepository.save(tony);

			Player chloe= new Player(); //creates an instance of the class Player
			chloe.setUserName("c.obrian@ctu.gov");
			playerRepository.save(chloe);

			Player jack= new Player(); //creates an instance of the class Player
			jack.setUserName("j.bauer@ctu.gov");
			playerRepository.save(jack);

			Player kim= new Player(); //creates an instance of the class Player
			kim.setUserName("kim_bauer4@gmail.com");
			playerRepository.save(kim);

			 //save a couple of players in a playerRepository while creating several instances of the class Player
//			playerRepository.save(new Player("jake1@hotmail.com"));
//

			Date date =new Date();


			Game game1= new Game();
			game1.setDate(Date.from(date.toInstant().minusSeconds(3600)));
			gameRepository.save(game1);

			Game game2= new Game();
			game2.setDate(Date.from(date.toInstant().minusSeconds(2*3600)));
			gameRepository.save(game2);

			Game game3= new Game();
			game3.setDate(Date.from(date.toInstant().minusSeconds(3*3600)));
			gameRepository.save(game3);

			Game game4= new Game();
			game4.setDate(Date.from(date.toInstant().minusSeconds(4*3600)));
			gameRepository.save(game4);

			Game game5= new Game();
			game5.setDate(Date.from(date.toInstant().minusSeconds(5*3600)));
			gameRepository.save(game5);

			Game game6= new Game();
			game6.setDate(Date.from(date.toInstant().minusSeconds(6*3600)));
			gameRepository.save(game6);


//			gameRepository.save(new Game(date.toString()));
//			gameRepository.save(new Game(date.toString()));
//			gameRepository.save(new Game(date.toString()));


			GamePlayer gamePlayer= new GamePlayer(jack,game1,date);
			gamePlayerRepository.save(gamePlayer);

			GamePlayer gamePlayer2= new GamePlayer(chloe,game1,date);
			gamePlayerRepository.save(gamePlayer2);

			GamePlayer gamePlayer3= new GamePlayer(jack,game2,date);
			gamePlayerRepository.save(gamePlayer3);

			GamePlayer gamePlayer4= new GamePlayer(chloe,game2,date);
			gamePlayerRepository.save(gamePlayer4);

			GamePlayer gamePlayer5= new GamePlayer(tony,game3,date);
			gamePlayerRepository.save(gamePlayer5);

			GamePlayer gamePlayer6= new GamePlayer(chloe,game3,date);
			gamePlayerRepository.save(gamePlayer6);

			GamePlayer gamePlayer7= new GamePlayer(jack,game4,date);
			gamePlayerRepository.save(gamePlayer7);

			GamePlayer gamePlayer8= new GamePlayer(chloe,game4,date);
			gamePlayerRepository.save(gamePlayer8);

			GamePlayer gamePlayer9= new GamePlayer(tony,game5,date);
			gamePlayerRepository.save(gamePlayer9);

			GamePlayer gamePlayer10= new GamePlayer(jack,game5,date);
			gamePlayerRepository.save(gamePlayer10);

			GamePlayer gamePlayer11= new GamePlayer(kim,game6,date);
			gamePlayerRepository.save(gamePlayer11);








		};
	}


}