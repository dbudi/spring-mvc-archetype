#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.ejb.session;

import javax.ejb.Local;

/**
 * @author budi
 *
 */
@Local
public interface FileProcessing {
	public int callProcedureReadCsv(String csvFileName); 
}
