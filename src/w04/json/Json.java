/** @author rob nebeker */
// W04 JSON HTTP

package w04.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Json {

    public static String customerToJSON(Customer customer) {

        ObjectMapper mapper = new ObjectMapper();
        String s = "";

        try {
            s = mapper.writeValueAsString(customer);
        } catch (JsonProcessingException e) {
            System.err.println(e.toString());
        }
        return s;
    }

    public static Customer JSONToCustomer(String s) {

        ObjectMapper mapper = new ObjectMapper();
        Customer customer = null;

        try {
            customer = mapper.readValue(s, Customer.class);
        }
        catch (JsonProcessingException e) {
            System.err.println(e.toString());
        }

        return customer;
    }

    public static void main(String[] args) {

        Customer cust = new Customer();
        cust.setName("Roberto");
        cust.setPhone(911);

        String json = Json.customerToJSON(cust);
        System.out.println(json);

        Customer cust2 = Json.JSONToCustomer(json);
        System.out.println(cust2);
    }

}

