package com.restapi.controller;
import java.util.concurrent.atomic.AtomicLong;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Greeting;
@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final Log log = LogFactory.getLog(GreetingController.class);
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	@GetMapping
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		log.info("GreetingController.greeting()");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}