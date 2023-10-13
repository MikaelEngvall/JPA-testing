package org.engvall.JPAtesting;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class IdAndStuffApplication {
	static Book b = new Book();
    public static void main(String[] args) {
        SpringApplication.run(IdAndStuffApplication.class, args);

		b.setTitle("The Hound of the Baskervilles");
		b.setId(UUID.randomUUID());
		b.setPublishingDate(LocalDate.of(1902, 4, 30));

		System.out.println(b.title.toString());
		System.out.println(b.publishingDate.toString());
		System.out.println(b.id.toString());
    }

    @Entity
    public static class Book {

        @jakarta.persistence.Id
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
		private String title;
		private LocalDate publishingDate;

		public void setId(UUID id) {
            this.id = id;
        }

        public UUID getId() {
            return id;
        }

		public void setTitle(String title) {
			this.title = title;
		}

		public void setPublishingDate(LocalDate publishingDate) {
			this.publishingDate = publishingDate;
		}
	}

}
