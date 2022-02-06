package seconddesign;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main {

	public static void main(String[] args) {
		// TODO these parameters have to be read and checked for
		// validity from the console, that is, the command line.
		String[] playerNames = {"Mireia", "Genis", "Martina", "Miquel"};
		int numSquares = 12;
		// for the user first square is at position 1 but internally is at 0
		int[][] snakesFromTo = { {11,5} };
		int[][] laddersFromTo = { {2,6} , {7,9} };

		boolean do_simulation = false;

		if (do_simulation) {
			// Simulation to compute probability of some player to finish the game before a
			// maximum number of rounds.
			// IMPORTANT: for each value of maximum number of rounds, we play this mumber of games.
			// For 15000 games per value of max rounds, the curve is quite smooth but you need to
			// comment out all prints, otherwise it takes a lot of time. So we have replaced
			// all System.out.println statements by a logger, the configuration file is in
			// folder lib/. Change root level="debug" to root level="info" before running the
			// simulation

			final int MaxMaxRounds = 200;
			// compute probability to finish for a maximum number of rounds from 1 to this number
			final int NumGames = 15000;
			// per each value of max rounds tried
			double[] probabilityToFinish = new double[MaxMaxRounds];
			Logger logger = LoggerFactory.getLogger("Main");
			System.out.println(". = " + NumGames + " games");
			for (int maxRounds = 1; maxRounds < MaxMaxRounds; maxRounds++) {
				int numFinishedGames = 0;
				for (int i = 0; i < NumGames; i++) {
					Game game = new Game(playerNames, numSquares, snakesFromTo, laddersFromTo);
					if (game.play(maxRounds)) {
						numFinishedGames++;
					}
					probabilityToFinish[maxRounds] = numFinishedGames / (double) NumGames;
				}
				logger.debug("for " + maxRounds + " max number of rounds, "
								+ numFinishedGames + " finished games");
				System.out.print("."); // kind of progress bar
			}
			System.out.println();
			System.out.println("After " + MaxMaxRounds*NumGames + " games, the probabilities are:");
			System.out.println(Arrays.toString(probabilityToFinish));
		} else {
			// play one game, no limit of rounds
			Game game = new Game(playerNames, numSquares, snakesFromTo, laddersFromTo);
			game.play();
		}
	}
}
