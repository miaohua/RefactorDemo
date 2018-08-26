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
                    thisAmount += 2;
                    if(each.getDayRented() > 2){
                        thisAmount+=(each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount+=each.getDayRented()*3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount+=1.5;
                    if(each.getDayRented() > 3){
                        thisAmount += (each.getDayRented() -3)*1.5;
                    }
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

    public abstract String headerString(String customerName);

    public abstract String figures(String movieTitle, double thisAmount);

    public abstract String footer(double totalAmount, int frequentRenterPoints);
}
