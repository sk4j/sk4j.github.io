package sk4j

/**
 * 
 * @author jcruz
 *
 */
abstract class GeneratorTask extends Task {

	/**
	 * 
	 */
	abstract void generate()

	/**
	 * 
	 */
	@Override
	public void doTask() {
		generate()
	}
}
