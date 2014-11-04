#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.ejb.mdb;

import ${package}.ejb.session.FileProcessing;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author budi
 *
 */
@MessageDriven(name = "IncomingFileMdb", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/mdb"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "100")})
public class IncomingFileMdb implements MessageListener{
	private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private MessageDrivenContext mdbContext;    
    
    @EJB
    private FileProcessing fileProcessing;
    
    @PostConstruct
    public void initialize() {
    	
    }

    @PreDestroy
    public void cleanup() {
        // destroy resource
    }   
	@Override
	public void onMessage(Message message) {
		try{
			logger.info("Received message {}", message);
			if (message instanceof TextMessage){
				long startTime = System.currentTimeMillis();	
				
    			TextMessage textMsg = (TextMessage) message;   
    			logger.info("Received text {}", textMsg.getText());
    			
				logger.info("batch process (synchronize status of msisdn="+textMsg.getText()+") has been executed successfully in "
						+ ((System.currentTimeMillis() - startTime)) + " ms. END TIME = "+new Date());				
    		} else if (message instanceof MapMessage) {
    			MapMessage mapMessage = (MapMessage) message;
    			logger.info("Received MapMessage");
    			logger.info("camelfilenameonly={}", mapMessage.getString("camelfilenameonly"));
    			logger.info("camelfileabsolutepath={}", mapMessage.getString("camelfileabsolutepath"));
    			logger.info("camelfilelastmodified={}", mapMessage.getString("camelfilelastmodified"));
    			logger.info("breadcrumbid={}", mapMessage.getString("breadcrumbid"));
    			fileProcessing.callProcedureReadCsv(mapMessage.getString("camelfilenameonly"));
    		} else {    		
    			logger.error("Message format not valid, i.e not TextMessage or MapMessage");
    		}
		}catch(JMSException jmsEx){
			mdbContext.setRollbackOnly();
			logger.error("Failed received message: "+message, jmsEx);    		
    		throw new EJBException(jmsEx);
		}catch(Exception e){
			mdbContext.setRollbackOnly();
			logger.error("Failed received message:"+message, e);    		
    		throw new EJBException(e);
		}
		
	}

}
