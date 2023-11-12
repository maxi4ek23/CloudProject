package com.pelyshko.domain;

import java.util.Set;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "platform_user", schema = "rent1")
@Data
public class PlatformUser {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "email", length = 50)
    private String email;
	
	@Basic
	@Column(name = "phone", length = 50)
    private String phone;
	
	@OneToOne(mappedBy = "platformUser")
    private Lessee lessee;
	
    @OneToOne(mappedBy = "platformUser")
    private DwellingOwner dwellingOwner;
    
    @ManyToMany(mappedBy = "platformUsers")
    private Set<Dwelling> dwellings;
}
