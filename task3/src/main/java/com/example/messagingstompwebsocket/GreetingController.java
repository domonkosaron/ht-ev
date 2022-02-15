package com.example.messagingstompwebsocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class GreetingController {

	private final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Greeting greeting = new Greeting( HtmlUtils.htmlEscape(message.getIpAddress()) + " wrote: " + HtmlUtils.htmlEscape(message.getName()));

		try {
			FileWriter myWriter = new FileWriter("socket.log", true);
			myWriter.write(greeting.getContent() + '\n');
			myWriter.close();
			logger.info("Successfully wrote to the file.");
		} catch (IOException e) {
			logger.info("An error occurred.");
		}

		return greeting;
	}

}
