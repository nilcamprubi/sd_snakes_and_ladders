package seconddesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SnakeRole extends SquareRole {
	private int transport;
	private Logger logger = LoggerFactory.getLogger("SnakeRole");

	public SnakeRole(Square s, int t) {
		super(s);
		assert t<0 : "A snake shift must be negative" ;
		transport = t;
	}

	@Override
	public Square landHereOrGoHome() {
		logger.debug("snake from " + (square.getPosition()+1) + " to "
				+ (destination().getPosition()+1));
		return destination().landHereOrGoHome();
	}
	
	private Square destination() {
		return square.findRelativeSquare(transport);
	}
}
