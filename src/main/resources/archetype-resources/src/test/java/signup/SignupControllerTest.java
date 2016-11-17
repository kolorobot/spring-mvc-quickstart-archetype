package ${package}.signup;

import org.junit.Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ${package}.config.WebSecurityConfigurationAware;

public class SignupControllerTest extends WebSecurityConfigurationAware {
    @Test
    public void displaysSignupForm() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(model().attributeExists("signupForm"))
                .andExpect(view().name("signup/signup"))
                .andExpect(content().string(
                        allOf(
                                containsString("<title>Signup</title>"),
                                containsString("<legend>Please Sign Up</legend>")
                        ))
                );
    }
}