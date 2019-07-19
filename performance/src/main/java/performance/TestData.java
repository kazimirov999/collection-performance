package performance;

import java.io.Serializable;

public class TestData implements Comparable<TestData> {

    private Integer id;
    private String name;

    public TestData(){

    }
    public TestData(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestData testData = (TestData) o;

        if (!id.equals(testData.id)) return false;
        return name.equals(testData.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



    @Override
    public int compareTo(TestData o) {
        if( this.id > o.id){
            return 1;
        }else if(this.id.equals(o.id)){
            return -1;
        }else {
            return 0;
        }
    }
}