public class Respondent implements Comparable<Respondent>{
    private final String fullName;
    private final Integer age;

    public Respondent (String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    
    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", fullName, age);
    }

    @Override
    public int compareTo(Respondent o) {
        if (this.age == (o.getAge())) {
            return this.fullName.compareTo(o.fullName);
        } else {
            return this.age.compareTo(o.age);
        }
    }
}
