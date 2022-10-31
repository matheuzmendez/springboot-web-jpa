package com.mendes.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mendes.project.entities.Category;
import com.mendes.project.entities.Order;
import com.mendes.project.entities.User;
import com.mendes.project.entities.enums.OrderStatus;
import com.mendes.project.repositories.CategoryRepository;
import com.mendes.project.repositories.OrderRepository;
import com.mendes.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category oneCategory = new Category(null, "Electronics");
		Category twoCategory = new Category(null, "Books");
		Category threeCategory = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(oneCategory, twoCategory, threeCategory));
		
		User firstUser = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User secondUser = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order oneOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, firstUser);
		Order twoOrder = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, secondUser);
		Order threeOrder = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, firstUser);
		
		userRepository.saveAll(Arrays.asList(firstUser, secondUser));
		orderRepository.saveAll(Arrays.asList(oneOrder,twoOrder,threeOrder));
	}

}
