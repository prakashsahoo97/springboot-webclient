package in.ashokit.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.binding.Book;

@Service
public class BookClient {
	
	static WebClient client=WebClient.create();
	
	public void invokeAddBook() {
		String url="http://localhost:8080/book";
		
		Book book=new Book();
		book.setBookName("Angular");
		book.setBookPrice(490.896);
		
		String response=client.post()
								.uri(url)
								.bodyValue(book)
								.retrieve()
								.bodyToMono(String.class)
								.block();
		System.out.println(response);		
	}
	
	public void invokeGetAllBook() {
		String url="http://localhost:8080/books";
		
		List<Book> list =Arrays.asList( client.get()
												.uri(url)
												.retrieve()
												.bodyToMono(Book[].class)
												.block());
		list.forEach(book->System.out.println(book));
		
		
	}
	
	public void invokeGetAllBookAsynchronous() {
		String url="http://localhost:8080/books";
		
		client.get()
			  .uri(url)
			  .retrieve()
			  .bodyToMono(Book[].class)
		      .subscribe(BookClient::respHandler);
		System.out.println("************************Request Sent*************************");
	}
	
	public static void respHandler(Book[] book) {
		Arrays.asList(book).forEach(books ->System.out.println(books));
	}

}
