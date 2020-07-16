package seconddesign;

public final class Player {

	/**
	 * @uml.property  name="square"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="player:problemDomain.Square"
	 */
	private Square square = null;

	/**
	 * @uml.property  name="square"
	 */
	public Square getSquare() {
		return square;
	}

	/**
	 * @uml.property  name="square"
	 */
	public void setSquare(Square square) {
		this.square = square;
	}

    public int position() {
    	return square.getPosition();
    }
	
	/**
	 * @uml.property  name="name"
	 */
	private String name;

	/**
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}
	
	public Player(String strname) {
		name = strname;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean wins() {
		return square.isLastSquare();
	}
	
	public void moveForward(int moves) {
		assert moves>0 : "non-positive moves";
		square.leave(this);
		square = square.moveAndLand(moves);
		square.enter(this);
	}
}
