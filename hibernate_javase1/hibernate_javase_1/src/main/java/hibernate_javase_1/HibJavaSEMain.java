package hibernate_javase_1;

import hibernate_javase_1.console_utils.ConsoleUtils;
import hibernate_javase_1.examples.Example2;
import hibernate_javase_1.jpa_utils.JPAUtil;
import hibernate_javase_1.jpa_utils.QueryExecutor;
import hibernate_javase_1.model.Car;
import lombok.var;

public class HibJavaSEMain {
	
	public static void main(String[] args) 
	{
		try(
			var jpa = new JPAUtil("PERSISTENCE");
			var qe  = new QueryExecutor( jpa );
		){
			qe.execCustomCodeInTransaction( 
				Example2.prepareMultipleCarInsertion( 0, 5 ) 
			);
			qe.execCustomCodeInTransaction( 
				Example2.prepareFindAndPrint( Car.class )
			);
		}
		finally {
			ConsoleUtils.waitForEnter();
		}
	}
	
}