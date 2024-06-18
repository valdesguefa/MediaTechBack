package com.fstg.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserProfile implements Serializable {
    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String avatar;

    //@Column()
    @OneToOne()
    private UserProfile userProfile;
}
