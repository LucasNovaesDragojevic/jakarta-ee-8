package br.com.agendamento.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.agendamento.model.AgendamentoEmail;

@Stateless
@Transactional
public class AgendamentoEmailDao 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<AgendamentoEmail> listar()
	{
		return entityManager.createQuery("SELECT a FROM AgendamentoEmail a", AgendamentoEmail.class).getResultList();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail)
	{
		entityManager.persist(agendamentoEmail);
	}
}
