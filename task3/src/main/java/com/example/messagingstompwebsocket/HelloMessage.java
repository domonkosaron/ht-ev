package com.example.messagingstompwebsocket;

public class HelloMessage {

	private String name;

	private String ipAddress;

	public HelloMessage() {
	}

	public HelloMessage(String name, String ipAddress) {
		this.name = name;
		this.ipAddress = ipAddress;
	}

	public String getName() {
		return name;
	}

	public String getIpAddress() { return ipAddress; }

	public void setName(String name) {
		this.name = name;
	}

	public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
}
