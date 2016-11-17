package com.cn.tdd.Calculator;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	
	@Test(expected = RuntimeException.class)
    public final void whenNoInstructionsThenExceptionIsThrown() {
        Calculator.calculate(new ArrayList<String>());
    }
	
	@Test
    public final void whenLastLineNotApplyThenExceptionIsThrown() {
		 RuntimeException exception = null;
		 ArrayList<String> instructions = new ArrayList<String>();
		 instructions.add("add 2");
		 instructions.add("multiply 4");
		try {
	        Calculator.calculate(instructions);
	    } catch (RuntimeException e) {
	        exception = e;
	    }
	    Assert.assertNotNull(exception);
	   Assert.assertEquals("apply instruction not found", exception.getMessage());
	}
	
	@Test
    public final void whenLastLineApplyAndNotNumberThenExceptionIsThrown() {
		 RuntimeException exception = null;
		 ArrayList<String> instructions = new ArrayList<String>();
		 instructions.add("add 2");
		 instructions.add("add 4");
		 instructions.add("apply apply");
		try {
	        Calculator.calculate(instructions);
	    } catch (RuntimeException e) {
	        exception = e;
	    }
	    Assert.assertNotNull(exception);
	   Assert.assertEquals("apply instruction must be with number", exception.getMessage());
	}
	
	@Test
    public final void whenAllValid() {
		 RuntimeException exception = null;
		 ArrayList<String> instructions = new ArrayList<String>();
		 instructions.add("add 2");
		 instructions.add("add 4");
		 instructions.add("apply 0");
	   Assert.assertEquals(6, Calculator.calculate(instructions));
	}
	


    }
	
	

