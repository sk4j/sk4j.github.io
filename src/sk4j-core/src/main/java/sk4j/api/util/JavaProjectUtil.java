package sk4j.api.util;

import java.io.Serializable;
import java.util.List;

import sk4j.api.model.EJavaClass;
import sk4j.api.model.EJavaPackage;

/**
 * 
 * Ferramentas para Projetos Java.
 * 
 * @author jcruz
 *
 */
public interface JavaProjectUtil extends Serializable {

	/**
	 * Retorna a lista de todas as entidades JPA do projeto.
	 * 
	 * @return Entidades JPA.
	 */
	List<EJavaClass> findAllJPAEntities();

	/**
	 * Retorna a lista de Business Controllers (BC) Demoiselle.
	 * 
	 * @return Business Controllers.
	 */
	List<EJavaClass> findAllDemoiselleBCs();

	/**
	 * Retorna a lista de Persistence Controllers (DAO) Demoiselle.
	 * 
	 * @return Persistence Controllers.
	 */
	List<EJavaClass> findAllDemoiselleDAOs();

	/**
	 * Retorna a lista de View Controllers (Managed Beans) Demoiselle.
	 * 
	 * @return View Controllers.
	 */
	List<EJavaClass> findAllDemoiselleViewControllers();

	/**
	 * Retorna a lista de Facade Controllers Demoiselle.
	 * 
	 * @return Facade Controllers.
	 */
	List<EJavaClass> findAllDemoiselleFacades();

	/**
	 * Retorna a lista de packages view.
	 * 
	 * @return
	 */
	List<EJavaPackage> findAllViewPackages();

	/**
	 * Retorna a lista de BCs de uma entidade JPA.
	 * 
	 * @param javaClass
	 *            Entidade JPA
	 * @return Lista de BCs.
	 */
	List<EJavaClass> findDemoiselleBCByJPAEntity(EJavaClass javaClass);

}
