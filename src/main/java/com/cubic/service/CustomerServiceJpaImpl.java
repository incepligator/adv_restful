package com.cubic.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cubic.entity.CustomerEntity;
import com.cubic.vo.CustomerVO;


@Service
@Transactional
public class CustomerServiceJpaImpl implements CustomerService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CustomerMapper mapper;

	
	
	public CustomerVO save(final CustomerVO vo) {
		CustomerEntity entity=null;
		
		if(vo.getPk()==null){
			entity=mapper.mapToCustomerEntity(vo);
			
		}else{
			entity=em.find(CustomerEntity.class, vo.getPk());
			entity=mapper.mapToCustomerEntity(entity,vo);
		}
		em.persist(entity);
		vo.setPk(entity.getPk());
		return vo;
	}

	
	
	public List<CustomerVO> search(String name) {
	
		//if(StringUtils.isEmpty(name)||name.trim().length()<4)
			
			List<CustomerEntity> entities;
			
			String queryParam=name.trim()+"%";
			TypedQuery<CustomerEntity> query=em.createNamedQuery("CustomerEntity.search",CustomerEntity.class);
			
			query.setParameter("p1", queryParam);
			query.setParameter("p2", queryParam);
			entities=query.getResultList();
			
			
		
		return mapper.mapToCustomerVOList(entities);
	}

	
	
	public void remove(Long pk) {
		CustomerEntity entity=em.find(CustomerEntity.class, pk);
		em.remove(entity);
		
	}

	
	
	public CustomerVO findCustomer(Long pk) {
		CustomerEntity entity=em.find(CustomerEntity.class, pk);
		return mapper.mapToCustomerVO(entity);
		
	}

}