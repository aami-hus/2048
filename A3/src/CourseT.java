/**
 * Author: Aamina Hussain, hussaa54
 * Revised: March 29, 2021
 *
 * Description: Course ADT class 
 */

package src;

import src.Measures;
import src.IndicatorT;
import src.AttributeT;
import src.Services;
import src.Norm;
import java.util.*;

/**
 * @brief An ADT that represents a course
 * @details The course is represented as a set of tuples {(indicator, {set of learning outcomes}), ...}
 */
public class CourseT implements Measures{

	private String name;
	private HashMap<IndicatorT, Set<LOsT>> m;

   /**
	* @brief Initializes a course object
	* @param courseName The name of the course
	* @param indicators A sequence of IndicatorT and each IndicatorT has a set of learning outcomes
	*/
	public CourseT(String courseName, IndicatorT[] indicators){
		this.name = courseName;
		this.m = new HashMap<IndicatorT, Set<LOsT>>();
		for(IndicatorT i : indicators){
			this.m.put(i, new HashSet<LOsT>());
		}
	}

   /**
	* @brief Gets the name of the course
	* @return The name of the course
	*/
	public String getName(){
		return this.name;
	}

   /**
	* @brief Gets the indicators of the course
	* @return A sequence of the indicators of the course
	*/
	public IndicatorT[] getIndicators(){
		IndicatorT[] arr = new IndicatorT[this.m.size()];
		arr = this.m.keySet().toArray(arr);
		return arr;
	}

   /**
	* @brief Gets the learning outcomes of a given indicator
	* @param indicator The given indicator for which the learning outcomes are wanted
	* @return A sequence of learning outcomes of a given indicator
	*/
	public LOsT[] getLOs(IndicatorT indicator){
		if(this.m.containsKey(indicator)){
			LOsT[] arr = new LOsT[this.m.get(indicator).size()];
			arr = this.m.get(indicator).toArray(arr);
			return arr;
		}
		LOsT[] arr = {};
		return arr;
	}

   /**
	* @brief Adds the learning outcome for a given indicator
	* @param indicator The indicator for which a learning outcome will be added
	* @param outcome The learning outcome to be added
	*/
	public void addLO(IndicatorT indicator, LOsT outcome){
		if(this.m.containsKey(indicator)){
			this.m.get(indicator).add(outcome);
		}
	}

   /**
	* @brief Deletes the learning outcome for a given indicator
	* @param indicator The indicator for which a learning outcome will be deleted
	* @param outcome The learning outcome to be deleted
	*/
	public void delLO(IndicatorT indicator, LOsT outcome){
		if(this.m.containsKey(indicator)){
			this.m.get(indicator).remove(outcome);
		}
	}

   /**
	* @brief Determines whether a given indicator and learning outcomes are in the course
	* @param indicator The indicator that must be in the course
	* @param outcomes The learning outcomes (assigned to the given indicator) that must be in the course 
	* @return True if the indicator and outcomes are a member of the course
	*/
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

   /**
	* @brief Uses Measures interface but this signature is not valid for this class
	*/
	public double[] measures(){
		throw new UnsupportedOperationException("This operation is not supported by this class.");
	}

   /**
	* @brief Sums all the learning outcomes of the set associated with the given indicator
	* @param ind The indicator whose learning outcomes will be measured
	* @return A sequence of calculated sums for each of the learning outcomes
	*/
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

   /**
	* @brief Sums all the learning outcomes of the set associated with the indicators of a given attribute
	* @param att The attribute whose indicators' learning outcomes will be measured
	* @return A sequence of calculated sums for each of the learning outcomes
	*/
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

   /**
	* @brief Sums the ith value of two given sequences
	* @param total One of the array of doubles needed to find the sum
	* @param a The second array of doubles needed to find the sum
	* @return A sequence of the sum of the ith values of the given sequences
	*/
	private double[] sumMeas(double[] total, double[] a){
		for(int i = 0; i < a.length; i++){
			total[i] = total[i] + a[i];
		}
		return total;
	}
}