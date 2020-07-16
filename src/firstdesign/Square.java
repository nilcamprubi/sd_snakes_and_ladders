package firstdesign;


public class Square implements ISquare {

	private Player player;
	
	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public boolean isFirstSquare() {
		return false;
	}

	@Override
	public boolean isLastSquare() {
		return false;
	}

	@Override
	public void enter(Player p) {
		player = p;
		player.setSquare(this);
	}

	@Override
	public void leave(Player p) {
		player = null;
	}

	@Override
	public boolean isOccupied() {
		return player!=null;
	}

	private ISquare findRelativeSquare(int moves) {
		return game.findSquare(moves+position);
	}
	
	@Override
	public ISquare moveAndLand(int moves) {
		int lastPosition = game.findLastSquare().getPosition();
		if (position+moves>lastPosition) {
			System.out.println("Should go to " + (position+moves+1) 
					+ " beyond last square " + (lastPosition+1) 
					+ " so don't move");
			return this;
		} else {
			System.out.println("move from " + (position+1) + " to "
					+ (findRelativeSquare(moves).getPosition()+1));
			return findRelativeSquare(moves).landHereOrGoHome();
		}
	}

	private ISquare findFirstSquare() {
		return game.firstSquare();
	}
	
	@Override
	public ISquare landHereOrGoHome() {
		if (isOccupied()) {
			System.out.println("square " + (position+1) + " is occupied");
		} else {
			System.out.println("land at " + (position+1));
		}
		return isOccupied() ? findFirstSquare() : this;
	}
	
	private int position;

	@Override
	public int getPosition() {
		return position;
	}

	private Game game;
	
	@Override
	public Game getGame() {
		return game;
	}
	
	public Square(int pos, Game g) {
		position = pos;
		game = g;
	}

}
