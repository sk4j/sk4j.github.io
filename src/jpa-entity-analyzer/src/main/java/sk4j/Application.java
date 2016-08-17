package sk4j;

import java.io.Serializable;
import javax.enterprise.event.Observes;
import sk4j.event.AfterStart;

public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void run(@Observes AfterStart event) {
		//TODO
	}
}