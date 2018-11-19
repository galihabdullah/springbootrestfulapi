package com.sporthubid.controllers.auth;

import com.sporthubid.models.V_User;
import com.sporthubid.repository.VUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin // for suport multi platform access
public class Login {

    @Autowired
    VUserRepository vuser;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@Valid @RequestBody V_User user) {

        List<V_User> user_v = vuser.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        Map<String, Object> usermap = new HashMap<>();

        if ( user_v.isEmpty() ) {

            usermap.put("error", true);
            usermap.put("message", "Username or Password does not match.");
            usermap.put("result", null);
            usermap.put("status", "FAIL");

        } else {
            usermap.put("error", null);
            usermap.put("message", "Login berhasil");
            usermap.put("result", user_v);
            usermap.put("status", "OK");
        }

        return usermap;
    }

    @PostMapping(value = "/signin")
    public Map<String, Object> signin(@Valid @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        List<V_User> user_v = vuser.findByUsernameAndPassword(username, password);

        Map<String, Object> usermap = new HashMap<>();

        if ( user_v.isEmpty() ) {

            usermap.put("error", true);
            usermap.put("message", "Username or Password does not match.");
            usermap.put("result", null);
            usermap.put("status", "FAIL");

        } else {
            usermap.put("error", null);
            usermap.put("message", "Login berhasil");
            usermap.put("result", user_v);
            usermap.put("status", "OK");
        }

        return usermap;
    }

}
