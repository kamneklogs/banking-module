package model;
	

public class Client extends User implements Comparable<Client> {

	private double balance;
	private double creditQuota, limit;

	// Pago de tarjeta de credito y fecha de registro
	private String registrationDate;

	// Politica de banco: para limite credito sera balance*0.1
	public Client(String name, int id, boolean gender, double balance, double creditQuota, String today,
			int specialCondition) {
		super(name, id, gender, specialCondition);
		this.balance = balance;
		this.creditQuota = creditQuota;

		this.registrationDate = today;
		limit = balance * 0.1;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getCreditQuota() {
		return creditQuota;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int compareTo(Client u) {

		if (getId() > u.getId()) {
			return 1;

		} else if (getId() == u.getId()) {
			return 0;
		} else {
			return -1;
		}

	}

}