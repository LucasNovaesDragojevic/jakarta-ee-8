package br.com.agendamento.service;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailService 
{
	public List<String> listar()
	{
		return List.of("lucas@email.com");
	}
}
