package task;

public class Revers {

	public static String noReverse(byte[] input) {
		String tmp = new String();
		for (byte b : input) {
			tmp += Integer.toBinaryString(b) + " ";
		}
		return tmp;
	}

	public static String reverseH(byte[] input) {
		String tmp = new String();
		for (int i = 0; i < input.length; i++) {
			int intI = invertH(input[i]);
			intI <<= 24;
			tmp += Integer.toBinaryString(intI).substring(0, 8) + " ";
		}
		return tmp;
	}

	public static String reverseM(byte[] input) {
		String tmp = new String();
		for (int i = 0; i < input.length; i++) {
			int intI = invertM(input[i]);
			intI <<= 24;
			tmp += Integer.toBinaryString(intI).substring(0, 8) + " ";
		}
		return tmp;
	}

	private static byte invertH(byte b) {
		return (byte) (Integer.reverse(b) >>> (Integer.SIZE - Byte.SIZE));
	}

	private static byte invertM(byte b) {
		byte tmp = 0;
		for (int i = 7; i > 0; i--) {
			tmp += ((b & 1) << i);
			b >>= 1;
		}
		return tmp;
	}
}
