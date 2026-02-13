public class User {

    private String name;
    private String email;

    // Constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString para imprimir el objeto
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}