package com.example.brfapi.brfapi.user;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor()
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;

    public User(UserRegisterData data) {
        this.name = data.name();
        this.role = data.role();
    }

    public void updateInfo(UserUpdateData data) {
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.role() != null){
            this.role = data.role();
        }
    }
}
