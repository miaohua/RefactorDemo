package rentalstore;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer = new Customer("Hazel");

    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();
        assertEquals("Rentals for Hazel\nYou owe 0.0\nOn this rental you earned 0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rentals for Hazel\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "You owe 2.0\n" +
                "On this rental you earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.statement();

        assertEquals("Rentals for Hazel\n" +
                "\t" + regularMovie.getTitle() + "\t3.5\n" +
                "You owe 3.5\n" +
                "On this rental you earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new Movie("Titanic", 1);
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rentals for Hazel\n" +
                "\t" + newReleaseMovie.getTitle() + "\t3.0\n" +
                "You owe 3.0\n" +
                "On this rental you earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = new Movie("Titanic", 1);
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.statement();

        assertEquals("Rentals for Hazel\n" +
                "\t" + newReleaseMovie.getTitle() + "\t6.0\n" +
                "You owe 6.0\n" +
                "On this rental you earned 2 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new Movie("Titanic", 2);
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rentals for Hazel\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "You owe 1.5\n" +
                "On this rental you earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new Movie("Titanic", 2);
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.statement();

        assertEquals("Rentals for Hazel\n" +
                "\t" + childrenMovie.getTitle() + "\t3.0\n" +
                "You owe 3.0\n" +
                "On this rental you earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_no_rental() {

        String statement = customer.htmlStatement();
        assertEquals("<H1>Rentals for <EM>Hazel</EM></H1><P>\n" +
                "<P>You owe<EM>0.0</EM><P>\n" +
                "On this rental you earned <EM>0</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Hazel</EM></H1><P>\n" +
                "Titanic: 2.0<BR>\n" +
                "<P>You owe<EM>2.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Hazel</EM></H1><P>\n" +
                "Titanic: 3.5<BR>\n" +
                "<P>You owe<EM>3.5</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new Movie("Titanic", 1);
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Hazel</EM></H1><P>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = new Movie("Titanic", 1);
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Hazel</EM></H1><P>\n" +
                "Titanic: 6.0<BR>\n" +
                "<P>You owe<EM>6.0</EM><P>\n" +
                "On this rental you earned <EM>2</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new Movie("Titanic", 2);
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Hazel</EM></H1><P>\n" +
                "Titanic: 1.5<BR>\n" +
                "<P>You owe<EM>1.5</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new Movie("Titanic", 2);
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Hazel</EM></H1><P>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_art_film_for_1_day() {
        Movie artMovie = new Movie("Titanic", 3);
        Rental oneDayRental = new Rental(artMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Hazel</EM></H1><P>\n" +
                "Titanic: 6.0<BR>\n" +
                "<P>You owe<EM>6.0</EM><P>\n" +
                "On this rental you earned <EM>1.5</EM> frequent renter points<P>", statement);
    }
}