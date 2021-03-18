package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Topics;
import com.example.demo.repository.TopicDAO;

import net.logstash.logback.argument.StructuredArguments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TopicController {
@Autowired
		TopicDAO topicdao;

	private static final Logger logger = LoggerFactory.getLogger(TopicController.class);


//	public  TopicController(TopicDAO topicdao) {
//		this.topicdao=topicdao;
//		// TODO Auto-generated constructor stub
//	}
	@PostMapping("/topic")
	public String AddTopic(@RequestBody Topics topic)
	{
		try {
			logger.info("Adding topic");
			topicdao.save(topic);
		}
		catch(Exception e) {
			logger.error("System Error:",e.getMessage());
			return e.getMessage();
		}
		return "Sucessfully Added";
	}
	@GetMapping("/getTopics")
	public List<Topics> getAllTopics()
	{
		ArrayList<Topics> result;
		try {
		logger.info("Getting All topics");
		result =(ArrayList<Topics>) topicdao.findAll();
		}
		catch(Exception e) {
			System.out.println("--------------------- error");
			logger.error("System Error:",e.getMessage());
			return null;
		}
		return result;
	}
	@GetMapping("/getTopics/{id}")
	public Optional<Topics> getAllTopics(@PathVariable Integer id)
	{
		Optional<Topics> topic;
		try {
		logger.info("Getting particular topic ",StructuredArguments.value("FindID", id));
		topic = topicdao.findById(id);
		}
		catch(Exception e) {
			System.out.println("Got error");
			logger.error("System Error:",e.getMessage());
			return null;
		}
		return topic;
	}

	@GetMapping("/deleteTopic/{id}")
	public String deleteTopic(@PathVariable Integer id)
	{
		try {
		logger.info("Deleting topic ",StructuredArguments.value("FindID", id));
		
		topicdao.deleteById(id);
		}catch(Exception e) {
			logger.error("System Error:",e.getMessage());
			return "Error while deleting";
		}
		return "Deleted ";
	}
}