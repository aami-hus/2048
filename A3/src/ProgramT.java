package src;

import src.Measures;
import src.IndicatorT;
import src.AttributeT;
import src.Services;
import src.Norm;
import src.CourseT;
import java.util.*;

public class ProgramT extends HashSet<CourseT> implements Measures{

	public double[] measures(){
		throw new UnsupportedOperationException();
	}

	public double[] measures(IndicatorT ind){
		throw new UnsupportedOperationException();
	}

	public double[] measures(AttributeT att){
		double[] total = {0, 0, 0, 0};
		for(CourseT i : this){
			sumMeas(total, i.measures(att));
		}
		return Services.normal(total);
	}

	private double[] sumMeas(double[] total, double[] a){
		for(int i = 0; i < a.length; i++){
			total[i] = total[i] + a[i];
		}
		return total;
	}

}
