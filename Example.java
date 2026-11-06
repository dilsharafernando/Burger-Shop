import java.util.*;

class Customer {
    private String id;
    private int value;
    
    public Customer(String id, int value) {
        this.id = id;
        this.value = value;
    }
    
    public String getId() { 
        return id; 
    }
    
    public int getValue() { 
        return value; 
    }
    
    public void setValue(int value) { 
        this.value = value; 
    }
}

class Example {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Customer> customerList = new ArrayList<>();
        
        while (true) {
            System.out.print("Enter Customer ID (Enter -1 to stop)  : ");
            String id = input.nextLine();
            if (id.equals("-1")) {
                break;
            }
            
            System.out.print("Enter Bill Value : ");
            int value = input.nextInt();
            input.nextLine(); // Consume the leftover newline
            
            Customer existingCustomer = null;
            for (Customer c : customerList) {
                if (c.getId().equals(id)) {
                    existingCustomer = c;
                    break;
                }
            }
            
            if (existingCustomer != null) {
                existingCustomer.setValue(existingCustomer.getValue() + value);
            } else {
                customerList.add(new Customer(id, value));
            }
        }
        
        System.out.println();
        System.out.println();
        System.out.println("Customer Id     |   Total Bill Value");    
        System.out.println("-------------------------------------------------------");    
        
        for (Customer c : customerList) {
            System.out.printf("%-15s |   %d\n", c.getId(), c.getValue());
        }
        
        System.out.println("-------------------------------------------------------");
        input.close();
    }
}
