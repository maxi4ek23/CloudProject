package com.pelyshko.domain;


import javax.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "reservation", schema = "rent1")
@Data
public class Reservation {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "is_possible")
	private Boolean isPossible;
	
	@Basic
	@Column(name = "name", length = 50)
    private String name;
	
	@Basic
	@Column(name = "time", length = 100)
    private String time;
	
	@Basic
	@Column(name = "how_long", length = 100)
    private String howLong;
	
	@Basic
	@Column(name = "is_confirmed", length = 50)
    private Boolean isConfirmed;
	
	@OneToMany(mappedBy = "reservation")
	private List<Dwelling> dwellings;
	
	@ManyToOne
	@JoinColumn(name = "lessee_id", referencedColumnName = "id")
	private Lessee lessee;
	
	@OneToMany(mappedBy = "reservation")
	private List<CashWithdrawalFromLesseeToService> cashWithdrawalFromLesseeToServices;
	
}
