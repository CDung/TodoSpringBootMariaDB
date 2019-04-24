package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.repo.ItemRepository;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

@RestController
@RequestMapping("/api")
public class TodoController {
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping(value="/items")
	public ResponseEntity<String> getAllIteams() {		
		JSONObject result=new JSONObject();
		
		try {
			List<Item> items = new ArrayList<>();
			itemRepository.findAll().forEach(items::add);		
			if(0==items.size()) {
				result.put("StatusCode", 110);
				result.put("Message", "Success, but data is empty");
			}else {
				result.put("StatusCode",111);
				result.put("Message", "Success");
				result.put("Data", items);
			}
		}catch(Exception e){
			result.put("StatusCode", 0);
			result.put("Message", "Failed");
		}
		
		return new ResponseEntity<>(result.toJSONString(),HttpStatus.OK);
	}
	
	@PostMapping(value="/item")
	public ResponseEntity<String> newItem(@RequestBody Item item) {		
		JSONObject result=new JSONObject();
		
		try {			
			result.put("Data", itemRepository.save(item));
			result.put("StatusCode", 121);
			result.put("Message", "Success");				
		}catch(Exception e){
			result.put("StatusCode",0);
			result.put("Message", "Failed: "+e.getMessage());			
		}
		
		return new ResponseEntity<>(result.toJSONString(),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/items")
	public ResponseEntity<String> deleteAllIteams() {		
		JSONObject result=new JSONObject();
		
		try {
			itemRepository.deleteAll();
			result.put("StatusCode", 120);
			result.put("Message", "Success");				
		}catch(Exception e){
			result.put("StatusCode",0);
			result.put("Message", "Failed: "+e.getMessage());			
		}
		
		return new ResponseEntity<>(result.toJSONString(),HttpStatus.OK);
	}
}
