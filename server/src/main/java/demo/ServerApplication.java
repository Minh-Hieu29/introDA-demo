package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import demo.api.book.BookItemAPI;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
//		ApplicationContext context = SpringApplication.run(ServerApplication.class, args);
//		BookItemAPI bookItemAPI = context.getBean(BookItemAPI.class);
//		BookAPI bookAPI = context.getBean(BookAPI.class);
	}

}
