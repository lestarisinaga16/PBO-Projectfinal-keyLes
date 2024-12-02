package entities;

public class Passengers {
    private String name;
    private int age;
    private String gender;
    private String passportNumber;
    private String ktpNumber;
    private int id;  // Add the id field

    //setternya
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setKtpNumber(String ktpNumber) {
        this.ktpNumber = ktpNumber;
    }

    public void setId(int id) {  // Setter for id
        this.id = id;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getKtpNumber() {
        return ktpNumber;
    }

    public int getId() {  // Getter for id
        return id;
    }
}
