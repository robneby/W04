/** @author rob nebeker */
// W04 JSON HTTP

package w04.json;


public class Customer {

    private String name;
    private long phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Name: " + name + " Phone: " + phone;
    }
}
