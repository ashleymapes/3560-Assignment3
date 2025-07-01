import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(
    name = "professor"
)
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "office_number")
    private String office_number;

    @Column(name = "research_area")
    private String research_area;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Professor(){}

    public Professor(String office_number, String research_area, Customer customer){
        this.office_number = office_number;
        this.research_area = research_area;
        this.customer = customer;
    }

    public Professor(String office_number, String research_area){
        this.office_number = office_number;
        this.research_area = research_area;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getOfficeNumber(){
        return office_number;
    }

    public void setOfficeNumber(String office_number){
        this.office_number = office_number;
    }

    public String getResearchArea(){
        return research_area;
    }

    public void setResearchArea(String research_area){
        this.research_area = research_area;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public String toString(){
        return "ID: " + "; Office Number: " + office_number + "; Research Area: " + research_area + "\n   -> Customer: " + customer;
    }

}