package com.company.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String surname;

    private List<String> allAddressList;
}
