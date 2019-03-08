package hibernate_javase_1.examples;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;

import hibernate_javase_1.model.Car;
import lombok.var;

public class Example2 {

	public static Function<EntityManager,Void> 
		prepareMultipleCarInsertion( 
			final int FROM_INDEX, 
			final int TO_INDEX
		)
	{
		return (em) -> {
			
			for( int i=FROM_INDEX; i<=TO_INDEX; i++ ) {
				Car c = new Car("model"+i,"price"+i);
				em.persist(c);
			}
			return null;
			
		};
	}
	
	public static Void findAndPrintCars( EntityManager em ) 
	{
		@SuppressWarnings("unchecked")
		var cars = (List<Car>) em.createNativeQuery(
				"SELECT * FROM Car", Car.class
			).getResultList();
		
		for( var car: cars ){
			System.out.println( "FOUNDED CAR: " + car.toString() );
		}
		return null;
	}

	public static <T> Function<EntityManager,Void> 
		prepareFindAndPrint( Class<T> type ) 
	{
		return ( em )
		-> {
			@SuppressWarnings("unchecked")
			var list = (List<T>) em.createNativeQuery(
					"SELECT * FROM " + type.getSimpleName() , 
					type
				).getResultList();
			
			for( var e: list ){
				System.out.println( "FOUNDED CAR: " + e.toString() );
			}
			return null;
		};
	}
}
