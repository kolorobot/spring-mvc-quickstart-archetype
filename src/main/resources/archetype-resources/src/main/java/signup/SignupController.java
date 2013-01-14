package ${package}.signup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import ${package}.account.*;

@Controller
public class SignupController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(value = "signup")
	public SignupForm signup() {
		return new SignupForm();
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public void signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		accountRepository.save(signupForm.createAccount());
	}
}
