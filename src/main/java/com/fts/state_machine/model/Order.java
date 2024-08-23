package com.fts.state_machine.model;

import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class Order {

    @Id
    private int id;

    private LocalDateTime createdDate;

    private String status;

    private BigDecimal  total;

    public Order() {
    }

    public Order(LocalDateTime createdDate, String status, BigDecimal total) {
        this.createdDate = createdDate;
        this.status = status;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
