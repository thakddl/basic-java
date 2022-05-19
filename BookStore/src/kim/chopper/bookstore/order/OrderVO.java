package kim.chopper.bookstore.order;

import java.time.LocalDate;

public class OrderVO {
    private int orderId;
    private int custId;
    private int bookId;
    private String bookName;
    private int salePrice;
    private LocalDate orderDate;

    public OrderVO() {
    }

    public OrderVO(int orderId, int custId, int bookId, String bookName, int salePrice, LocalDate orderDate) {
        this.orderId = orderId;
        this.custId = custId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.salePrice = salePrice;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
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

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderVO{");
        sb.append("orderId=").append(orderId);
        sb.append(", custId=").append(custId);
        sb.append(", bookId=").append(bookId);
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", salePrice=").append(salePrice);
        sb.append(", orderDate=").append(orderDate);
        sb.append('}');
        return sb.toString();
    }
}
