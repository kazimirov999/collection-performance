package benchmark;

import java.util.Objects;

public class TestData implements Comparable<TestData> {
    public String string;
    public int index;

    public TestData(String string, int index) {
        this.string = string;
        this.index = index;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestData testData = (TestData) o;
        return index == testData.index &&
                Objects.equals(string, testData.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, index);
    }

    @Override
    public String toString() {
        return "TestData{" +
                "string='" + string + '\'' +
                ", index=" + index +
                '}';
    }

    @Override
    public int compareTo(TestData o) {
        return 0;
    }
}
