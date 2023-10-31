package com.example.ProyectoBiblioteca;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoBibliotecaApplicationTests {


	@Test
	void contextLoads() {
	}
	@Test
	public void testMain() {
		ProyectoBibliotecaApplication.main(new String[] {"arg1", "arg2", "arg3"});
	}
}
