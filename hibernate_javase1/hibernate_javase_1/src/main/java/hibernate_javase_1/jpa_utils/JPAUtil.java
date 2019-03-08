package hibernate_javase_1.jpa_utils;

import java.io.Closeable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.Getter;

public class JPAUtil implements Closeable{
	
	@Getter
	private final String persistenceUnitName;
	private EntityManagerFactory factory;
	
	public JPAUtil( String persistenceUnitName ) {
		this.persistenceUnitName = persistenceUnitName;
		factory = Persistence.createEntityManagerFactory( 
			persistenceUnitName );
	}
	
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	public void close() {
		if (factory != null) { factory.close(); }
	}

}