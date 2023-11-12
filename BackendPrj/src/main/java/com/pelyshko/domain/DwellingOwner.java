package com.pelyshko.domain;


import javax.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "dwelling_owner", schema = "rent1")
@Data
public class DwellingOwner {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "name", length = 50)
    private String name;
	
	@Basic
	@Column(name = "surname", length = 50)
    private String surname;
	
	@OneToMany(mappedBy = "dwellingOwner")
	private List<Dwelling> dwellings;
	
	@OneToOne
    @JoinColumn(name = "platform_user_id", referencedColumnName = "id")
    private PlatformUser platformUser;
	
}
