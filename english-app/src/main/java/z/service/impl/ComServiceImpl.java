package z.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import z.mapper.ComMapper;
import z.pojo.Comprehension;
import z.pojo.cq;
import z.service.ComService;
import z.vo.Cprevo;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ComServiceImpl extends ServiceImpl<ComMapper, Comprehension> implements ComService{

	
	  
	  @Autowired 
	  ComMapper cm;
		/*
		 * @Override
		 * 
		 * @Override public List<cq> listq() {
		 * 
		 * List<cq> list=cs.listq(); return list;
		 * 
		 * }
		 */

	@Override
	public List<Cprevo> listq(@Param("id")Integer id) {
		// TODO Auto-generated method stub
		List<Cprevo> list=cm.listq(id);
		return list;
	}

	
	 
	
}
