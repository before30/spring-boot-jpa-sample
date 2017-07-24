package cc.before30.sample;

import cc.before30.sample.domain.fubar.BookStoreRepository;
import cc.before30.sample.domain.fubar.BookToBookStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class JpaSampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaSampleApplication.class, args);
	}


	@Autowired
	BookStoreRepository bookStoreRepository;

	@Override
	public void run(String... args) throws Exception {
		List<BookToBookStore> all = bookStoreRepository.findAll();
		for (BookToBookStore bookToBookStore : all) {
			log.info("{} : {}", bookToBookStore.getBookId().getAuthor().getFirstName(), bookToBookStore.getBookId().getAuthor().getBook().size());
			log.info("{} : {}", bookToBookStore.getBookId().getTitle(), bookToBookStore.getStock());
		}
	}
}
