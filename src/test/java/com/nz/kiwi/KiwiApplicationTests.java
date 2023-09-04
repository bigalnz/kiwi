package com.nz.kiwi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import jakarta.persistence.EntityManager;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.geolatte.geom.builder.DSL.*;


@SpringBootTest(classes = {KiwiApplication.class})
class KiwiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EntityManager entityManager;

	@Autowired
	BirdRepository birdRepository;

	@Test
	public void should_store_bird() {
		Bird bird = birdRepository.save(new Bird("Octavia", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "JPA Unit Test"));
		assertEquals("Octavia", bird.getName());
		assertEquals(Status.ALIVE, bird.getStatus());
		assertEquals(Sex.FEMALE, bird.getSex());
		assertEquals(Taxa.BROWN_KIWI, bird.getTaxa());
	}

	@Test
	@Sql("create_minnie.sql")
	void test_minnie_insert() {
		Optional<Bird> minnie = birdRepository.findById(40L);
		assertThat(minnie).isNotNull();
	}

	@Test
	@Sql("create_dario.sql")
	void test_dario_insert() {
		Optional<Bird> dario = birdRepository.findById(50L);
		assertThat(dario).isNotNull();
		System.out.println("Wait");
	}

	@Test
	@Sql("create_bow.sql")
	void test_bow_insert() {
		Optional<Bird> bow = birdRepository.findById(70L);
		assertThat(bow).isNotNull();
		System.out.println("Wait");
	}

	@Test
	void testJson() throws IOException, JsonProcessingException {

		var objectMapper = new ObjectMapper();
		objectMapper.registerModule(new GeolatteGeomModule());
		Point<G2D> location = point(WGS84, g(4.33, 53.21));
		String geojson = objectMapper.writeValueAsString(location);
		System.out.println("this is it : " + geojson);

	}

}
