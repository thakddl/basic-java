package kim.chopper.bookstore.book;

import java.util.List;

public class BookController {
    private static BookController instance = new BookController();
    public static BookController getInstance() {
        return instance;
    }
    private BookController() {}

    private BookService service = BookService.getInstance();

    public List<BookVO> selectBookList(String searchWord) {
        return service.findAll(searchWord);
    }

}
