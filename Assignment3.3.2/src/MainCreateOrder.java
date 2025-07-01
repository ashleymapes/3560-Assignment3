import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder{
	
	public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                                    configure("hibernate.cfg.xml").
                                    addAnnotatedClass(Order.class).
                                    addAnnotatedClass(Product.class).
                                    buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            
            session.beginTransaction();
            Product p1 = session.get(Product.class, 6);
            Product p2 = session.get(Product.class, 2);

            Order order1 = new Order(new Date(2025-07-01), "Monopoly Man");
            Order order2 = new Order(new Date(2025-01-18), "Pringles man");
            Order order3 = new Order(new Date(2025-02-26), "my mother");
            
            order1.addProduct(p1);
            order2.addProduct(p1);
            order3.addProduct(p2);

            session.save(order1);
            session.save(order2);
            session.save(order3);
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            factory.close();
        }		
    
		
		System.out.println("Done!");
		
	}

}