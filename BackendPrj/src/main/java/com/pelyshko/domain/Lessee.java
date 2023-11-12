package com.pelyshko.domain;


import javax.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "lessee", schema = "rent1")
@Data
public class Lessee {
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
	
	@OneToMany(mappedBy = "lessee")
	private List<Reservation> reservations;
	
	@OneToOne
    @JoinColumn(name = "platform_user_id", referencedColumnName = "id")
    private PlatformUser platformUser;
}
