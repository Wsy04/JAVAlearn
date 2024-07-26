package Collection;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo1 {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>();
        set.add(new Student("aaa",18,99,100,100));
        set.add(new Student("bbb",18,100,0,10));
        set.add(new Student("ccc",18,0,100,10));
        set.add(new Student("ddd",18,10,100,10));
        set.add(new Student("eee",18,10,100,10));
        set.add(new Student("fff",19,100,0,10));
        set.forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int chineseScore;
    private int mathScore;
    private int englishScore;

    public Student() {
    }

    public Student(String name, int age, int chineseScore, int mathScore, int englishScore) {
        this.name = name;
        this.age = age;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    @Override
    public int compareTo(Student o) {
        int sum1 = this.chineseScore + this.mathScore + this.englishScore;
        int sum2 = o.chineseScore + o.mathScore + o.englishScore;
        if(sum1!=sum2){
            return sum2-sum1;
        }else if(this.chineseScore!=o.chineseScore){
            return o.chineseScore-this.chineseScore;
        }else if(this.mathScore!=o.mathScore){
            return o.mathScore-this.mathScore;
        }else if(this.englishScore!=o.englishScore){
            return o.englishScore-this.englishScore;
        }else if(this.age!=o.age){
            return o.age-this.age;
        }else return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", chineseScore=" + chineseScore +
                ", mathScore=" + mathScore +
                ", englishScore=" + englishScore +
                '}';
    }
}
