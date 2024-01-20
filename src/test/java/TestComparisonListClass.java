

import com.taxah.dz6.ComparisonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class TestComparisonListClass {
    ComparisonList comparisonList;
    List<Integer> expected;
    ComparisonList comparisonListParam;

    @BeforeEach
    void setup() {
        comparisonList = new ComparisonList();
        expected = Arrays.asList(1, 2, 3);
        comparisonListParam = new ComparisonList(expected);
    }

    @Test
    void testListAddingElement() {
        comparisonList.add(1);

        assertThat(comparisonList).hasSizeGreaterThan(0);
    }

    @Test
    void testContainsAddedElement() {
        comparisonList.add(15);

        assertThat(comparisonList).contains(15);
    }

    @Test
    void testConstructorWithParameter() {
        assertNotNull(comparisonListParam);

        assertEquals(expected, comparisonListParam.getList());
    }

    @Test
    void testStream() {
        Stream<Integer> resultStream = comparisonListParam.stream();
        List<Integer> resultList = resultStream.toList();

        assertEquals(expected, resultList);
    }

    @Test
    void testToString() {
        String resultString = comparisonListParam.toString();
        String expectedString = expected.toString();

        assertEquals(expectedString, resultString);
    }
}
