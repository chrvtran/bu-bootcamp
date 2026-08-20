public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // TOSTRING: what prints when you System.out.println(employee) 
    @Override 
    public String toString() { 
        return name + " | " + phone; 
    } 
}
