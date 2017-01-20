package com.felipegama.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/exemplors")
public class Exemplors {
	@GET
	public String listar(){
		return "teste rest GET";
	}

}
