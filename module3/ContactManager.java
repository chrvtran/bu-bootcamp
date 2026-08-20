import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Chris", new Contact("Chris", "+1 283 122 8220"));
        contacts.put("Bob", new Contact("Bob", "+31 999 201 0019"));
        contacts.put("Alice", new Contact("Alice", "+1 303 333 9017"));
        contacts.put("Charlie", new Contact("Charlie", "+1 781 303 3101"));
 
        // Step 5: look up a contact
        if (contacts.get("Ada Lovelace") != null ) {
            System.out.println(contacts.get("Ada Lovelace"));
        } else {
            System.out.println("Contact not found.");
        }

        // failure test
        if (contacts.get("Jane Doe") != null ) {
            System.out.println(contacts.get("Jane Doe"));
        } else {
            System.out.println("Jane Doe not found.");
        }
        
        System.out.println();
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  
        System.out.println("=== All Contacts ===  ");
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    } 
}