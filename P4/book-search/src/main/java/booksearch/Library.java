package booksearch;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
	private final List<Book> store = new ArrayList<>();
 
	public void addBook(final Book book) {
		store.add(book);
	}
 
	public List<Book> findBooks(final LocalDateTime from, final LocalDateTime to) {
		Calendar end = Calendar.getInstance();
		end.setTime(to);
		end.roll(Calendar.YEAR, 1);
 
		return store.stream().filter(book -> {
			return from.before(book.getPublished()) && end.getTime().after(book.getPublished());
		}).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
	}
}