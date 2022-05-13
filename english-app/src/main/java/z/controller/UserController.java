package z.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.hutool.core.map.MapUtil;
import z.interceptor.Result;
import z.pojo.User;
import z.service.UserService;
import z.shiroandjwt.JwtUtils;
import z.shiroandjwt.LoginDto;



@RestController
public class UserController {
	@Autowired UserService userService;
	@Autowired JwtUtils jwtUtils;
	@PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
		 User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
	        Assert.notNull(user, "用户不存在");
			
			  if(!user.getPassword().equals(loginDto.getPassword())) {
			 return Result.fail("密码错误！"); }
			 
	        String jwt = jwtUtils.generateToken(user.getId());
	        response.setHeader("Authorization", jwt);
	        response.setHeader("Access-Control-Expose-Headers", "Authorization");
	        return Result.succ(MapUtil.builder()
	        		.put("id", user.getId())
	        		.put("username", user.getUsername())
	        		.put("password", user.getPassword())
	        		.map()
	        		);
	}
	
	@RequestMapping("/save")
	public String save(String username,String password) {
		User user=new User();
		/*
		 * user.setUsername(loginDto.getUsername());
		 * user.setUserpassword(loginDto.getUsername());
		 */
		user.setUsername(username);
		user.setPassword(password);
		userService.save(user);
		return "succ";
	}
} 
