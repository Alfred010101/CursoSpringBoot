package cursoSpringBoot.controller;

import cursoSpringBoot.domain.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class CustomerController
{
    private List<Customer> customerList = new ArrayList<>(Arrays.asList(
            new Customer(111, "Ana", "anita", "********"),
            new Customer(222, "Luis", "LUIS", "********"),
            new Customer(333, "Pepe", "pepito", "********"),
            new Customer(444, "Diana", "diana", "********")
    ));

    // @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomerList()
    {
        return ResponseEntity.ok(customerList);
    }

    // @GetMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PathVariable String id)
    {
        try
        {
            for (Customer c : customerList)
            {
                if (c.getId() == Integer.parseInt(id))
                    return ResponseEntity.ok(c);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado <<<" + id + ">>>");
        }catch (Exception e)
        {
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Argumento no valido");
    }

    // @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer)
    {
        customerList.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario agregado correctamente " + customer.getId());
    }

    // @PutMapping
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> putCustomer(@RequestBody Customer customer)
    {
        for (Customer c : customerList)
        {
            if (c.getId() == customer.getId())
            {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return ResponseEntity.ok("Usuario modificado correctamente " + customer.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado " + customer.getId());
    }

    // @DeleteMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleCustomer(@PathVariable int id)
    {
        // Validar que el parametro sea del tipo correcto
        for (Customer c : customerList)
        {
            if (c.getId() == id)
            {
                customerList.remove(c);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario eliminado satisfactoriamente " + c.getUsername());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado " + id);
    }

    // @PatchMapping
    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer)
    {
        for(Customer c : customerList)
        {
            if (c.getId() == customer.getId())
            {
                if (customer.getName() != null)
                    c.setName(customer.getName());
                if (customer.getPassword() != null)
                    c.setPassword(customer.getPassword());
                if (customer.getUsername() != null)
                    c.setUsername(customer.getUsername());
                return ResponseEntity.ok("Usuario actualizado");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encotro el usuario " + customer.getId());
    }
}















