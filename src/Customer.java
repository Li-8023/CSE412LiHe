public class Customer {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String address;

    Customer(String firstname, String lastname, String email, String password, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    String getFirstname() {
        return this.firstname;
    }

    String getLastname() {
        return this.lastname;
    }

    String getEmail() {
        return this.email;
    }

    String getPassword() {
        return this.password;
    }

    String getAddress() {
        return this.address;
    }

}
