package firstdesign;

public class Player {

	/**
	 * @uml.property  name="square"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="player:primerDisseny.ISquare"
	 */
	private ISquare square = null;

	/**
	 * Getter of the property <tt>square</tt>
	 * @return  Returns the square.
	 * @uml.property  name="square"
	 */
	public ISquare getSquare() {
		return square;
	}

	/**
	 * Setter of the property <tt>square</tt>
	 * @param square  The square to set.
	 * @uml.property  name="square"
	 */
	public void setSquare(ISquare square) {
		this.square = square;
	}

	/**
	 * @uml.property  name="name"
	 */
	private String name;

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
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
	
	public int position() {
		return square.getPosition();
	}
}
