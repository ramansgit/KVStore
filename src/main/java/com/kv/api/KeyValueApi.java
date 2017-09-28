package com.kv.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.JsonNode;
import com.kv.model.ApiResponseMessage;
import com.kv.model.KVData;
import com.kv.model.Message;
import com.kv.service.KeyValueService;
import com.kv.service.KeyValueServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/api/v1/kv")
@Api(description = "kv API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T14:43:58.709Z")

public class KeyValueApi {

	private final KeyValueService delegate = new KeyValueServiceImpl();

	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@ApiOperation(value = "insert key values", notes = "insert key values", response = ApiResponseMessage.class, tags = {
			"KVApi" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = ApiResponseMessage.class) })
	public Response insertkeyValue(@ApiParam(value = "") KVData body, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		delegate.put(body.getKey(), body.getValue());

		return Response.status(Status.OK).entity(new ApiResponseMessage(new Message("Record created"))).build();
	}

	@DELETE
	@Path("/{key}")
	@ApiOperation(value = "delete key", notes = "delete key", response = ApiResponseMessage.class, tags = { "KVApi" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = ApiResponseMessage.class) })
	public Response delete(@ApiParam(value = "key") @PathParam("key") String key, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		delegate.delete(key);
		return Response.status(Status.OK).entity(new ApiResponseMessage(new Message("Record Deleted"))).build();
	}

	@GET
	@Path("/{key}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@ApiOperation(value = "get by key", notes = "get by key", response = ApiResponseMessage.class, tags = { "KVApi" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = ApiResponseMessage.class) })
	public Response getRecord(@ApiParam(value = "key") @PathParam("key") String key,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonNode data = delegate.get(key);

		return Response.status(Status.OK).entity(new ApiResponseMessage(data)).build();
	}

}
