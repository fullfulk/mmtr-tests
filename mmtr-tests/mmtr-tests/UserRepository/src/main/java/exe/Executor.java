package exe;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;

import repository.User;
import repository.UserRepository;

public class Executor implements Runnable, Closeable {
	protected int timeOut;
	protected boolean isAlive = true;

	public Executor(int timeOut) {
		this.timeOut = timeOut;
	}

	private String genName() {
		Random rnd = new Random();
		char[] heap = new char[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j',
				'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
		String name = new String();
		int amount = rnd.nextInt(5) + 1;
		for (int i = 0; i < amount; i++) {
			name += heap[rnd.nextInt(26)];
		}
		return name + ":" + Thread.currentThread().getName();
	}

	private int genAge() {
		return new Random().nextInt(100) + 1;
	}

	@Override
	public void run() {
		while (isAlive) {
			try {
				UserRepository.getInstance().addUser(new User(genName(), genAge()));
				Thread.sleep(timeOut);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void close() throws IOException {
		isAlive = false;
	}
}
