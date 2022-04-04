package functional.chap06;

import java.math.BigDecimal;

public class OrderLine {
    private long id;
    private OrderLineType type;
    private long productId;
    private int quantity;
    private BigDecimal amout;

    public enum OrderLineType {
        PURCHASE,
        DISCOUNT
    }

    public long getId() {
        return id;
    }

    public OrderLine setId(long id) {
        this.id = id;
        return this;
    }

    public OrderLineType getType() {
        return type;
    }

    public OrderLine setType(OrderLineType type) {
        this.type = type;
        return this;
    }

    public long getProductId() {
        return productId;
    }

    public OrderLine setProductId(long productId) {
        this.productId = productId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderLine setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getAmout() {
        return amout;
    }

    public OrderLine setAmout(BigDecimal amout) {
        this.amout = amout;
        return this;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", type=" + type +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", amout=" + amout +
                '}';
    }
}
