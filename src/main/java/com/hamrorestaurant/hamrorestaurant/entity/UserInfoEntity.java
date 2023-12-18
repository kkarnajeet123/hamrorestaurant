package com.hamrorestaurant.hamrorestaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="UserInformation")
@Table(name ="UserInformation")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private int userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserAddress> useraddress;
    
}
