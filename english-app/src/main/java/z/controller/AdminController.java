package z.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import net.sf.saxon.functions.ConstantFunction.True;
import z.interceptor.Result;
import z.mapper.Uaw;
import z.pojo.L4word;
import z.pojo.User;
import z.pojo.Userandword;
import z.pojo.Words;
import z.service.FwordService;
import z.service.KywordService;
import z.service.Uawservice;
import z.service.UserService;
import z.service.WordService;
import z.service.impl.FwordServiceImpl;

@RestController
public class AdminController {
	@Autowired
	WordService ws;
	@Autowired(required = true)
	UserService us;
 
	@Autowired Uawservice uawservice;
	
	@Autowired
	KywordService ks;


	@Autowired
	FwordService fsi;

	private static final ExecutorService pool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(5));

	/**
	 * 插入UserandWord Table
	 */

	@RequestMapping("/addfourwords/uid={uid}")
	public String addword(@PathVariable(name = "uid") int uid) {
		try {
			for (int i = 1; i <= 1000; i++) {
				Userandword userandword = new Userandword();
				userandword.setUid(uid);
				userandword.setWord_fourid(i);
				uawservice.saveOrUpdate(userandword);
			}
		} catch (Exception e) {
			return e.toString();
		}
		return "成功";
	}

	@RequestMapping("/addsixwords/uid={uid}")
	public String addsixword(@PathVariable(name = "uid") int uid) {
		try {
			for (int i = 1; i <= 1933; i++) {
				Userandword userandword = new Userandword();
				userandword.setUid(uid);
				userandword.setWord_sixid(i);
				userandword.setWord_fourid(1);
				uawservice.saveOrUpdate(userandword);
			}
		} catch (Exception e) {
			return e.toString();
		}
		return "成功";
	}

	@RequestMapping("/listl4word/uid={uid}/cur={cur}")
	public Result listt(@PathVariable(name = "uid") int uid, @PathVariable(name = "cur") int cur) {
		return Result.succ(fsi.listword(cur, uid));
	}

	@RequestMapping("/listl6word/uid={uid}/cur={cur}")
	public Result lists(@PathVariable(name = "uid") int uid, @PathVariable(name = "cur") int cur) {
		return Result.succ(ws.listword(cur, uid));
	}

}
