package rentalstore;

import java.util.Enumeration;

public abstract class AbstractStatement {

    private Enumeration rentals ;
    private String customerName;
    private int frequentRenterPoints = 0;

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
            frequentRenterPoints = getTotalFrequentRenterPoints(each);
            result += figures(each.getMovie().getTitle(),thisAmount);
            totalAmount += thisAmount;
        }
        result += footer(totalAmount,frequentRenterPoints);
        return result;
    }

    double getTotalCharge(double initialAmount,int rentDay ,Rental each) {
        if(each.getDayRented() > rentDay){
            initialAmount += (each.getDayRented() - rentDay)*1.5;
        }
        return initialAmount;
    }

    int getTotalFrequentRenterPoints(Rental each) {
        frequentRenterPoints ++;
        if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
            frequentRenterPoints ++;
        }
        return frequentRenterPoints;
    }

    public abstract String headerString(String customerName);

    public abstract String figures(String movieTitle, double thisAmount);

    public abstract String footer(double totalAmount, int frequentRenterPoints);
}
