package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return common(new Statement());
    }

    public String htmlStatement() {
        return common(new HtmlStatement());
    }

    public String common(AbstractStatement statement){
        Enumeration rentals = this.rentals.elements();
        statement.setRentals(rentals);
        statement.setCustomerName(getName());
        String result = statement.statement();
        return result;
    }
}
