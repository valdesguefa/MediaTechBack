package com.fstg.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Table(name="roles")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity implements Serializable {

    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;



    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<UserEntity> users;

/*
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"))
    private List<UserEntity> users;
    */
}
