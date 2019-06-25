package br.senaigo.mobile.controlller;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.senaigo.mobile.entities.People;
import br.senaigo.mobile.interfaces.GenericOperationsController;

public class PeopleController implements GenericOperationsController<People> {

	@Override
	public Resource<People> post(People entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(People entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(People entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resources<People> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource<People> get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void patch(People entity) {
		// TODO Auto-generated method stub
		
	}

}
