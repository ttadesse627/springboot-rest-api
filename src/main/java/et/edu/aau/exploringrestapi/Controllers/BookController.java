package et.edu.aau.exploringrestapi.Controllers;

import et.edu.aau.exploringrestapi.Dtos.Book;
import et.edu.aau.exploringrestapi.Services.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book request) {
        Book createdBook = bookService.createBook(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdBook.id())
                .toUri();

        return ResponseEntity.created(location).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book request) {
        return bookService.updateBook(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBookPartial(@PathVariable Long id, @RequestBody Book request) {
        return bookService.updateBook(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        return deleted?
                ResponseEntity.noContent().build():
                ResponseEntity.notFound().build();
    }

    @GetMapping("/generate-report")
    public ResponseEntity<String> generateReport() {
        String reportContent = """
                Mock Sales Report for March 2026
                rooks sold: 324
                revenue: 43,3594
                """;

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Report-Generated-At", Instant.now().toString());
        headers.add("X-Total-Records", "2423");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"monthly-report.txt\"");

        return ResponseEntity.ok()
                .headers(headers)
                .body(reportContent);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String title) {
        if (title == null || title.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<Book> result = bookService.getAllBooks().stream()
                .filter(book -> book.title().toLowerCase().contains(title.toLowerCase()))
                .toList();

        return ResponseEntity.ok(result);
    }
}
