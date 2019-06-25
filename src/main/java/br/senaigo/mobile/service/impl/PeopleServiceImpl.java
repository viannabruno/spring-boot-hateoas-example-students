package br.senaigo.mobile.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senaigo.mobile.entities.People;
import br.senaigo.mobile.repositories.PeopleRepository;
import br.senaigo.mobile.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {

	/**
	 * @see http://appsdeveloperblog.com/spring-boot-logging-with-loggerfactory/
	 */
	Logger logger = LoggerFactory.getLogger(PeopleServiceImpl.class);
	
	@Autowired
	public PeopleRepository peopleRepository;
	
	@Override
	@Transactional
	public People post(People people) {
		try {
			logger.debug("\tMétodo POST executado.");
			logger.debug("\tMétodo POST invocado");
			logger.debug(String.format("\tValor recebido: %s",people.toString()));
			
			peopleRepository.save(people);
			
			logger.info(String.format("\tValor persistido: %s",people.toString()));
			return people;
		} catch (Exception e) {
			logger.error(String.format("Error ao persistir registro. \nMensagem:%s",e.getMessage()));
		}
		return null;
	}
	
	@Override
	public People get(People people) {
		try {
			peopleRepository.getOne(people.getIdPeople());
		} catch (Exception e) {
			logger.error("Error ao recuperar GET.");
		}
		return null;
	}
	
	@Override
	@Transactional
	public void put(People People) {
		try {
			peopleRepository.getOne(People.getIdPeople());
		} catch (Exception e) {
			logger.error("Error ao recuperar GET.");
		}
	}

	@Override
	@Transactional
	public void delete(People People) {
		try {
			peopleRepository.delete(People);
		} catch (Exception e) {
			logger.error("Error ao deletar registro.");
		}
		
	}
	
	@Override
	@Transactional
	public void patch(People entity) {
		try {
			peopleRepository.save(entity);
			logger.info(String.format("Registro atualizado: %s", entity.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PATCH.\nMensagem: %s", e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public List<People> post(List<People> entities) {
		try {
			entities.forEach(entity -> {
				peopleRepository.save(entity);
				logger.info(String.format("Registro atualizado: %s", entity.toString()));
			});
			return entities;
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar POST.\nMensagem: %s", e.getMessage()));
		}
		return entities;
	}
	
	@Override
	@Transactional
	public void put(List<People> entities) {
		try {
			entities.forEach(entity -> {
				peopleRepository.save(entity);
				logger.info(String.format("Registro atualizado: %s", entity.toString()));
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PUT.\nMensagem: %s",e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public void delete(List<People> entities) {
		try {
			entities.forEach(entity -> {
				peopleRepository.delete(entity);
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar DELETE.\nMensagem: %s",e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public void patch(List<People> entities) {
		try {
			entities.forEach(entity -> {
				peopleRepository.save(entity);
				logger.info(String.format("Registro atualizado: %s", entity.toString()));
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PATCH.\nMensagem: %s",e.getMessage()));
		}
	}

	@Override
	public List<People> get() {
		try {
			return peopleRepository.findAll();
		} catch (Exception e) {
			logger.error("Error ao recuperar registro." +e.getMessage());
		}
		return null;
	}

}
