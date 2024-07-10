package org.sds.samsung.order.dto;

public class OrderDTO {
    private String orderId;
    private double amount;

    private Object data;
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
