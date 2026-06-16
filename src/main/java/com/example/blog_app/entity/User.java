package com.example.blog_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String bio;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
