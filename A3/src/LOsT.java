package src;

import src.Measures;
import src.IndicatorT;
import src.AttributeT;
import src.Services;
import src.Norm;

public class LOsT implements Measures{

	private String name;
	private int n_blw;
	private int n_mrg;
	private int n_mts;
	private int n_exc;

	public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc){
		if (nblw < 0 || nmrg < 0 || nmts < 0 || nexc < 0){
			throw new IllegalArgumentException();
		}
		if (nblw == 0 && nmrg == 0 && nmts == 0 && nexc == 0){
			throw new IllegalArgumentException();
		}
		this.name = topic;
		this.n_blw = nblw;
		this.n_mrg = nmrg;
		this.n_mts = nmts;
		this.n_exc = nexc;
	}

	public String getName(){
		return this.name;
	}

	public boolean equals(LOsT o){
		return this.name == o.getName();
	}

	public double[] measures(){
		double [] a = new double[4];
		a[0] = new Double(this.n_blw);
		a[1] = new Double(this.n_mrg);
		a[2] = new Double(this.n_mts);
		a[3] = new Double(this.n_exc);
		if(!(Norm.getNLOs())){
			return a;
		}
		return Services.normal(a);
	}

	public double[] measures(IndicatorT ind){
		throw new UnsupportedOperationException();
	}

	public double[] measures(AttributeT att){
		throw new UnsupportedOperationException();
	}
}
