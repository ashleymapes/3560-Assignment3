import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct{
	
	public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                                    configure("hibernate.cfg.xml").
                                    addAnnotatedClass(Order.class).
                                    addAnnotatedClass(Product.class).
                                    buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            
            session.beginTransaction();
            Product randomProduct = new Product("monocle");
            Product randomProduct2 = new Product("dog food");
            Product randomProduct3 = new Product("moustachio pistachio");
            
            session.save(randomProduct);
            session.save(randomProduct2);
            session.save(randomProduct3);
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            factory.close();
        }		
    
		
		System.out.println("Done!");
		
	}

}