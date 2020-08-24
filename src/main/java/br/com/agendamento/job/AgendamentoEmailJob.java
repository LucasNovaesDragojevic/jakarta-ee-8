package br.com.agendamento.job;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.agendamento.model.AgendamentoEmail;
import br.com.agendamento.service.AgendamentoEmailService;

@Singleton
public class AgendamentoEmailJob 
{	
	@Inject
	private AgendamentoEmailService agendamentoEmailService;
	
	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void enviarEmail()
	{
		List<AgendamentoEmail> listaEmailsNaoAgendados = agendamentoEmailService.listarPorNaoAgendado();
		listaEmailsNaoAgendados.forEach(email -> {
			agendamentoEmailService.enviar(email);
			agendamentoEmailService.alterar(email);
		});
	}
}
