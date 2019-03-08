package hibernate_javase_1.jpa_utils;

import java.io.Closeable;
import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;

import lombok.AllArgsConstructor;
import lombok.var;

/**
Esempio:
<pre>
EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		QueryExecutor qe = new QueryExecutor(em);
		
		Car c = qe.execNativeQuery_SingleResult("select * from car", Car.class);
		
		em.close();
		JPAUtil.shutdown();
</pre>
 */
@AllArgsConstructor 
public class QueryExecutor implements Closeable {
	
	public QueryExecutor( JPAUtil jpa ) {
		em = jpa.createEntityManager();
	}
	
	public void close() {
		em.close();
	}
	
	public <T> T execCustomCodeInTransaction( 
		Function<EntityManager,T> function1  ) 
	{
		em.getTransaction().begin();
		try {
			
			T res = function1.apply(em);
			// em.createNativeQuery(query).executeUpdate();
			
			em.getTransaction().commit();
			return res;
		} catch( Exception e ) { 
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		}
	}
	 
	private EntityManager em;

}
