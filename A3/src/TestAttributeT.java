/**
 * Author: Aamina Hussain
 * Revised: March 29, 2021
 * 
 * Description: Testing AttributeT class
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import src.IndicatorT;
import src.AttributeT;
import java.util.*;

public class TestAttributeT
{

	private AttributeT Design;
	private AttributeT TestEmpty;

	@Before
    public void setUp()
    {
        Design = new AttributeT("Design", new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desProcess, IndicatorT.standards});
        TestEmpty = new AttributeT("", new IndicatorT[]{});
    }

    @After
    public void tearDown()
    {
        Design = null;
        TestEmpty = null;
    }

    @Test
    public void testgetName()
    {
        assertTrue(Design.getName() == "Design");
    }

    @Test
    public void testgetNameEdgeCase()
    {
        assertTrue(TestEmpty.getName() == "");
    }

    @Test
    public void testgetIndicators()
    {
    	boolean a = false;
    	if(Arrays.asList(Design.getIndicators()).contains(IndicatorT.desProcess) && Arrays.asList(Design.getIndicators()).contains(IndicatorT.standards)){
    		a = true;
    	}
        assertTrue(a);
    }

    @Test
    public void testgetIndicatorsEdgeCase()
    {
        assertTrue(TestEmpty.getIndicators().length == 0);
    }

}
