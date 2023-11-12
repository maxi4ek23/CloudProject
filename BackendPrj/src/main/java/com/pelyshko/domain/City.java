package com.pelyshko.domain;

import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "city", schema = "rent1")
@Data
public class City {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "name", length = 50)
    private String name;
	
	@Basic
	@Column(name = "population")
    private Integer population;
	
	@ManyToOne
	@JoinColumn(name = "region_id", referencedColumnName = "id")
	private Region region;
	
	@OneToMany(mappedBy = "city")
	private List<Adress> adresses;
}
