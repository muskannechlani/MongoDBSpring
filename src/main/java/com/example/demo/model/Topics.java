package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Topics")
public class Topics {

	@Id
	private int topicID;
	private String topicName;
	private String topicData;
	public int getTopicID() {
		return topicID;
	}
	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicData() {
		return topicData;
	}
	public void setTopicData(String topicData) {
		this.topicData = topicData;
	}
	@Override
	public String toString() {
		return "Topics [topicID=" + topicID + ", topicName=" + topicName + ", topicData=" + topicData + "]";
	}
}
