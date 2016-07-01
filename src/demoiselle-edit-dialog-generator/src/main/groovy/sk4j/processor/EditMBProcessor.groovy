package sk4j.processor

import sk4j.DelegateProcessor

/**
 * Gerador do managed bean EditMB
 * 
 * @author jcruz
 *
 */
class EditMBProcessor extends DelegateProcessor {

	@Override
	public void execute() {
		fs.createFile path: "${context.selectedPagePackage.file.absolutePath}",
					  name: "${context.editMBName}.java" ,
					  template: "edit-xhtml"
	}
}
