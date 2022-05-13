package z.test;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;

import z.utils.OkHttpApi;

public class test {
	public static void main(String args[]) throws IOException {
		OkHttpApi api=new OkHttpApi();
		String run=api.run("http://api.fanyi.baidu.com/api/trans/vip/translate?q=apple&from=en&to=zh&appid=2015063000000001&salt=1435660288&sign=f89f9594663708c1605f3d736d01d2d4");
		System.out.println(run);
		JSONObject jsonObject=JSONObject.parseObject(run);
		
		System.out.println(jsonObject.getString("trans_result"));
	}
}
