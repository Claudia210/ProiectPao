package Project.Superclasa;

public class Person {
    protected String last_name;
    protected String first_name;

    public Person(String last_name, String first_name) {
        this.last_name = last_name;
        this.first_name = first_name;
    }

    public Person() {
        last_name =" ";
        first_name=" ";
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
