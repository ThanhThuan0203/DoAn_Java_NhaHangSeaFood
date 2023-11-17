package hutech.nguyenthanhthuan.Customer.controller;

import hutech.nguyenthanhthuan.Library.dto.ProductDto;
import hutech.nguyenthanhthuan.Library.model.Category;
import hutech.nguyenthanhthuan.Library.model.Customer;
import hutech.nguyenthanhthuan.Library.model.ShoppingCart;
import hutech.nguyenthanhthuan.Library.service.CategoryService;
import hutech.nguyenthanhthuan.Library.service.CustomerService;
import hutech.nguyenthanhthuan.Library.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CustomerService customerService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model, Principal principal, HttpSession session) {
        model.addAttribute("title", "Trang chủ");
        model.addAttribute("page", "Trang chủ");
        if (principal != null) {
            Customer customer = customerService.findByUsername(principal.getName());
            session.setAttribute("username", customer.getFirstName() + " " + customer.getLastName());
            ShoppingCart shoppingCart = customer.getCart();
            if (shoppingCart != null) {
                session.setAttribute("totalItems", shoppingCart.getTotalItems());
            }
        }
        return "home";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Liên hệ");
        model.addAttribute("page", "Liên hệ");
        return "contact-us";
    }

}