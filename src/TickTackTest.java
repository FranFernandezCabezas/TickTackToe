import java.util.Scanner;

public class TickTackTest {

	private static boolean gameOver;

	public static int row;
	public static int col;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		TickTackToe board = new TickTackToe();

		System.out.println("Welcome to Tick tack toe. ");

		System.out.println(board);

		gameOver = false;

		while (!gameOver) {

			System.out.print("Player " + board.getPlayer() + ", enter the row: ");

			row = input.nextInt();
			
			System.out.println();

			System.out.print("Player " + board.getPlayer() + ", enter the column: ");

			col = input.nextInt();

			board.shot(row - 1, col - 1);

			System.out.println();
			System.out.println(board);

			gameOver = board.checkGameOver();		
			
		}
		
		board.changeTurn();
		
		input.close();
		
		System.out.println("Game over, Player" + board.getPlayer() + "won!");
	}

}
