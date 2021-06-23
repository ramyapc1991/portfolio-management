package com.turvo.portfolio.management.resources.java.com.turvo.portfolio.management.model;

import lombok.Data;

@Data
public class Holding {
    private String date;
    private String security;
    private int quantity;
    private String portfolio;
}
