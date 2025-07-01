import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jdbc.ConnectionFactory;

public class MainDeleteOrder {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                                        configure("hibernate.cfg.xml").
                                        addAnnotatedClass(Order.class).
                                        addAnnotatedClass(Product.class).					                 
                                        buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {			
            
            session.beginTransaction();
            
            Order tempOrder = session.get(Order.class, 3);
            
            System.out.println("Deleting order: " + tempOrder);
            
            session.delete(tempOrder);

            session.getTransaction().commit();
            
            System.out.println("Done!");
        }
        finally {
            
            session.close();
            factory.close();
        }
        
            
            System.out.println("Done!");
    }

}
