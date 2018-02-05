package com.airbus.example.delegate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.airbus.example.delegate.domain.Car;
import com.airbus.example.delegate.repo.CarRepository;
import com.airbus.example.delegate.service.CarService;

@RunWith(MockitoJUnitRunner.class)
public class DelegateApplicationTests {

	@InjectMocks
	private CarService service = new CarService();

	@Mock
	private CarRepository repo;

	@Before
	public void setup() {

		List<Car> porsches = new ArrayList<>();

		Car porsche911 = new Car();
		porsche911.setMake("Porsche");
		porsche911.setModel("911");
		porsches.add(porsche911);

		Mockito.when(repo.findAll()).thenReturn(porsches);
	}

	@Test
	public void when_listCars_then_return_Porsche() {

		List<Car> cars = service.getCars();
		Assert.assertNotNull(cars);
		Assert.assertEquals(1, cars.size());
		Assert.assertEquals("Porsche", cars.get(0).getMake());
		Assert.assertEquals("911", cars.get(0).getModel());

	}
}
