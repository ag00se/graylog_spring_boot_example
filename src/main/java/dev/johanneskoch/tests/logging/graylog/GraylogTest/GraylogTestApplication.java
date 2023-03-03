package dev.johanneskoch.tests.logging.graylog.GraylogTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class GraylogTestApplication {

	private final Logger log = LogManager.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(GraylogTestApplication.class, args);
	}

	@PostConstruct
	public void test() throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(2000);
						log.info("Graylog test");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.run();
		t.join();
	}
}
