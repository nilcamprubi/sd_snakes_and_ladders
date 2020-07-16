package seconddesign;

public class Square {

	/**
	 * @uml.property  name="board"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="squares:problemDomain.Board"
	 */
	private Board board = null;
	/**
	 * @uml.property  name="player"
	 * @uml.associationEnd  inverse="square:problemDomain.Player"
	 */
	private Player player = null;	
	/**
	 * @uml.property  name="position"
	 */
	private int position;
	/** 
	 * @uml.property name="squareRole"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="square:problemDomain.SquareRole"
	 */
	private SquareRole squareRole = null;

	public Square(int pos, Board b) {
		assert pos>=0 : "Square number must be positive or zero" ;
		position = pos;
		board = b;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player p) {
		player = p;
	}

	public int getPosition() {
		return position;
	}

	public void setSquareRole(SquareRole sr) {
		assert sr!=null;
		squareRole = sr;		
	}	

	public boolean isOccupied() {
		return squareRole.isOccupied();
	}

	/*
	public boolean isFirstSquare() {
		return squareRole.isFirstSquare();
	}
	*/

	public boolean isLastSquare() {
		return squareRole.isLastSquare();
	}

	public Square moveAndLand(int moves) {
		return squareRole.moveAndLand(moves);
	}

	public Square landHereOrGoHome() {
		return squareRole.landHereOrGoHome();
	}

	public void enter(Player p) {
		squareRole.enter(p);
	}

	public void leave(Player p) {
		squareRole.leave(p);
	}


	public Square findRelativeSquare(int shift) {
		return board.findSquare(position + shift);
	}
	
	public Square findFirstSquare() {
		return board.firstSquare();
	}
	
	public Square findLastSquare() {
		return board.lastSquare();
	}
}
