package sk4j.impl.tool;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import sk4j.api.Context;
import sk4j.api.model.EJavaClass;
import sk4j.api.model.EJavaPackage;
import sk4j.api.tool.JavaProjectTool;

public class JavaProjectToolImpl implements JavaProjectTool {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Override
	public List<EJavaClass> findAllJPAEntities() {
		//@formatter:off
		return context.getJavaProject().getSrcMainJavaClasses()
					.stream()
					.filter(javaClass -> javaClass.hasAnnotationByName("Entity"))
					.collect(Collectors.toList());
		//@formatter:on
	}

	@Override
	public List<EJavaClass> findAllDemoiselleBCs() {
		//@formatter:off
		return context.getJavaProject().getSrcMainJavaClasses()
					.stream()
					.filter(javaClass -> javaClass.extendsSuperClassByName("DelegateCrud"))
					.collect(Collectors.toList());
		//@formatter:on
	}

	@Override
	public List<EJavaClass> findAllDemoiselleDAOs() {
		//@formatter:off
		return context.getJavaProject().getSrcMainJavaClasses()
					.stream()
					.filter(javaClass -> javaClass.extendsSuperClassByName("JPACrud"))
					.collect(Collectors.toList());
		//@formatter:on
	}

	@Override
	public List<EJavaClass> findAllDemoiselleViewControllers() {
		//@formatter:off
		return context.getJavaProject().getSrcMainJavaClasses()
					.stream()
					.filter(javaClass -> javaClass.hasAnnotationByName("ViewController"))
					.collect(Collectors.toList());
		//@formatter:on
	}

	@Override
	public List<EJavaClass> findAllDemoiselleFacades() {
		//@formatter:off
		return context.getJavaProject().getSrcMainJavaClasses()
					.stream()
					.filter(javaClass -> javaClass.hasAnnotationByName("FacadeController"))
					.collect(Collectors.toList());
		//@formatter:on
	}

	@Override
	public List<EJavaClass> findDemoiselleBCByJPAEntity(EJavaClass javaClass) {
		//@formatter:off
		return findAllDemoiselleBCs()
				.stream().filter(bc -> bc.hasSuperClassGenericNameByNameAndIndex(javaClass.getName(), 0))
				.collect(Collectors.toList());
		//@formatter:on
	}

	@Override
	public List<EJavaPackage> findAllViewPackages() {
		//@formatter:off
		return context.getJavaProject().getSrcMainJavaPackages()
					.stream()
					.filter(javaPackage -> javaPackage.getName().endsWith("Page") || javaPackage.getName().endsWith("view"))
					.collect(Collectors.toList());
		//@formatter:on
	}

}
