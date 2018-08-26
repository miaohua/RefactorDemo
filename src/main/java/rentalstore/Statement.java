package rentalstore;

public class Statement extends AbstractStatement{
    @Override
    public String headerString(String customerName) {
        String result = "Rentals for "
                + customerName
                + "\n";
        return result;
    }

    @Override
    public String figures(String movieTitle, double thisAmount) {
        String result = "\t"
                + movieTitle
                + "\t"
                + String.valueOf(thisAmount)
                + "\n";
        return result;
    }

    @Override
    public String footer(double totalAmount, int frequentRenterPoints) {
        String result= "";
        result  += "You owe "
                + String.valueOf(totalAmount)
                + "\n"
                + "On this rental you earned "
                + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
