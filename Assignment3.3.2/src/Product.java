import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "products")

    private List<Order> orders;

    public Product(){}

    public Product(String name){
        this.name = name;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

    public void addOrder(Order theOrder) {
		
		if (orders == null) {
			orders = new ArrayList<>();
		}
		
	    if (!orders.contains(theOrder)) {
	    	orders.add(theOrder);
	    	theOrder.addProduct(this); // Mutual link only if not already added
	    }		
		
	}

    @Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
    


}