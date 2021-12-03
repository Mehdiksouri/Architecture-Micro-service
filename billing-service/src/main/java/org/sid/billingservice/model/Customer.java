package org.sid.billingservice.model;

import lombok.Data;



@Data
public class Customer {
    private Long id;
    private String nom;
    private String email;
}
