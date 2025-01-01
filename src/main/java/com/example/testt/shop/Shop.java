package com.example.testt.shop;

import com.example.testt.model.Customer;

public class Shop {

    Customer[] customers = new Customer[0];

    public boolean isExistingCustomer(Customer customer) {
        for (Customer temp : customers) {
            if (temp.getUserName().equalsIgnoreCase(customer.getUserName())) {
                return true;
            }

        }
        return false;
    }
    public void addCustomer(Customer customer){
        Customer [] temCustomers=new Customer[customers.length+1];
        for (int i=0; i< customers.length ; i++){
            temCustomers[i]=customers[i];
        }
        temCustomers[customers.length]=customer;
        customers=temCustomers;
    }

}
