/**
 * Author: Aamina Hussain
 * Revised: March 29, 2021
 * 
 * Description: Testing ProgramT class
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
import src.ProgramT;
import java.util.*;

public class TestProgramT
{

	private ProgramT P;
	private CourseT calc;
	private IndicatorT[] inds;
	private IndicatorT ind;

	@Before
    public void setUp()
    {
    	P = new ProgramT();
    	inds = new IndicatorT[] {IndicatorT.math, IndicatorT.tools};
    	calc = new CourseT("calculus", inds);
    	ind = IndicatorT.math;
    }

    @After
    public void tearDown()
    {
        P = null;
        inds = null;
        calc = null;
        ind = null;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testmeasuresException1()
    {
    	P.measures();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testmeasuresException2()
    {
    	P.measures(ind);
    }

}
