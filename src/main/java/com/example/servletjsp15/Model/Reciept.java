package com.example.servletjsp15.Model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Reciept {
private int id;
private String product_name;
private String quantity;
private String price;

    public Reciept() {
    }
}
