import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jdbc.ConnectionFactory;

public class MainDeleteProduct {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                                        configure("hibernate.cfg.xml").
                                        addAnnotatedClass(Order.class).
                                        addAnnotatedClass(Product.class).					                 
                                        buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {			
            
            session.beginTransaction();
            
            Product product = session.get(Product.class, 3);
            
            for (Order order: product.getOrders()) {
			        order.getProducts().remove(product);
			    }
            System.out.println("Deleting product: " + product);
            
            session.delete(product);

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
