package com.hamrorestaurant.hamrorestaurant.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="AuthenticationTable")
@Table(name="AuthenticationTable")
public class UserAuthentication implements Serializable {

    private static final long serialVersionUID=1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long authId;
    private String emailAddress;
    private String password;

}
