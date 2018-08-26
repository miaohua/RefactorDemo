package rentalstore;

import java.util.Enumeration;

public abstract class AbstractStatement {

    private Enumeration rentals ;
    private String customerName;

    public Enumeration getRentals() {
        return rentals;
    }

    public void setRentals(Enumeration rentals) {
        this.rentals = rentals;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = headerString(customerName);
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();

            switch (each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount = getTotalCharge(2.0,2,each);
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount+=each.getDayRented()*3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount = getTotalCharge(1.5,3,each);
                    break;
            }

            //add frequent renter points
            frequentRenterPoints ++;
            //add bonus for a two day new release rental
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
                frequentRenterPoints ++;
            }

            //show figures for this rental
            result += figures(each.getMovie().getTitle(),thisAmount);
            totalAmount += thisAmount;
        }

        //add footer lines
        result += footer(totalAmount,frequentRenterPoints);
        return result;
    }

    double getTotalCharge(double initialAmount,int rentDay ,Rental each) {
        //Rental each = (Rental) rentals.nextElement();
        if(each.getDayRented() > rentDay){
            initialAmount += (each.getDayRented() - rentDay)*1.5;
        }
        return initialAmount;
    }

    public abstract String headerString(String customerName);

    public abstract String figures(String movieTitle, double thisAmount);

    public abstract String footer(double totalAmount, int frequentRenterPoints);
}
