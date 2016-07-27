package sk4j.processor;

import sk4j.core.Processor;
import sk4j.core.ProcessorId;

/**
 * 
 * @author jcruz
 *
 */
@ProcessorId(2)
public class EditMBAndXHTMLProcessor implements Processor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void process() {
		System.out.println("EditMBAndXHTMLProcessor");
	}

}
