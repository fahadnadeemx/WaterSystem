package com.axcore.portal.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axcore.portal.entity.Customer;
import com.axcore.portal.entity.Employee;
import com.axcore.portal.service.CustomerServiceImpl;
import com.axcore.portal.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/list")
    public String showCustomerList(Model model) {
        List<Employee> employee = employeeService.getAllEmployees();
        List<Customer> customers = customerService.getAllCustomers();

        model.addAttribute("employee", employee);
        model.addAttribute("customers", customers);

        return "pages/customer-list";
    }

    @GetMapping("/generate-record")
    public String showCustomerForm(@RequestParam("Id") Long Id, Model model) {
        Customer customer = customerService.getCustomerById(Id);

        if (customer != null) {
            model.addAttribute("customer", customer);
        }
        return "pages/add-customer";
    }

    @PostMapping("/submit")
    public String submitCustomerForm(Customer customer) {
        // Perform calculations
        int newDeliveredBottles = customer.getBottleDelivered();
        int newEmptyBottlesReceived = customer.getEmptyBottleReceived();
        BigDecimal newAmountReceived = customer.getReceivedAmount();
        BigDecimal bottleRate = customer.getBottleRate(); // Get the bottle rate directly

        // Convert int values to BigDecimal
        BigDecimal newDeliveredBottlesDecimal = new BigDecimal(newDeliveredBottles);

        // Calculate remaining balance
        BigDecimal newRemainingBalance = bottleRate
                                                .multiply(newDeliveredBottlesDecimal)
                                                .subtract(newAmountReceived);

        // Retrieve the existing customer data from the database
        Customer existingCustomer = customerService.getCustomerById(customer.getId());

        // Update the customer entity with the calculated values
        if (existingCustomer != null) {
            existingCustomer.setBottleDelivered(existingCustomer.getBottleDelivered() + newDeliveredBottles);
            existingCustomer.setEmptyBottleReceived(existingCustomer.getEmptyBottleReceived() + newEmptyBottlesReceived);
            existingCustomer.setBalanceAmount(newRemainingBalance);

            // Save the updated customer data
            customerService.saveCustomer(existingCustomer);
        }

        return "redirect:/customers/list";
    }



}
