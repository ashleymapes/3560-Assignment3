import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
	public static void main(String[] args) {
    SessionFactory factory = new Configuration().
					                 configure("hibernate.cfg.xml").
					                 addAnnotatedClass(Professor.class).
					                 addAnnotatedClass(Customer.class).				                 					                 
					                 buildSessionFactory();
			
			Session session = factory.getCurrentSession();
			
			try {
				
				session.beginTransaction();
				
                Professor professor = session.get(Professor.class, 1);
				
				session.delete(professor);
				
				session.getTransaction().commit();
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				factory.close();
			}
			
		
		System.out.println("Done!");
    }
}
