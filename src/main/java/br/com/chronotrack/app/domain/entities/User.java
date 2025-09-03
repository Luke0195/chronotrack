package br.com.chronotrack.app.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="tb_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name = "tb_users_roles",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @PrePersist
    void prePersist(){
      this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate(){
      this.updatedAt = LocalDateTime.now();
    }

    private boolean isValidPassword(String passwordConfirmation){
      return password.equalsIgnoreCase(passwordConfirmation);
    }
}
