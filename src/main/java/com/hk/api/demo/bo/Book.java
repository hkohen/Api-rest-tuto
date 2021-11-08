package com.hk.api.demo.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Comparable<Book>{
    public Book getBook(String type) {

        return new Book(id,title,description,type.toUpperCase());

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String type;


    @Override
    public int compareTo(Book o) {
        return this.getType().compareTo(o.getType());
    }

}
