package home.hibernate.example4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Ordered")
public class EntityOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String description1;
	
	@Transient
	private String zakazchik;

	public String getDescription() {
		return description1;
	}

	public void setDescription(String description) {
		this.description1 = description;
	}

	public Integer getId() {
		return id;
	}	
}
