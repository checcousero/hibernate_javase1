package hibernate_javase_1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @ToString @EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public class Car implements Serializable {

	public Car(String model, String price) {
		this.model = model;
		this.price = price;
	}

	@Getter
    private String model;
    @Getter @Setter
    private String price;
    
    @Id
    @GeneratedValue( 
    		strategy=GenerationType.SEQUENCE, generator="car_sequence"
    )
    @SequenceGenerator( name="car_sequence",
    	sequenceName="car_sequence",
    	initialValue=1, allocationSize=3
    )
    private Long id;
    
    private static final long serialVersionUID = 1L;
    
}
