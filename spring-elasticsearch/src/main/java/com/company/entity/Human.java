package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "humans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Human {


    @Id
    private String id;

    @Field(name = "name",type = FieldType.Text)
    private String name;

    @Field(name = "surname",type = FieldType.Text)
    private String surname;

    @Field(name = "address",type = FieldType.Text)
    private String address;

    @Field(name = "birth_day",type = FieldType.Date)
    private Date birthday;
}
