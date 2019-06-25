package br.senaigo.mobile.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senaigo.mobile.entities.Order;
import br.senaigo.mobile.repositories.OrderRepository;
import br.senaigo.mobile.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	/**
	 * @see http://appsdeveloperblog.com/spring-boot-logging-with-loggerfactory/
	 */
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	public OrderRepository orderRepository;
	
	@Override
	@Transactional
	public Order post(Order order) {
		try {
			logger.debug("\tMétodo POST executado.");
			logger.debug("\tMétodo POST invocado");
			logger.debug(String.format("\tValor recebido: %s",order.toString()));
			
			orderRepository.save(order);
			
			logger.info(String.format("\tValor persistido: %s",order.toString()));
			return order;
		} catch (Exception e) {
			logger.error(String.format("Error ao persistir registro. \nMensagem:%s",e.getMessage()));
		}
		return null;
	}
	
	@Override
	public Order get(Order order) {
		try {
			orderRepository.getOne(order.getIdOrder());
		} catch (Exception e) {
			logger.error("Error ao recuperar método GET.");
		}
		return null;
	}
	
	@Override
	@Transactional
	public void put(Order order) {
		try {
			orderRepository.getOne(order.getIdOrder());
		} catch (Exception e) {
			logger.error("Error ao recuperar método GET.");
		}
	}

	@Override
	@Transactional
	public void delete(Order order) {
		try {
			orderRepository.delete(order);
		} catch (Exception e) {
			logger.error("Error ao deletar registro.");
		}
		
	}
	
	@Override
	@Transactional
	public void patch(Order entity) {
		try {
			orderRepository.save(entity);
			logger.info(String.format("Registro atualizado: %s", entity.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o metodo PATCH.\nMensagem: %s", e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public List<Order> post(List<Order> entities) {
		try {
			entities.forEach(entity -> {
				orderRepository.save(entity);
				logger.info(String.format("Registro atualizado: %s", entity.toString()));
			});
			return entities;
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o metodo POST.\nMensagem: %s", e.getMessage()));
		}
		return entities;
	}
	
	@Override
	@Transactional
	public void put(List<Order> entities) {
		try {
			entities.forEach(entity -> {
				orderRepository.save(entity);
				logger.info(String.format("Registro atualizado: %s", entity.toString()));
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o metodo PUT.\nMensagem: %s",e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public void delete(List<Order> entities) {
		try {
			entities.forEach(entity -> {
				orderRepository.delete(entity);
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o metodo DELETE.\nMensagem: %s",e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public void patch(List<Order> entities) {
		try {
			entities.forEach(entity -> {
				orderRepository.save(entity);
				logger.info(String.format("Registro atualizado: %s", entity.toString()));
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o metodo PATCH.\nMensagem: %s",e.getMessage()));
		}
	}

	@Override
	public List<Order> get() {
		try {
			return orderRepository.findAll();
		} catch (Exception e) {
			logger.error("Error ao recuperar registro." +e.getMessage());
		}
		return null;
	}

}
