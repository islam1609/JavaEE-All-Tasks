package EEfirstChapter1.order;

public class Order {
    private String name;
    private String surname;
    private String food;

    public Order(){}
    public Order (String name, String surname,String food){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;  }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getFood() {

        return food;
    }

    public void setFood(String food) {

        this.food = food;
    }

}

