package com.zyy.domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Book {
    private Integer id;
    private String name;
    private String type;
    private String description;

}
