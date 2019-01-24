import java.util.Objects;

public class Segment implements Comparable<Segment> {
    private int len;
    private int num;

    public Segment(int len, int num) {
        this.len = len;
        this.num = num;
    }

    public Segment(){

    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void iterator(){
        this.num++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return len == segment.len &&
                num == segment.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(len, num);
    }

    @Override
    public int compareTo(Segment segment) {
        return num - segment.num;
    }

    @Override
    public String toString() {
        return len + ";" +
                + num;
    }
}