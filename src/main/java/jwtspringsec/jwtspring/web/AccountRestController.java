package jwtspringsec.jwtspring.web;

import jwtspringsec.jwtspring.entities.AppUser;
import jwtspringsec.jwtspring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm userForm){
        if(!userForm.getPassword().equals(userForm.getRepeatpassword()))
            throw new RuntimeException("You must confirm your password");
        AppUser user = accountService.findUserByUsername(userForm.getUsername());
        if(user!=null)
            throw new RuntimeException("This user already exists");
        AppUser appUser = new AppUser();
        appUser.setUsername(userForm.getUsername());
        appUser.setPassword(userForm.getPassword());
        accountService.saveUser(appUser);
        accountService.addRoleToUser(userForm.getUsername(),"USER");
        return appUser;
    }
}
