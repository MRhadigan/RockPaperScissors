package RockPaperScissors;

public class Dummy extends Player{

	public Dummy() {
		super();
	}

	@Override
	public Roshambo generateRoshambo() {
		
		return Roshambo.ROCK;
	}

	@Override
	public Roshambo generateRoshambo(String userInput) {
	
		return null;
	}

}
