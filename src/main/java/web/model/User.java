package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;



    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Car userCar;


    public User(String firstName, String lastName, String email, Car userCar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userCar = userCar;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Car getUserCar() {
        return userCar;
    }

    public void setUserCar(Car userCar) {
        this.userCar = userCar;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}