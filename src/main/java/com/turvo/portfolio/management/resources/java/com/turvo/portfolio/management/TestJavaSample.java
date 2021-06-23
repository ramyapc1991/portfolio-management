package com.turvo.portfolio.management.resources.java.com.turvo.portfolio.management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestJavaSample {
    public static void main(String[] args) {
        List<UserProfile> profiles = new ArrayList<>();
                profiles.add(new UserProfile("Neha" , "Female", 21 , Arrays.asList( "Singing", "dancing")));
        profiles.add(new UserProfile("Pooja" , "Female", 23 , Arrays.asList( "painting", "badminton")));
        profiles.add(new UserProfile("Vikas" , "Male", 32 , Arrays.asList( "bowling", "cricket")));
        profiles.add(new UserProfile("Kiran" , "Male", 29 , Arrays.asList( "badminton", "chess")));
        profiles.add(new UserProfile("Uday" , "Male", 23 , Arrays.asList( "cricket", "programming")));
        profiles.add(new UserProfile("Nikita" , "Female", 26 , Arrays.asList( "ludo", "chess")));

        String name = "Nikita";
        UserProfile input = null;
        for(UserProfile profile: profiles){
            if(profile.getName().equalsIgnoreCase(name)){
                input = profile;
            }

        }

        List<UserProfile> result = findMatches(input, profiles);
        for(UserProfile user: result){
            System.out.println(user);
        }


    }

    private static List<UserProfile> findMatches(UserProfile input, List<UserProfile> profiles) {

        profiles.remove(input);
        Collections.sort(profiles, new UserComparator(input));
        return profiles;
    }

    private static List<String> getPreferenceList() {
        return Arrays.asList("gender", "age", "hobbies");
    }
}
