package gn.mbd.lvg.security.repositories;

import gn.mbd.lvg.security.entities.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRolesRepository extends JpaRepository<AppRoles, Integer> {
    AppRoles findByRoleName(String role);
}
