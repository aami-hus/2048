/**
 * Author: Aamina Hussain, hussaa54
 * Revised: March 29, 2021
 */

package src;

import src.IndicatorT;
import java.util.*;

public class AttributeT{

	private ArrayList<IndicatorT> s;
	private String name;

	public AttributeT(String attribName, IndicatorT[] indicators){
		this.name = attribName;
		s = new ArrayList<IndicatorT>();
		for(IndicatorT i : indicators){
			if(!(this.s.contains(i))){
				this.s.add(i);
			}
		}
	}

	public String getName(){
		return this.name;
	}

	public IndicatorT[] getIndicators(){
		IndicatorT[] arr = new IndicatorT[this.s.size()];
		arr = this.s.toArray(arr);
		return arr;
	}

}


