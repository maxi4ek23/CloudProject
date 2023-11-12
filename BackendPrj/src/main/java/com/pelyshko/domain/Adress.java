package com.pelyshko.domain;

import javax.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adress", schema = "rent1")
@Data
@Getter
@NoArgsConstructor
public class Adress {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "street", length = 50)
	private String street;
	
	@Basic
	@Column(name = "house_number")
	private Integer houseNumber;
	
	@ManyToOne
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;
	
	@OneToMany(mappedBy = "adress")
	private List<Dwelling> dwellings;

	public String getStreet() {
		return street;
	}
	
	

}
