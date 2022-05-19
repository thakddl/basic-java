package kim.chopper.bookstore.book;

import java.util.Objects;

public class BookVO {
    private int bookId;
    private String bookName;
    private String publisher;
    private int price;

    public BookVO() {
    }

    public BookVO(int bookId, String bookName, String publisher, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publisher = publisher;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookVO bookVO = (BookVO) o;
        return bookId == bookVO.bookId && price == bookVO.price && Objects.equals(bookName, bookVO.bookName) && Objects.equals(publisher, bookVO.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, publisher, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookVO{");
        sb.append("bookId=").append(bookId);
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
