package seminars.third.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDrivenDevelopment {

    /**
     * Нужно написать (TDD) класс MoodAnalyser, который оценивает фразы по настроению
     */
    @Test
    void testMoodAnalysisHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String str = "хорошее настроение";
        assertThat(moodAnalyser.analyze(str)).isEqualTo("happy");
    }

    @Test
    void testMoodAnalysisSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String str = "плохое настроение";
        assertThat(moodAnalyser.analyze(str)).isEqualTo("sad");
    }

    @Test
    void testMoodAnalysisMedium() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String str = "нейтральное настроение";
        assertThat(moodAnalyser.analyze(str)).isEqualTo("So so");
    }


    /**
     * HW 3_3 <br>
     * Нужно написать метод, который проверяет, попадает ли переданное число в интервал (25;100) возвращает true, если попадает и false - если нет, покрыть тестами метод на 100%
     * public boolean numberInInterval(int n) { … }
     */

    @Test
    void testIsNumberInInterval() {
        NumberAnalyser numberAnalyser = new NumberAnalyser();
        assertTrue(numberAnalyser.numberInInterval(50));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100, 1000})
    void testIsNumberOutInterval(int i) {
        NumberAnalyser numberAnalyser = new NumberAnalyser();
        assertFalse(numberAnalyser.numberInInterval(i));
    }

}