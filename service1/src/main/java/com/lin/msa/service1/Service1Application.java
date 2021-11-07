package com.lin.msa.service1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "Service1 is running...";
	}

	@RequestMapping("/data")
	public String getName() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return "{\"id\":1, \"name\":\"Service1\", \"timestamp\":\""+timeStamp+"\"}";
	}
}
