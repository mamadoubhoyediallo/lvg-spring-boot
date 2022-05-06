package gn.mbd.lvg.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false, unique = true)
    private String username;
    @Column(length = 150, nullable = false, unique = true)
    private String email;
    @Column(length = 200, nullable = false)
    private String password;
    @Column(length = 4, nullable = false)
    private boolean etat;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRoles> roles = new ArrayList<>();
}

