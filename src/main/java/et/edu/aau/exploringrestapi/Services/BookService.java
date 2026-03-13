package et.edu.aau.exploringrestapi.Services;

import et.edu.aau.exploringrestapi.Dtos.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1L);


    public void initMockData(){
        books.add(new Book(idGenerator.getAndIncrement(), "Spring Boot in Action", "Craig Walls"));
        books.add(new Book(idGenerator.getAndIncrement(), "Clean Code", "Robert C. Martin"));
        books.add(new Book(idGenerator.getAndIncrement(), "The Pragmatic Programmer", "David Thomas"));
        books.add(new Book(idGenerator.getAndIncrement(), "Effective Java", "Joshua Bloch"));
        books.add(new Book(idGenerator.getAndIncrement(), "Java Concurrency in Practice", "Brian Goetz"));
        books.add(new Book(idGenerator.getAndIncrement(), "Design Patterns", "Erich Gamma"));
        books.add(new Book(idGenerator.getAndIncrement(), "Head First Design Patterns", "Eric Freeman"));
        books.add(new Book(idGenerator.getAndIncrement(), "Refactoring", "Martin Fowler"));
        books.add(new Book(idGenerator.getAndIncrement(), "Clean Architecture", "Robert C. Martin"));
        books.add(new Book(idGenerator.getAndIncrement(), "Test Driven Development", "Kent Beck"));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst();
    }

    public Book createBook(Book request) {
        Book newBook = new Book(idGenerator.getAndIncrement(), request.title(), request.author());
        books.add(newBook);
        return newBook;
    }

    public Optional<Book> updateBook(Long id, Book request){

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id().equals(id)) {
                Book updatedBook = new Book(id, request.title(), request.author());
                books.set(i, updatedBook);
                return Optional.of(updatedBook);
            }
        }

        return Optional.empty();
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.id().equals(id));
    }
}
