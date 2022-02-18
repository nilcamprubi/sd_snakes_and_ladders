package seconddesign;

import java.util.LinkedList;

public final class Game {
	private LinkedList<Player> players = new LinkedList<Player>();
	private Board board = null;
	private Player winner;

	public Game(String[] playerNames, int numSquares, 
			int[][] snakes, int[][] ladders) {

		makeBoard(numSquares, ladders, snakes);
		makePlayers(playerNames);
	}
	
	private void makeBoard(int numSquares, int[][] ladders, int[][] snakes) {
		board = new Board(numSquares,ladders,snakes);		
	}
	
	private void makePlayers(String[] playerNames) {
		assert playerNames.length>0 : "There must be some player" ;
		System.out.println("Players are : ");
		int i=1;
		for (String str : playerNames) {
			Player player = new Player(str);
			players.add(player);
			System.out.println(i + ". " + str);
			i++;
		}
	}

	public void play() {
		play(Integer.MAX_VALUE);
	}

	public boolean play(int maxNumRounds) {
		assert !players.isEmpty() : "No players to play";
		assert board!=null : "No scoreboard to play";
		
		Die die = new Die();
		startGame();

		System.out.println("Initial state : \n" + this);
		System.out.println("Initial state : \n" + this);
		int numRounds = 0;
		while (notOver() && (numRounds < maxNumRounds)) {
			int roll = die.roll();
			System.out.println("Current player is " + currentPlayer() + " and rolls " + roll);
			movePlayer(roll);
			System.out.println("State : \n" + this);
			numRounds++;
		}
		boolean finished = ! notOver();
		if (finished) {
			System.out.println(winner + " has won in " + numRounds + " rounds");
		} else {
			System.out.println("nobody has won after " + numRounds + " rounds");
		}
		return finished;
	}
	
	private void startGame() {
		placePlayersAtFirstSquare();
		winner = null;		
	}
	
	private void placePlayersAtFirstSquare() {
		for (Player player : players) {
			board.firstSquare().enter(player);
		}
	}
	
	private boolean notOver() {
		return winner == null;
	}
	
	
	private final class Die {
		private static final int MINVALUE = 1;
		private static final int MAXVALUE = 6;
		
		public int roll() {
			return random(MINVALUE,MAXVALUE);
		}
		
		private int random(int min, int max) {
			assert min<max;
			return (int) (min + Math.round((max-min) * Math.random()));
		}
	}
	
	private void movePlayer(int roll) {
		Player currentPlayer = players.remove(); // the first element of the list
		currentPlayer.moveForward(roll);
		players.add(currentPlayer); // to the end of list, we're using the linked list as a queue
		if (currentPlayer.wins()) {
			winner = currentPlayer;
		}
	}
	
	@Override
	public String toString() {
		String str = new String();
		for (Player player : players) {
			str += player.getName() + " is at square " + (player.position()+1) + "\n"; 
		}
		return str;
	}

	Player currentPlayer() {
		assert players.size()>0;
		return players.peek();
	}
}
