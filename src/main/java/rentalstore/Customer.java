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

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        AbstractStatement htmlStatement = new HtmlStatement();
        htmlStatement.setRentals(rentals);
        htmlStatement.setCustomerName(getName());
        String statement = htmlStatement.statement();

        return statement;
    }
}
