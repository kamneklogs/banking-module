package model;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {

		int compare;
		int specialConditionO1= o1.getSpecialCondition();
		int specialConditionO2= o2.getSpecialCondition();
		
		if(specialConditionO1<specialConditionO2) {
			compare=-1;
		}else if(specialConditionO1>specialConditionO2) {
			compare=1;
		}else {
			compare=0;
		}
		return compare;
	}

	
}
