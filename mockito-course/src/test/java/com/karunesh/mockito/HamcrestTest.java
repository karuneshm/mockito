package com.karunesh.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestTest {

	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(99,100,101,105);
		
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(99,100));
		assertThat(scores, everyItem(greaterThan(90)));
		assertThat(scores, everyItem(lessThan(190)));
		
		
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		
		Integer[] marks = {1,2,4};
		
		assertThat(marks, arrayWithSize(3));
		assertThat(marks, arrayContaining(1,2));
		
	}

}
