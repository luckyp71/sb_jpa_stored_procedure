package com.example.sb_stored_procedure.service_impls;

import org.springframework.stereotype.Service;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import com.example.sb_stored_procedure.models.CustomerCustom;
import com.example.sb_stored_procedure.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public CustomerCustom findCustomCustomerById(Long id) {
		StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("findCustomCustomerById") 
									.setParameter("cust_id", id);
		return (CustomerCustom) sp.getSingleResult();
	}

}
