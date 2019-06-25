package br.senaigo.mobile.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import br.senaigo.mobile.entities.Order;
import br.senaigo.mobile.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	@Transactional
	public Order post(Order entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order get(Order entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void put(Order entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(Order entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void patch(Order entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Order> post(List<Order> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void put(List<Order> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(List<Order> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void patch(List<Order> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> get() {
		// TODO Auto-generated method stub
		return null;
	}

}
