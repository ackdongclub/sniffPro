package project01.sniffPro.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetForm {


    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private int age;
    private String gender;
}
