package model;

public class User {
    private String name, id;
    private boolean specialCondition;

    public User(String name, String id, boolean specialCondition) {
        this.name = name;
        this.id = id;
        this.specialCondition = specialCondition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSpecialCondition() {
        return specialCondition;
    }

    public void setSpecialCondition(boolean specialCondition) {
        this.specialCondition = specialCondition;
    }

}
