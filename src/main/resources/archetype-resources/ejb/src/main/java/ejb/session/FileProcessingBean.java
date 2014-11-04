#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.ejb.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author budi
 *
 */
@Stateless
public class FileProcessingBean implements FileProcessing {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
	private EntityManager entityManager;
	

	/* (non-Javadoc)
	 * @see ${package}.ejb.session.FileProcessing${symbol_pound}callProcedureReadCsv(java.lang.String)
	 */
	@Override
	public int callProcedureReadCsv(String csvFileName) {
		logger.info("call procedure to read file {} and insert to db", csvFileName);
		/*String query = 
            "CALL P_KIRIM_CSV('" + csvFileName + "')";*/
		
		String query = "SELECT KODE,DESKRIPSI FROM ADM_R_SDATA";
        
        logger.info(">> Query: " + query);
        
        //Query sqlQuery = createQuery(query, null);
        //sqlQuery.executeUpdate();
        
//        int result = entityManager.createNativeQuery(query).executeUpdate();
        List list = entityManager.createNativeQuery(query).getResultList();
        
        logger.info("list size={}", list.size());
		return 0;
	}

}
