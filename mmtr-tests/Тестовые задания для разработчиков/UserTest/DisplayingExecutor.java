package exe;

import repository.UserRepository;

public class DisplayingExecutor extends Executor {

	public DisplayingExecutor(int timeOut) {
		super(timeOut);
	}
	
	@Override
	public void run() {
		while (isAlive) {
			try {
				UserRepository.getInstance().getOrderedUsers();
				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
