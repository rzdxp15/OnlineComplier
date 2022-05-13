package z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import z.mapper.FwordMapper;
import z.pojo.L4word;
import z.pojo.Words;
import z.service.FwordService;

@Service
public class FwordServiceImpl extends ServiceImpl<FwordMapper, L4word> implements FwordService {

	@Autowired FwordMapper fs;
	
	  @Override public IPage<L4word> listword(int cur,int uid) { 
		  Page page=new Page<L4word>(cur, 12); 
		  IPage iPage=fs.listword(page,cur, uid);
		  return iPage; 
		  }
	 

}
