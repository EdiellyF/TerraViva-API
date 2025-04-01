package org.TerraViva.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = User.TABLE_NAME,
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User {
    public static final String TABLE_NAME = "usuario";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", length = 60, nullable = false)
    private String password;


//    @ElementCollection(fetch = FetchType.EAGER)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @CollectionTable(name = "user_profiles")
//    @Column(name = "profile", nullable = false)
//    private Set<Integer> profiles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void setProfiles(Set<Integer> profiles) {
//        this.profiles = profiles;
//    }

//    public Set<ProfileEnum> getProfiles() {
//        return this.profiles.stream()
//                .map(ProfileEnum::toEnum)
//                .collect(Collectors.toSet());
//    }
//
//    public void addProfile(ProfileEnum profileEnum){
//        profiles.add(profileEnum.getCode());
//    }



}
