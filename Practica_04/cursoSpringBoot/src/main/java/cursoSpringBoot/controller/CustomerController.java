package cursoSpringBoot.controller;

import cursoSpringBoot.domain.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController
{
    private List<Customer> customerList = new ArrayList<>(Arrays.asList(
            new Customer(111, "Ana", "anita", "********"),
            new Customer(222, "Luis", "LUIS", "********"),
            new Customer(333, "Pepe", "pepito", "********"),
            new Customer(444, "Diana", "diana", "********")
    ));

    @GetMapping("/usuarios")
    public List<Customer> getCustomerList()
    {
        return customerList;
    }

    @GetMapping("/usuarios/{id}")
    public Customer getCustomer(@PathVariable String id)
    {
        try
        {
            for (Customer c : customerList)
            {
                if (c.getId() == Integer.parseInt(id))
                {
                    return c;
                }
            }
        }catch (Exception e)
        {
        }
        return null;
    }

    @PostMapping("/usuarios")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        customerList.add(customer);
        return customer;
    }
}
