package br.senaigo.mobile.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.senaigo.mobile.entities.Product;
import br.senaigo.mobile.repositories.ProductRepository;
import br.senaigo.mobile.service.ProductService;

public class ProductServiceImpl implements ProductService {

	/**
	 * @see http://appsdeveloperblog.com/spring-boot-logging-with-loggerfactory/
	 */
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	public ProductRepository productRepository;
	
	@Override
	@Transactional
	public Product post(Product product) {
		try {
			logger.debug("\tMétodo POST executado.");
			logger.debug("\tMétodo POST invocado");
			logger.debug(String.format("\tValor recebido: %s",product.toString()));
			
			productRepository.save(product);
			
			logger.info(String.format("\tValor persistido: %s",product.toString()));
			return product;
		} catch (Exception e) {
			logger.error(String.format("Error ao persistir registro. \nMensagem:%s",e.getMessage()));
		}
		return null;
	}
	
	@Override
	public Product get(Product product) {
		try {
			productRepository.getOne(product.getIdProduct());
		} catch (Exception e) {
			logger.error("Error ao recuperar GET.");
		}
		return null;
	}
	
	@Override
	@Transactional
	public void put(Product product) {
		try {
			productRepository.getOne(product.getIdProduct());
		} catch (Exception e) {
			logger.error("Error ao recuperar GET.");
		}
	}

	@Override
	@Transactional
	public void delete(Product product) {
		try {
			productRepository.delete(product);
		} catch (Exception e) {
			logger.error("Error ao deletar registro.");
		}
		
	}
	
	@Override
	@Transactional
	public void patch(Product entity) {
		try {
			productRepository.save(entity);
			logger.info(String.format("Registro atualizado: %s", entity.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PATCH.\nMensagem: %s", e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public List<Product> post(List<Product> entities) {
		try {
			entities.forEach(entity -> {
				productRepository.save(entity);
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
	public void put(List<Product> entities) {
		try {
			entities.forEach(entity -> {
				productRepository.save(entity);
				logger.info(String.format("Registro atualizado: %s", entity.toString()));
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PUT.\nMensagem: %s",e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public void delete(List<Product> entities) {
		try {
			entities.forEach(entity -> {
				productRepository.delete(entity);
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar DELETE.\nMensagem: %s",e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public void patch(List<Product> entities) {
		try {
			entities.forEach(entity -> {
				productRepository.save(entity);
				logger.info(String.format("Registro atualizado: %s", entity.toString()));
			});
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PATCH.\nMensagem: %s",e.getMessage()));
		}
	}

	@Override
	public List<Product> get() {
		try {
			return productRepository.findAll();
		} catch (Exception e) {
			logger.error("Error ao recuperar registro." +e.getMessage());
		}
		return null;
	}

}
