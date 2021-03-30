/**
 * Author: Aamina Hussain
 * Revised: March 29, 2021
 * 
 * Description: Testing LOsT class
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import src.Measures;
import src.IndicatorT;
import src.AttributeT;
import src.Services;
import src.Norm;
import src.LOsT;

public class TestLOsT
{

	private LOsT LO1;
    private LOsT LO2;
    private LOsT same;
    private double[] norms;
    private double[] notNorms;
    private IndicatorT ind;
    private AttributeT att;

	@Before
    public void setUp()
    {
    	LO1 = new LOsT("topic 1", 25, 25, 25, 25);
    	LO2 = new LOsT("topic 2", 15, 6, 78, 4);
    	same = new LOsT("topic 1", 23, 1, 6, 7);
    	norms = new double[] {0.25, 0.25, 0.25, 0.25};
    	notNorms = new double[] {25.0, 25.0, 25.0, 25.0};
    	ind = IndicatorT.math;
    	att = new AttributeT("Design", new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desProcess, IndicatorT.standards});
    }

    @After
    public void tearDown()
    {
        LO1 = null;
        LO2 = null;
        same = null;
        norms = null;
        notNorms = null;
        ind = null;
        att = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException1()
    {
    	LOsT LO3 = new LOsT("topic 3", 23, -1, 5, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException2()
    {
    	LOsT LO4 = new LOsT("topic 4", 0, 0, 0, 0);
    }
    
    @Test
    public void testgetName()
    {
    	assertTrue(LO1.getName() == "topic 1");
    	assertTrue(LO2.getName() == "topic 2");
    	assertTrue(same.getName() == "topic 1");
    }

    @Test
    public void testequals()
    {
    	assertTrue(LO1.equals(same));
    }

    @Test
    public void testequalsFalse()
    {
    	assertTrue(!(LO1.equals(LO2)));
    }

    @Test
    public void testmeasuresCase1()
    {
    	Norm.setNLOs(false);
    	boolean a = true;
    	for(int i = 0; i < notNorms.length; i++){
    		if(!(notNorms[i] == LO1.measures()[i])){
    			a = false;
    		}
    	}
    	assertTrue(a);
    }

    @Test
    public void testmeasuresCase2()
    {
    	Norm.setNLOs(true);
    	boolean a = true;
    	for(int i = 0; i < norms.length; i++){
    		if(!(norms[i] == LO1.measures()[i])){
    			a = false;
    		}
    	}
    	assertTrue(a);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testmeasuresException1()
    {
    	LO1.measures(ind);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testmeasuresException2()
    {
    	LO1.measures(att);
    }
}
