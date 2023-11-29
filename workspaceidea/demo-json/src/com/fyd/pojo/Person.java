package com.fyd.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private Dog dog;

}
