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
		// in AttributeT.java, change the return statement for getName so that it returns this.name
		// instead of just name.
		// ADD EXCEPTIONS

		this.name = topic;
		this.n_blw = nblw;
		this.n_mrg = nmrg;
		this.n_mts = nmts;
		this.n_exc = nexc;
	}

	public String getName(){
		return this.name;
	}

	public boolean equals(LOst o){
		return this.name == o.getName();
	}

}
