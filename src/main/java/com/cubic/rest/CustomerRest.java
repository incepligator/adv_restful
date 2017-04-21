package com.cubic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.service.CustomerService;
import com.cubic.vo.CustomerVO;

//sudeep and me

@Service
@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRest {
	
	@Autowired
	private CustomerService service;
	
	@POST
	public Response create(final CustomerVO vo){
		CustomerVO result=service.save(vo);
		return Response.ok().entity(result).build();
		
	}
	
	@PUT
	public Response update(final CustomerVO vo){
		CustomerVO result=service.save(vo);
		return Response.ok().entity(result).build();
	}
	
	@GET
	@Path("/{id}")
	public Response findCustomer(@PathParam("id") final Long pk){
		CustomerVO result=service.findCustomer(pk);
		return Response.ok().entity(result).build();
	}
	
	@GET
	//@Path("/{id}")
	public Response searchCustomer(@QueryParam("searchStr") final String name){
		List<CustomerVO> result=service.search(name);
		return Response.ok().entity(result).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") final Long pk){
		service.remove(pk);
		return Response.noContent().build();
	}
	

	/*@POST
	@Path("/cust")//only required path if there are multiple POST method
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCustomer(CustomerEntity customer) {

		Database.add(customer);
		return Response.status(200).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCustomerbyId(@PathParam("id") String id) {

		CustomerEntity customer = Database.getById(id);

		return Response.ok().entity(customer).build();
	}*/

}
