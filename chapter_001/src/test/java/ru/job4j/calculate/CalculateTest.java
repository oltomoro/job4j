package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* @author Ism Vladimir (mailto:is.vladimir@testmail.com)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
	/**
	* Test Echo
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Ism Vladimir";
		String expect = "Echo, echo, echo: Ism Vladimir";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}