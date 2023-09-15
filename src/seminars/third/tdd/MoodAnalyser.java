package seminars.third.tdd;

public class MoodAnalyser {
    public String analyze(String str) {
        if (str.contains("хорошее")) return "happy";
        else if (str.contains("плохое")) return "sad";
        else return "So so";
    }
}
