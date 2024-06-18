package com.fstg.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Table(name = "users")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;


    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<RoleEntity> roles;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;
}
