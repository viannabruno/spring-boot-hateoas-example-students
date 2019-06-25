package br.senaigo.mobile.controlller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.senaigo.mobile.entities.Product;
import br.senaigo.mobile.interfaces.GenericOperationsController;
import br.senaigo.mobile.service.impl.ProductServiceImpl;

public class ProductController implements GenericOperationsController<Product>{
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductServiceImpl productService;
	
	@Override
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
				 produces = {MediaType.APPLICATION_JSON_VALUE,
						 	 MediaType.APPLICATION_XML_VALUE,
						 	 MediaTypes.HAL_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public Resource<Product> post(Product product) {

		try {
			productService.post(product);
			logger.info("Registro inserido");

			Link link = linkTo(ProductController.class).slash(product.getId()).withSelfRel();
			Resource<Product> result = new Resource<Product>(product,link);
			return result;
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar POST.\nMensagem: %s",e.getMessage()));
		}
		return null;

	}

	@Override
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public void put(Product entity) {
		try {
			productService.put(entity);
			logger.info(String.format("Registro atualizado: %s",entity.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PUT.\nMensagem: %s",e.getMessage()));
		}
		
	}
	
	@Override
	@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Product entity) {
		try {
			productService.delete(entity);
			logger.info(String.format("Registro(s) deletado(s): %s",entity.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PUT.\nMensagem: %s",e.getMessage()));
		}
		
	}
	
	@Override
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE,
			MediaTypes.HAL_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Resources<Product> get() {
		try {
			List<Product> products = productService.get();

			logger.info(String.format("Registro(s) recuperados(s): %s",products.toString()));

			for (final Product product : products) {
				Link selfLink = linkTo(ProductController.class)
						.slash(product.getIdProduct())
						.withSelfRel();
				product.add(selfLink);
			}
			Link link = linkTo(ProductController.class).withSelfRel();
			Resources<Product> result = new Resources<>(products, link);

			return result;

		} catch (Exception e) {
			logger.error(String.format("Erro ao executar GET.\nMensagem: %s",e.getMessage()));
		}
		return null;
	}
	
	@Override
	@GetMapping(value="/{id}",
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE,
					MediaTypes.HAL_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Resource<Product> get(@PathVariable Long id) {
		try {
			Product product = productService.get(Product.builder().idProduct(id).build());
			logger.info(String.format("Registro recuperado: %s",product.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar GET.\nMensagem: %s",e.getMessage()));
		}
		return null;
	}

	@Override
	@PatchMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void patch(Product entity) {
		try {
			productService.patch(entity);
			logger.info(String.format("Registro atualizado: %s",entity.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar PATCH.\nMensagem: %s",e.getMessage()));
		}
	}

}
