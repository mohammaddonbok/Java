package com.mvcmodel.mvc.controlleres;

import com.mvcmodel.mvc.models.Book;
import com.mvcmodel.mvc.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
    @RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id,Model model){
        Book b =bookService.findBook(id);
        model.addAttribute("book",b);
        return "index.jsp";
    }
}
