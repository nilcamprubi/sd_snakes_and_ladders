package firstdesign;


public interface ISquare {

	/**
	 * @return  Returns the player.
	 * @uml.property  name="player" default="new primerDisseny.Player()"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="square:primerDisseny.Player"
	 */
	public Player getPlayer();
	
	public boolean isFirstSquare();
	
	public boolean isLastSquare();
	
	public void enter(Player p);
	
	public void leave(Player p);
	
	public boolean isOccupied();
	
	public ISquare moveAndLand(int moves);
	
	public ISquare landHereOrGoHome();
	
	public int getPosition();

	/**
	 * @return  Returns the game.
	 * @uml.property  name="game" default="new primerDisseny.Game()"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="squares:primerDisseny.Game"
	 */
	public Game getGame();
}
