package com.hamrorestaurant.hamrorestaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name="UserInformation")
@Table(name ="UserInformation")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    @JsonIgnore
    private int userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserAddress> userAddress= new ArrayList<>();
    
}
