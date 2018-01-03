import javax.faces.bean.ManagedBean;
import javax.persistence.*;

public class Cities {
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "city_id")
	private int city_id;
	@Column(name = "name")
	private String name;

	public Cities(int city_id, String name) {//constructor with parameters
		this.city_id = city_id;
		this.name = name;
	}

	public Cities() {
	}

	public Cities search() {
		MyDB database = new MyDB();
		Cities city = database.searchCitiesById(this.city_id);
		return city;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company{" + "city_id=" + city_id + ", name='" + name + '}';
	}
}
