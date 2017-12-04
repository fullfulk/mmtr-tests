package exe;

import task.Revers;

public class App {
	public static byte[] input = new byte[] { 35, 21, 56, 77 };

	public static void main(String[] args) {
		System.out.println("no reverse: " + Revers.noReverse(input));
		System.out.println("reverse 1: " + Revers.reverseH(input));
		System.out.println("reverse 2: " + Revers.reverseM(input));
	}
}
