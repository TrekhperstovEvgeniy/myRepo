package home.hibernate.example3;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee")
public class EntityEmployee {

	@Id
	@GenericGenerator(name="kaygen" , strategy="native")
	@GeneratedValue(generator = "kaygen")
	private Integer id;
	
	@Basic
	private String name;
	
	@Basic
	private Integer age;
	
	
	
	public EntityEmployee(){}
	
	@Override
	public String toString(){
		
		return 
			new StringBuilder().
			append("Id= ").append(this.id).
			append(" Name= ").append(this.name).
			append(" Age= ").append(this.age).toString();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}
}
