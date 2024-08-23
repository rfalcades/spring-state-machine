package com.fts.state_machine.repository;

import com.fts.state_machine.ex2.RabbitStreamService;
import com.fts.state_machine.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Order order) {

        String sql = "INSERT INTO orders (created_date, status, total) VALUES (?, ?, ?)";
        int rows = jdbcTemplate.update(sql, order.getCreatedDate(), order.getStatus(), order.getTotal());

        logger.info("Rows affected: " + rows);
    }

    public List<Order> findAll() {

        return new ArrayList<Order>();
    }
}
