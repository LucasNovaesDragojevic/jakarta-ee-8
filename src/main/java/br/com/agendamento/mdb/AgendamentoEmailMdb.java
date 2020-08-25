package br.com.agendamento.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.com.agendamento.model.AgendamentoEmail;
import br.com.agendamento.service.AgendamentoEmailService;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class AgendamentoEmailMdb implements MessageListener
{
	@Inject
	private AgendamentoEmailService agendamentoEmailService;

	@Override
	public void onMessage(Message message) 
	{
		try 
		{
			AgendamentoEmail agendamentoEmail = message.getBody(AgendamentoEmail.class);
			agendamentoEmailService.enviar(agendamentoEmail);
		} 
		catch (JMSException exception) 
		{
			throw new RuntimeException(exception);
		}
	}
}
