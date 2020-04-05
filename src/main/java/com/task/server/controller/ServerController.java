package com.task.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.task.server.model.Server;
import com.task.server.service.ServerService;

@RestController
public class ServerController {
	
	@Autowired
	private ServerService serverService;
	
	@RequestMapping("/create")
	public Server createServer(@RequestBody Server server) {
		return serverService.create(server);
	}
	
	@RequestMapping("/get")
	public List<Server> getAll() {
		return serverService.getAll();
	}
	
	@RequestMapping("/get/name")
	public Server getServerByName(@RequestParam String name) {
		
		Server server = serverService.getServerByName(name);
		if(server == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
		else
		return serverService.getServerByName(name);
	}
	
	@RequestMapping("/get/")
	public Optional<Server> getServerById(@RequestParam String id) {
		
		Optional<Server> server = serverService.getServerById(id);
		if(!server.isPresent()) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
		else
		return serverService.getServerById(id);
	}
	
	@RequestMapping("/remove/")
	public String deleteServerById(@RequestParam String id ) {
		serverService.delete(id);
		return "Deleted "+id;
	}
}
