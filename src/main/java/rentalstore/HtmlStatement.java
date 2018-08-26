package rentalstore;

public class HtmlStatement extends AbstractStatement {
    @Override
    public String headerString(String customerName) {
        String result = "<H1>Rentals for <EM>"
                        + customerName
                        + "</EM></H1><P>\n";
        return result;
    }

    @Override
    public String figures(String movieTitle, double thisAmount) {
        String result = movieTitle
                        + ": "
                        + String.valueOf(thisAmount)
                        + "<BR>\n";
        return result;
    }

    @Override
    public String footer(double totalAmount, double frequentRenterPoints) {
        String result= "";
        result  += "<P>You owe<EM>"
                + String.valueOf(totalAmount)
                + "</EM><P>\n"
                + "On this rental you earned <EM>"
                + String.valueOf(frequentRenterPoints)
                + "</EM> frequent renter points<P>";
        return result;
    }
}
