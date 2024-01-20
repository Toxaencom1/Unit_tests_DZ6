

import com.taxah.dz6.ComparisonList;
import com.taxah.dz6.ListComparerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class TestListCompareService {
    ComparisonList first;
    ComparisonList second;
    ListComparerService lcs;
    private boolean runBeforeEach = true;

    @BeforeEach
    void setup() {
        if (runBeforeEach) {
            first = new ComparisonList(Arrays.asList(1, 2, 3, 4, 5));
            second = new ComparisonList(Arrays.asList(1, 2, 3, 4, 5));
        }
    }

    @Test
    void testCalculateAVG() {
        lcs = new ListComparerService(first, second);
        double firstAVG = lcs.calculateAverageGrade(first);

        assertThat(firstAVG).isEqualTo(3);
    }

    @Test
    void testListsAreEmpty() {
        first = new ComparisonList();
        second = new ComparisonList();
        lcs = new ListComparerService(first, second);
        Double firstAVG = null;
        try {
            firstAVG = lcs.calculateAverageGrade(first);
        } catch (Exception e) {
            fail("Не ожидалась ошибка: " + e.getMessage());
        }
        assertThat(firstAVG).isEqualTo(0.0);
    }

    @Test
    void testCompareFirstEqualSecond() {
        lcs = new ListComparerService(first, second);

        String res = lcs.compareAverageGrades();

        assertThat(res).isEqualTo("Средние значения равны");
    }

    @Test
    void testCompareFirstGreaterThanSecond() {
        runBeforeEach = false;
        first = new ComparisonList(Arrays.asList(9, 8, 3, 4, 6));
        second = new ComparisonList(Arrays.asList(1, 2, 3, 4, 5));
        lcs = new ListComparerService(first, second);

        String res = lcs.compareAverageGrades();

        assertThat(res).isEqualTo("Первый список имеет большее среднее значение");
    }

    @Test
    void testCompareFirstLessThanSecond() {
        runBeforeEach = false;
        first = new ComparisonList(Arrays.asList(1, 2, 3, 4, 5));
        second = new ComparisonList(Arrays.asList(9, 8, 3, 4, 5));
        lcs = new ListComparerService(first, second);

        String res = lcs.compareAverageGrades();

        assertThat(res).isEqualTo("Второй список имеет большее среднее значение");
    }

}

