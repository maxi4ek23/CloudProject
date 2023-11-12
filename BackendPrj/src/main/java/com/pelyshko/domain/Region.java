package com.pelyshko.domain;

import javax.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "region", schema = "rent1")
@Data
public class Region {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "name", length = 50)
    private String name;
	
	@OneToMany(mappedBy = "region")
    private List<City> cities;
}
