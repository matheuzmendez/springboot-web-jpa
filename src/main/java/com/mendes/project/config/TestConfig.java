package com.mendes.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mendes.project.entities.Category;
import com.mendes.project.entities.Order;
import com.mendes.project.entities.OrderItem;
import com.mendes.project.entities.Product;
import com.mendes.project.entities.User;
import com.mendes.project.entities.enums.OrderStatus;
import com.mendes.project.repositories.CategoryRepository;
import com.mendes.project.repositories.OrderItemRepository;
import com.mendes.project.repositories.OrderRepository;
import com.mendes.project.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category oneCategory = new Category(null, "Electronics");
		Category twoCategory = new Category(null, "Books");
		Category threeCategory = new Category(null, "Computers");

		Product oneProduct = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product twoProduct = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product threeProduct = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product fourProduct = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product fiveProduct = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(oneCategory, twoCategory, threeCategory));
		productRepository.saveAll(Arrays.asList(oneProduct, twoProduct, threeProduct, fourProduct, fiveProduct));
		
		oneProduct.getCategories().add(twoCategory);
		twoProduct.getCategories().add(oneCategory);
		twoProduct.getCategories().add(threeCategory);
		threeProduct.getCategories().add(threeCategory);
		fourProduct.getCategories().add(threeCategory);
		fiveProduct.getCategories().add(twoCategory);
		
		productRepository.saveAll(Arrays.asList(oneProduct, twoProduct, threeProduct, fourProduct, fiveProduct));
		
		User firstUser = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User secondUser = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order oneOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, firstUser);
		Order twoOrder = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, secondUser);
		Order threeOrder = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, firstUser);
		
		userRepository.saveAll(Arrays.asList(firstUser, secondUser));
		orderRepository.saveAll(Arrays.asList(oneOrder,twoOrder,threeOrder));
		
		OrderItem oi1 = new OrderItem(oneOrder, oneProduct, 2, oneProduct.getPrice());
		OrderItem oi2 = new OrderItem(oneOrder, threeProduct, 1, threeProduct.getPrice());
		OrderItem oi3 = new OrderItem(twoOrder, threeProduct, 2, threeProduct.getPrice());
		OrderItem oi4 = new OrderItem(threeOrder, fiveProduct, 2, fiveProduct.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}

}
