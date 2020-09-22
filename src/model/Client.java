package model;

import java.util.Date;

public class Client extends User {

    private double balance;
    private double creditQuota, limit;

    // Pago de tarjeta de credito y fecha de registro
    private Date datePayC, registrationDate;

    // Politica de banco: para limite credito sera balance*0.1
    public Client(String name, int id, double balance, double creditQuota, Date datePayC, Date registrationDate,
            int specialCondition) {
        super(name, id, specialCondition);
        this.balance = balance;
        this.creditQuota = creditQuota;
        this.datePayC = datePayC;
        this.registrationDate = registrationDate;
        limit = balance * 0.1;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditQuota() {
        return limit - creditQuota;
    }

    public Date getDatePayC() {
        return datePayC;
    }

    public void setDatePayC(Date datePayC) {
        this.datePayC = datePayC;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}