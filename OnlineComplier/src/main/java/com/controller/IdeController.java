package com.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.IdeService;
import org.springframework.data.redis.core.RedisTemplate;


@RestController
@RequestMapping("/redisTest")
public class IdeController {
	private Logger logger=LoggerFactory.getLogger(IdeController.class);
	@Autowired
    private IdeService executeStringSourceService;

	@RequestMapping("/runide/{id}")
	public String test(@PathVariable("id")String id) {
		String string="public class Run {public static void main(String[]args) {";
		string=string+id+";}}";
		String runResult = executeStringSourceService.execute(string, "");
        runResult = runResult.replaceAll(System.lineSeparator(), "<br/>"); 
        
		System.out.println(runResult);
		return runResult;
	}
	@RequestMapping(path = {"/run/"}, method = RequestMethod.POST)
    public String runCode(@RequestParam("source") String source,
                          @RequestParam("systemIn") String systemIn) {
		String string="public static void main(String[]args) {System.out.println(\"hi jvm\");}";
        String runResult = executeStringSourceService.execute(source, systemIn);
        runResult = runResult.replaceAll(System.lineSeparator(), "<br/>"); 
        return runResult;
       
    }
	
   /** private static final String defaultSource = "public class Run {\n"
            + "    public static void main(String[] args) {\n"
            + "        \n"
            + "    }\n"
            + "}";

    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
    public String entry(Model model) {
        model.addAttribute("lastSource", defaultSource);
        return "ide";
    }

    @RequestMapping(path = {"/run"}, method = RequestMethod.POST)
    public String runCode(@RequestParam("source") String source,
                          @RequestParam("systemIn") String systemIn, Model model) {
        String runResult = executeStringSourceService.execute(source, systemIn);
        runResult = runResult.replaceAll(System.lineSeparator(), "<br/>"); // ����html�л��е�����

        model.addAttribute("lastSource", source);
        model.addAttribute("lastSystemIn", systemIn);
        model.addAttribute("runResult", runResult);
        return "ide";
       
    }**/
	
}
