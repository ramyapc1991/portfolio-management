package com.turvo.portfolio.management;


import java.util.Comparator;


public class UserComparator implements Comparator<UserProfile> {
    UserProfile profile;


    public UserComparator(UserProfile profile) {
        this.profile = profile;
    }

    @Override
    public int compare(UserProfile o1, UserProfile o2) {
        String[] profileArr = (String[]) profile.getHobbies().toArray();
        if(!o1.getGender().equalsIgnoreCase(o2.getGender())){
            if(!this.profile.getGender().equalsIgnoreCase(o1.getGender())){
                return -1;
            }else {
                return 1;
            }
        }

        if(!(Math.abs(o1.getAge()- this.profile.getAge()) == Math.abs(o2.getAge()- this.profile.getAge()))){
           if(Math.abs(o1.getAge()- this.profile.getAge()) < (Math.abs(o2.getAge()- this.profile.getAge()))){
               return -1;
           }
           return 1;
        }

        String[] arr = (String[]) o1.getHobbies().toArray();
        int counter1 =0;
        for(String pArr : profileArr){
            for(String objArr :arr){
                if(pArr.equalsIgnoreCase(objArr)){
                    counter1 ++;
                }
            }
        }
        String[] arr2 = (String[]) o2.getHobbies().toArray();
        int counter2 =0;
        for(String pArr : profileArr){
            for(String objArr :arr2){
                if(pArr.equalsIgnoreCase(objArr)){
                    counter2 ++;
                }
            }
        }
        if(counter1 > counter2){
            return -1;
        }
        else if(counter1 < counter2){
            return 1;
        }
        else
            return 0;

    }
}
