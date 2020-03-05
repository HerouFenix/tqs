package org.book;

import booksearch.Book;
import booksearch.Library;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @Given("a book with the title {string}, written by {string}, published in {date_iso_local_date_time}")
    public void a_book_with_the_title_written_by_published_in(String string, String string2, Date date_iso_local_date_time) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("(a|another) book with the title {string}, written by {string}, published in {date_iso_local_date_time}")
    public void addNewBook(final String title, final String author, final LocalDateTime published) {
        Book book = new Book(title, author, published);
        library.addBook(book);
    }


    @Given("another book with the title {string}, written by {string}, published in {date_iso_local_date_time}")
    public void another_book_with_the_title_written_by_published_in(String string, String string2, LocalDateTime date_iso_local_date_time) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("the customer searches for books published between {date_iso_local_date_time} and {date_iso_local_date_time}")
    public void setSearchParameters(final LocalDateTime from, final LocalDateTime to) {
        result = library.findBooks(from, to);
    }


    @Then("{int} books should have been found")
    public void books_should_have_been_found(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("Book {int} should have the title {string}")
    public void book_should_have_the_title(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
