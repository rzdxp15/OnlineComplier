package z.controller;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import z.interceptor.Result;
import z.pojo.Comprehension;
import z.service.ComService;
import z.service.impl.ComServiceImpl;
import z.utils.OkHttpApi;

@RestController
public class PageController {

	@Autowired
	ComService cs;



	@RequestMapping("/title")
	public Object listtitle() {
		QueryWrapper<Comprehension> list = new QueryWrapper<>();
		list.select(Comprehension.class, i -> i.getColumn().equals("title"));
		List<Comprehension> list2 = cs.list(list);
		return list2;
	}

	@RequestMapping("/listpages/id={id}")
	public Object page3(@PathVariable(name = "id") int id ){
		QueryWrapper<Comprehension> list = new QueryWrapper<>();
		list.in("id", id).select( "page","ans");
		List<Comprehension> list2 = cs.list(list);
		return list2;
	}
	
	@RequestMapping("/listtrans/id={id}")
	public Result page4(@PathVariable(name = "id") int id) {
		QueryWrapper<Comprehension> list = new QueryWrapper<>();
		list.in("id", id).select("translation");
		List<Comprehension> list2 = cs.list(list);
		return Result.succ(list2);
	}

	@RequestMapping("/listtitle/type={type}")
	public Object page1(@PathVariable(name = "type") Integer type) {
		if(type==null) {
			return null;
		}
		QueryWrapper<Comprehension> list = new QueryWrapper<>();
		list.in("type", type).select("id","title");
		List<Comprehension> list2 = cs.list(list);
		return list2;
	}
	@RequestMapping("/fy/q={q}/appid={appid}/salt={salt}/sign={sign}")
	public Object fy(

			@PathVariable(name = "q") String q,

			@PathVariable(name = "appid") String appid,

			@PathVariable(name = "salt") String salt,

			@PathVariable(name = "sign") String sign) throws IOException {
		OkHttpApi api = new OkHttpApi();
		String run = api.run("http://api.fanyi.baidu.com/api/trans/vip/translate?q=" + q + "&from=en&to=zh&appid="
				+ appid + "&salt=" + salt + "&sign=" + sign);
		Object jObject = JSONObject.parse(run);
		String string = JSONObject.parseObject(run).getString("trans_result");
		return string;
	}

	@RequestMapping("/getq/{id}")
	public Result q(@PathVariable(value = "id") Integer id) {
		try {
			return Result.succ(cs.listq(id));
		} catch (Exception e) {
			// TODO: handle exception
			return Result.fail(e.toString());
		}
	}
	
	@RequestMapping("/getfy/{id}")
	public Result getfy(@PathVariable(value = "id") Integer id) {
		try {
			return Result.succ(cs.listq(id));
		} catch (Exception e) {
			// TODO: handle exception
			return Result.fail(e.toString());
		}
	}
}
