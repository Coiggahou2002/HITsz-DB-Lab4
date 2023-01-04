package com.coiggahou.catplatform;

import com.coiggahou.catplatform.entity.User;
import com.coiggahou.catplatform.service.CatService;
import com.coiggahou.catplatform.service.CatServiceImpl;
import com.coiggahou.catplatform.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CatplatformApplicationTests {

	@Autowired
	private CatService catService;

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void testListAllCats() {
		System.out.println(catService.listAll());
	}

	@Test
	void testUserRegister() {
		User newUser = new User(null, "coiggahou", "123456");
		userService.register(newUser);
	}

}
