package repository;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {

	private static volatile UserRepository instance = new UserRepository();
	private static AtomicInteger id = new AtomicInteger();
	private final ConcurrentSkipListMap<Integer, User> storage = new ConcurrentSkipListMap<>();

	public static int getID() {
		return id.incrementAndGet();
	}

	public static int showID() {
		return id.get();
	}

	private UserRepository() {
	}

	public static UserRepository getInstance() {
		return instance;
	}

	public void addUser(User user) {
		storage.put(user.getId(), user);
	}

	public User getUser(int id) {
		return storage.get(id);
	}

	public void getOrderedUsers() {
		storage.forEach((key, value) -> 
		System.out.println(Thread.currentThread().getName()
				+": "+key + " " + value.toString()));
	}
}
