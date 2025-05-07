
package com.hufs.algoing.user.controller;

import com.hufs.algoing.user.dto.UserDTO;
import com.hufs.algoing.user.entity.User;
import com.hufs.algoing.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserAuthController {

    private final UserService userService;


    // 회원가입

//    @GetMapping("/signup")
//    public String testSignUp() {
//        return "redirect:/test/signup.html";
//    }

    @PostMapping("/signup")
    public String signup(UserDTO dto){
        userService.signup(dto);
        return "redirect:/login";
    }

    @PostMapping("/inserthandle")
    public String insertHandle(UserDTO dto, @AuthenticationPrincipal User principal) {
        userService.insertHandle(dto,principal);
        userService.updateUserData(dto.getHandle());
        return "redirect:/";
    }
}
