package hutech.nguyenthanhthuan.Customer.controller;

import hutech.nguyenthanhthuan.Library.dto.CustomerDto;
import hutech.nguyenthanhthuan.Library.model.City;
import hutech.nguyenthanhthuan.Library.model.Country;
import hutech.nguyenthanhthuan.Library.model.Customer;
import hutech.nguyenthanhthuan.Library.service.CityService;
import hutech.nguyenthanhthuan.Library.service.CountryService;
import hutech.nguyenthanhthuan.Library.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CountryService countryService;
    private final PasswordEncoder passwordEncoder;
    private final CityService cityService;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        if(principal == null) {
            return "redirect:/login";
        }
        String username = principal.getName();
        CustomerDto customer = customerService.getCustomer(username);
        List<Country> countryList = countryService.findAll();
        List<City> cities = cityService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("cities", cities);
        model.addAttribute("countries", countryList);
        model.addAttribute("title", "Hồ sơ");
        model.addAttribute("page", "Profile");
        return "customer-information";

    }

    @PostMapping("/update-profile")
    public String updateProfile(@Valid @ModelAttribute("customer") CustomerDto customerDto,
                                BindingResult result,
                                RedirectAttributes attributes,
                                Model model,
                                Principal principal) {
        if(principal == null) {
            return "redirect:/login";
        }
        String username = principal.getName();
        CustomerDto customer = customerService.getCustomer(username);
        List<Country> countryList = countryService.findAll();
        List<City> cities = cityService.findAll();
        model.addAttribute("countries", countryList);
        model.addAttribute("cities", cities);
        if (result.hasErrors()) {
            return "customer-information";
        }
        customerService.update(customerDto);
        CustomerDto customerUpdate = customerService.getCustomer(principal.getName());
            attributes.addFlashAttribute("success", "Cập nhật thành công!");
        model.addAttribute("customer", customerUpdate);
        return "redirect:/profile";

    }

    @GetMapping("/change-password")
    public String changePassword(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("title", "Đổi mật khẩu");
        model.addAttribute("page", "Đổi mật khẩu");
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePass(@RequestParam("oldPassword") String oldPassword,
                             @RequestParam("newPassword") String newPassword,
                             @RequestParam("repeatNewPassword") String repeatPassword,
                             RedirectAttributes attributes,
                             Model model,
                             Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            CustomerDto customer = customerService.getCustomer(principal.getName());
            if (passwordEncoder.matches(oldPassword, customer.getPassword())
                    && !passwordEncoder.matches(newPassword, oldPassword)
                    && !passwordEncoder.matches(newPassword, customer.getPassword())
                    && repeatPassword.equals(newPassword) && newPassword.length() >= 5) {
                customer.setPassword(passwordEncoder.encode(newPassword));
                customerService.changePass(customer);
                attributes.addFlashAttribute("success", "Mật khẩu của bạn đã được thay đổi thành công!");
                return "redirect:/profile";
            } else {
                model.addAttribute("message", "Mật khẩu của bạn sai");
                return "change-password";
            }
        }
    }
}