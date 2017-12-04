package repository;

public class User {
	private String name;
	private int age;
	private int id;

	@Override
	public String toString() {
		return id + " " + name + " " + age;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(String name, int age) {
		id = UserRepository.getID();
		this.name = name;
		this.age = age;
	}
}
