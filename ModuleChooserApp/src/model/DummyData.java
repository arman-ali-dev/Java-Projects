package model;

import java.util.List;
import java.util.Arrays;

public class DummyData {

    public static List<String> getMandatoryModules() {
        return Arrays.asList(
                "Programming Fundamentals",
                "Data Structures",
                "Operating Systems");
    }

    public static List<String> getOptionalModules() {
        return Arrays.asList(
                "AI Basics",
                "Cloud Computing",
                "Web Development",
                "Cybersecurity");
    }

}
