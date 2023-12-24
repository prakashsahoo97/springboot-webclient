package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.client.BookClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
							SpringApplication.run(Application.class, args);
		BookClient bookClient = context.getBean(BookClient.class);
//		bookClient.invokeAddBook();
//		bookClient.invokeGetAllBook();
		bookClient.invokeGetAllBookAsynchronous();
	}

}
