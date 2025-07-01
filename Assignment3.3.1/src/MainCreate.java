import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate{
	
	public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                                    configure("hibernate.cfg.xml").
                                    addAnnotatedClass(Customer.class).
                                    addAnnotatedClass(Professor.class).
                                    buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            
            session.beginTransaction();

            Customer tempCustomer = new Customer("Fred Flintstones", "100 bedrock ave");

            Professor tempProfessor = new Professor("13b", "Archeology");
            
            tempProfessor.setCustomer(tempCustomer);

            session.save(tempProfessor);
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            factory.close();
        }		
    
		
		System.out.println("Done!");
		
	}

}