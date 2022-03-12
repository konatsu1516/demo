package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.data.entity.User;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.form.UserForm;

@Controller
public class UserController {

	 //@Autowiredアノテーションを付けると、Spring Bootが自動でインスタンスをInjectします。
	 @Autowired
	 private UserRepository userRepository;
	 // @RequestMapping(path = "/user", method = RequestMethod.GET)の省略版。
	 // HTTPのメソッドGETのみ受け付けます。
	 @GetMapping("/users")
	    // 引数にorg.springframework.ui.Modelを追加
	    public String getUsers(Model model) {
	     List<User> users = userRepository.findAll();
	        // Modelにusersを追加
	     model.addAttribute("users", users);
	        return "users";
	    }
	 
	   @GetMapping("/newuser")
	     // 引数にModelを追加
	    public String getNewUser(Model model) {
	        // Modelに空のUserFormを追加
	        UserForm userForm = new UserForm();
	        model.addAttribute("userForm", userForm);
	        return "newuser";
	    }
	   
	   @PostMapping("/newuser")
	    public String registerUser(UserForm userForm) {
	        // UserFormの値をUserクラス（Entity）にセットする
	        User user = new User();
	        user.setName(userForm.getName());
	        user.setEmail(userForm.getEmail());

	        // データベースに保存
	        userRepository.save(user);

	        return "redirect:/users";
	    }

}