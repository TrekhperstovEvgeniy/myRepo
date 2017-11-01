package home.hibernate.example4;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Company", schema = "schema1")
public class EntityCompany {

	public EntityCompany(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;
	
	@Column(name="name", length=255)
	private String name;
	
	@JoinTable(
			name="ONETOMANYTABLE",
			joinColumns = @JoinColumn(referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(referencedColumnName= "id"))
	@OneToMany(fetch=FetchType.LAZY)
	List<EntityEmployee> employee;

	@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
	private	List<EntityOrder> order;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EntityEmployee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EntityEmployee> employee) {
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}

	public List<EntityOrder> getOrder() {
		return order;
	}

	public void setOrder(List<EntityOrder> order) {
		this.order = order;
	}
	
}
