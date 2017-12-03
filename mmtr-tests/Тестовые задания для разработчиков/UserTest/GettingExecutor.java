package exe;

import java.util.Random;

import repository.UserRepository;

public class GettingExecutor extends Executor {

	public GettingExecutor(int timeOut) {
		super(timeOut);
	}

	private Random rnd = new Random();
	
	@Override
	public void run() {
		while (isAlive) {
			try {
				System.out.println(Thread.currentThread().getName()+": "+
						UserRepository.getInstance()
				.getUser(rnd.nextInt(UserRepository.showID() + 1)));
				Thread.sleep(timeOut);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
