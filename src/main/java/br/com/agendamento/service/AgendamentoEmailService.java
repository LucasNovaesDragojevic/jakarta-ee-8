package br.com.agendamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agendamento.dao.AgendamentoEmailDao;
import br.com.agendamento.model.AgendamentoEmail;

@Stateless
public class AgendamentoEmailService  implements Serializable
{
	private static final long serialVersionUID = 1L; 
	
	private static final Logger LOOGER = Logger.getLogger(AgendamentoEmail.class.getName());
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;
	
	public List<AgendamentoEmail> listar()
	{
		return agendamentoEmailDao.listar();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail)
	{
		agendamentoEmail.setAgendado(false);
		agendamentoEmailDao.inserir(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarPorNaoAgendado()
	{
		return agendamentoEmailDao.listarPorNaoAgendado();
	}
	
	public void alterar(AgendamentoEmail agendamentoEmail)
	{
		agendamentoEmail.setAgendado(true);
		agendamentoEmailDao.alterar(agendamentoEmail);
	}
	
	public void enviar(AgendamentoEmail agendamentoEmail)
	{
		try
		{
			Thread.sleep(500);
			LOOGER.info("O e-mail " + agendamentoEmail.getAssunto() + " foi enviado.");
		}
		catch(Exception exception)
		{
			LOOGER.warning(exception.getMessage());
		}
	}
}
