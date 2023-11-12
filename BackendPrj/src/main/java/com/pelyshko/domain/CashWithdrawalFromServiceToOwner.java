package com.pelyshko.domain;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cash_withdrawal_from_service_to_owner", schema = "rent1")
@Data
@NoArgsConstructor
public class CashWithdrawalFromServiceToOwner {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "price")
	private Integer price;
	
	@OneToOne
    @JoinColumn(name = "cash_withdrawal_from_lessee_to_service_id", referencedColumnName = "id")
    private CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService;
}
