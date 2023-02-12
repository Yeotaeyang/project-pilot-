package com.mc.mvc.model.entity;

@Entity
public class dataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String data;
    // getters, setters and other methods
}
