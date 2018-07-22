package com.sathish.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.rule.OutputCapture;

import com.sathish.aop.AopApplication;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for  AopApplication.
 *
 * @author Sathish Kariyanna
 */
public class AopApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private String profiles;

	@Before
	public void init() {
		this.profiles = System.getProperty("spring.profiles.active");
	}

	@After
	public void after() {
		if (this.profiles != null) {
			System.setProperty("spring.profiles.active", this.profiles);
		}
		else {
			System.clearProperty("spring.profiles.active");
		}
	}

	@Test
	public void testDefaultSettings() throws Exception {
		AopApplication.main(new String[0]);
		String output = this.outputCapture.toString();
		assertThat(output).contains("Hello Sathish");
	}

	@Test
	public void testCommandLineOverrides() throws Exception {
		AopApplication.main(new String[] { "--name=Kariyanna" });
		String output = this.outputCapture.toString();
		assertThat(output).contains("Hello Kariyanna");
	}
}
