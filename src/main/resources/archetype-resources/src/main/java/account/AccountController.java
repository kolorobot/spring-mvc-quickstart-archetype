package ${package}.account;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class AccountController {

    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "account/current", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public Account currentAccount(Principal principal) {
        Assert.notNull(principal);
        return accountRepository.findOneByEmail(principal.getName());
    }

    @RequestMapping(value = "account/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public Account account(@PathVariable("id") Long id) {
        return accountRepository.findOne(id);
    }
}
