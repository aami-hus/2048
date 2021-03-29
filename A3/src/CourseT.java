package src;

import src.Measures;
import src.IndicatorT;
import src.AttributeT;
import src.Services;
import src.Norm;
import java.util.*;

public class CourseT implements Measures{

	private String name;
	private HashMap<IndicatorT, Set<LOsT>> m;

	public CourseT(String courseName, IndicatorT[] indicators){
		this.name = courseName;
		this.m = new HashMap<IndicatorT, Set<LOsT>>();
		for(IndicatorT i : indicators){
			this.m.put(i, new HashSet<LOsT>());
		}
	}

	public String getName(){
		return this.name;
	}

	public IndicatorT[] getIndicators(){
		IndicatorT[] arr = new IndicatorT[this.m.size()];
		arr = this.m.keySet().toArray(arr);
		return arr;
	}

	public LOsT[] getLOs(IndicatorT indicator){
		if(this.m.containsKey(indicator)){
			LOsT[] arr = new LOsT[this.m.get(indicator).size()];
			arr = this.m.get(indicator).toArray(arr);
			return arr;
		}
		LOsT[] arr = {};
		return arr;
	}

	public void addLO(IndicatorT indicator, LOsT outcome){
		if(this.m.containsKey(indicator)){
			this.m.get(indicator).add(outcome);
		}
	}

	public void delLO(IndicatorT indicator, LOsT outcome){
		if(this.m.containsKey(indicator)){
			this.m.get(indicator).remove(outcome);
		}
	}

	public boolean member(IndicatorT indicator, LOsT[] outcomes){
		if(!(this.m.containsKey(indicator))){
			return false;
		}
		if(!(this.m.get(indicator).size() == outcomes.length)){
			return false;
		}
		for(LOsT i : outcomes){
			if(!(this.m.get(indicator).contains(i))){
				return false;
			}
		}
		return true;
	}

	public double[] measures(){
		throw new UnsupportedOperationException("This operation is not supported by this class.");
	}

	public double[] measures(IndicatorT ind){
		double[] total = {0, 0, 0, 0};
		if(this.getLOs(ind).length == 0){
			return total;
		}
		for(LOsT i : this.getLOs(ind)){
			sumMeas(total, i.measures());
		}
		if(Norm.getNInd()){
			return Services.normal(total);
		}
		return total;
	}

	public double [] measures(AttributeT att){
		double[] total = {0, 0, 0, 0};
		if(att.getIndicators().length == 0){
			return total;
		}
		for(IndicatorT i : att.getIndicators()){
			sumMeas(total, this.measures(i));
		}
		if(Norm.getNAtt()){
			return Services.normal(total);
		}
		return total;
	}

	private double[] sumMeas(double[] total, double[] a){
		for(int i = 0; i < a.length; i++){
			total[i] = total[i] + a[i];
		}
		return total;
	}
}