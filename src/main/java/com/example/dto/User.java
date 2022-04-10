package com.example.dto;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int userId;
    private String userName;
    private String password;

}
