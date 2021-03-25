package src;

import src.IndicatorT;
import java.util.*;

public class AttributeT{

	private HashSet<IndicatorT> s;
	private String name;

	public AttributeT(String attribName, HashSet<IndicatorT> indicators){
		this.name = attribName;
		s = new HashSet<IndicatorT>();
		Iterator<Integer> i = indicators.iterator();
		while(i.hasNext()){
			this.a.add(i.next());
		}
	}

	public String getName(){
		return name;
	}

	public HashSet<IndicatorT> getIndicators(){
		return s;
	}

	public static void main(String[] args){
		HashSet<IndicatorT> tester = new HashSet<IndicatorT>();
		tester.add("math");
		tester.add("tools");
		AttributeT tester2 = new AttributeT("yes", tester);
		System.out.println(tester);
		System.out.println(tester2.getName());
		System.out.println(tester2.getIndicators());


	}

}


