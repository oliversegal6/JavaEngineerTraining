package demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by admin on 2017/12/23.
 */
public class ServiceRequest
{
    public static final String ACTIVEMQ_HOST = "localhost";
    public static final int ACTIVEMQ_PORT = 61616;
    public static final String ACTIVEMQ_USER = "admin";
    public static final String ACTIVEMQ_PASSWORD = "admin";
    public static final String QUEUE_NAME = "SERVICE_REQUEST_QUEUE";

    public static void main(String[] args) throws JMSException
    {
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        String url = "tcp://" + ACTIVEMQ_HOST + ":" + ACTIVEMQ_PORT;

        connectionFactory = new ActiveMQConnectionFactory(url);
        connection = connectionFactory.createConnection(ACTIVEMQ_USER, ACTIVEMQ_PASSWORD);
        connection.start();

        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer messageProducer = session.createProducer(queue);
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for(int i = 0; i < 5; i++)
        {
            TextMessage textMessage = session.createTextMessage("Message" + i);
            messageProducer.send(textMessage);
        }

        messageProducer.send(session.createTextMessage("SHUTDOWN"));
        connection.close();
    }
}
