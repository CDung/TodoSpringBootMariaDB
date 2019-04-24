package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.json.simple.JSONObject;

@Entity
public class Item {
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="work")
	private String work;
	
	@Column(name="done")
	private boolean done;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	public String toString() {
		JSONObject result=new JSONObject();
		result.put("id", id);
		result.put("work", work);
		result.put("done", done);
		return result.toString();
	}
}
