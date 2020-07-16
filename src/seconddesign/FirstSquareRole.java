package seconddesign;

import java.util.ArrayList;

public final class FirstSquareRole extends SquareRole {

	/**
	 * @uml.property  name="players"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" aggregation="shared" inverse="firstSquare:problemDomain.Player"
	 */
	private ArrayList<Player> players = new ArrayList<Player>();

	public FirstSquareRole(Square s) {
		super(s);
	}
	
	@Override
	public boolean isFirstSquare() {
		return true;
	}

	@Override
	public void enter(Player player) {
		players.add(player);
		player.setSquare(square);
	}

	@Override
	public void leave(Player player) {
		players.remove(player);
	}

	@Override
	public boolean isOccupied() {
		return !players.isEmpty();
	}

}
