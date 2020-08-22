package br.com.agendamento.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agendamento.dao.AgendamentoEmailDao;
import br.com.agendamento.model.AgendamentoEmail;

@Stateless
public class AgendamentoEmailService  implements Serializable
{
	private static final long serialVersionUID = 1L; 
	
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
}
