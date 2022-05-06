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
public class AppRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false, unique = true)
    private String roleName;
    private String description;
    @ManyToMany(mappedBy = "roles")
    private List<AppUser> users = new ArrayList<>();
}
