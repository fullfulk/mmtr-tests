package exe;

import java.io.IOException;
import java.util.Scanner;

public class App {

	static Executor exe01 = new Executor(200);
	static Executor exe02 = new Executor(200);
	static Executor exe03 = new DisplayingExecutor(3000);
	static Executor exe04 = new GettingExecutor(10000);
	static Executor exe05 = new GettingExecutor(10000);

	public static void main(String[] args) throws IOException {
		new Thread(exe01,"exe01").start();
		new Thread(exe02,"exe02").start();
		new Thread(exe03,"displayExe").start();
		new Thread(exe04,"gettingExe01").start();
		new Thread(exe05,"gettingExe02").start();
		Scanner sc = new Scanner(System.in);
		boolean isAlive = true;
		while (isAlive) {
			if (sc.nextLine().equals("quit")) {
				isAlive = false;
			}
		}
		sc.close();
		exe01.close();
		exe02.close();
		exe03.close();
		exe04.close();
		exe05.close();
	}
}
