/**
 * Author: Aamina Hussain
 * Revised: March 29, 2021
 * 
 * Description: Testing CourseT class
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import src.Measures;
import src.IndicatorT;
import src.AttributeT;
import src.Services;
import src.Norm;
import src.CourseT;
import java.util.*;

public class TestCourseT
{

	private IndicatorT[] ind;
	private CourseT calc;
	private LOsT LO1;
	private LOsT LO2;
	private LOsT[] LOarr;
	private LOsT[] LOarr2;
	private LOsT[] LOarr3;
	private double[] norms;

	@Before
    public void setUp()
    {
    	ind = new IndicatorT[] {IndicatorT.math, IndicatorT.tools};
    	calc = new CourseT("calculus", ind);
    	LO1 = new LOsT("topic 1", 25, 25, 25, 25);
    	LO2 = new LOsT("topic 2", 23, 45, 56, 89);
    	LOarr = new LOsT[] {LO1};
    	LOarr2 = new LOsT[] {LO2};
    	LOarr3 = new LOsT[] {LO1, LO2};
    	norms = new double[] {0.25, 0.25, 0.25, 0.25};
    }

    @After
    public void tearDown()
    {
        ind = null;
        calc = null;
        LO1 = null;
        LO2 = null;
        LOarr = null;
        LOarr2 = null;
        LOarr3 = null;
    }

	@Test
    public void testgetName()
    {
        assertTrue(calc.getName() == "calculus");
    }

    @Test
    public void testgetIndicators()
    {
    	boolean a = false;
    	if(Arrays.asList(calc.getIndicators()).contains(IndicatorT.math) && Arrays.asList(calc.getIndicators()).contains(IndicatorT.tools)){
    		a = true;
    	}
        assertTrue(a);
    }

    @Test
    public void testgetIndicatorsNotIncluded()
    {
    	boolean a = true;
    	if(Arrays.asList(calc.getIndicators()).contains(IndicatorT.math) && Arrays.asList(calc.getIndicators()).contains(IndicatorT.assumpt)){
    		a = false;
    	}
        assertTrue(a);
    }

    @Test
    public void testgetLOsAndaddLO()
    {
    	assertTrue(calc.getLOs(IndicatorT.math).length == 0);
    	calc.addLO(IndicatorT.math, LO1);
    	assertTrue(calc.getLOs(IndicatorT.math)[0] == LO1);
    }

    @Test
    public void testdelLO()
    {
    	calc.delLO(IndicatorT.math, LO1);
    	assertTrue(calc.getLOs(IndicatorT.math).length == 0);
    }

    @Test
    public void testmemberCase1()
    {
    	calc.addLO(IndicatorT.math, LO1);
    	assertTrue(!(calc.member(IndicatorT.recogTheory, LOarr)));
    }

    @Test
    public void testmemberCase2()
    {
    	calc.addLO(IndicatorT.math, LO1);
    	assertTrue(!(calc.member(IndicatorT.math, LOarr3)));
    }

    @Test
    public void testmemberCase3()
    {
    	calc.addLO(IndicatorT.math, LO1);
    	assertTrue(!(calc.member(IndicatorT.math, LOarr2)));
    }

    @Test
    public void testmemberCase4()
    {
    	calc.addLO(IndicatorT.math, LO1);
    	assertTrue(calc.member(IndicatorT.math, LOarr));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testmeasuresException1()
    {
    	calc.measures();
    }

    @Test
    public void testmeasuresIndCase1()
    {
    	calc.delLO(IndicatorT.math, LO1);
    	boolean a = true;
    	for(int i = 0; i < 4; i++){
    		if(!(calc.measures(IndicatorT.math)[i] == 0)){
    			a = false;
    		}
    	}
    	assertTrue(a);
    }

    @Test
    public void testmeasuresIndCase2a()
    {
    	Norm.setNInd(true);
    	Norm.setNLOs(false);
    	calc.addLO(IndicatorT.math, LO1);
    	boolean a = true;
    	for(int i = 0; i < 4; i++){
    		if(!(calc.measures(IndicatorT.math)[i] == norms[i])){
    			a = false;
    		}
    	}
    	assertTrue(a);
    }

    @Test
    public void testmeasuresIndCase2b()
    {
    	Norm.setNInd(true);
    	Norm.setNLOs(true);
    	calc.addLO(IndicatorT.math, LO1);
    	boolean a = true;
    	for(int i = 0; i < 4; i++){
    		if(!(calc.measures(IndicatorT.math)[i] == norms[i])){
    			a = false;
    		}
    	}
    	assertTrue(a);
    }

    @Test
    public void testmeasuresIndCase3a()
    {
    	Norm.setNInd(false);
    	Norm.setNLOs(false);
    	calc.addLO(IndicatorT.math, LO1);
    	boolean a = true;
    	for(int i = 0; i < 4; i++){
    		if(!(calc.measures(IndicatorT.math)[i] == 25)){
    			a = false;
    		}
    	}
    	assertTrue(a);
    }

    @Test
    public void testmeasuresIndCase3b()
    {
    	Norm.setNInd(false);
    	Norm.setNLOs(true);
    	calc.addLO(IndicatorT.math, LO1);
    	boolean a = true;
    	for(int i = 0; i < 4; i++){
    		if(!(calc.measures(IndicatorT.math)[i] == norms[i])){
    			a = false;
    		}
    	}
    	assertTrue(a);
    }

    @Test
    public void testmeasuresIndCase4()
    {
    	calc.addLO(IndicatorT.math, LO1);
    	boolean a = true;
    	for(int i = 0; i < 4; i++){
    		if(!(calc.measures(IndicatorT.specEngKnow)[i] == 0)){
    			a = false;
    		}
    	}
    	assertTrue(a);
    }

}
