package model;


public class User {

	private String name;
	private int id;
	private int specialCondition;
	// True girl
	// False boy
	private boolean gender;
	// 0 No condicion especial
	// 1 Tercera edad
	// 2 Discapacidad
	// 3 Embarazo y niños en brazos

	public User(String name, int id, boolean gender, int specialCondition) {
		this.name = name;
		this.id = id;
		this.specialCondition = specialCondition;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int isSpecialCondition() {
		return specialCondition;
	}

	public void setSpecialCondition(int specialCondition) {
		this.specialCondition = specialCondition;
	}

	public int getSpecialCondition() {
		return specialCondition;
	}

	public int compareTo2(User u) {
		if (getSpecialCondition() > u.getSpecialCondition()) {
			return 1;

		} else if (getSpecialCondition() == u.getSpecialCondition()) {
			return 0;
		} else {
			return -1;
		}
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
	



	

}
