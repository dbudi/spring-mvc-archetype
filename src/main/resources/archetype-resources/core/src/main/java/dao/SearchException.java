#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

/**
 *
 * @author jgarcia
 */
public class SearchException extends RuntimeException {

    public SearchException(Throwable ex) {
        super(ex);
    }

}
