package EEfirstChapter2.Person;

public class person {
    public static String fullName;
    public static int age;
    public static String gender;
    public person() {
    }
    public person(String fullName,int age,String gender) {
        this.gender=gender;
        this.age=age;
        this.fullName=fullName;
    }

    public static String getFullName() {
        return fullName;
    }
    public static void setFullName(String fullName) {
        person.fullName = fullName;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        person.age = age;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        person.gender = gender;
    }
}
