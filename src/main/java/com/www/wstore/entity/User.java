package com.www.wstore.entity;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
private Integer id;
private String  img;
private String  name;
private String  password;
private String  gender;
private Date birthday;
private String  address;
private String  email;
private String  phone;
private String  wechat;
private Date  crecentLongin;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
