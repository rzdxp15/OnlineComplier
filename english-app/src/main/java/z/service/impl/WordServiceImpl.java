package z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import z.mapper.FwordMapper;
import z.mapper.WordsMapper;
import z.pojo.L4word;
import z.pojo.Words;
import z.service.WordService;

@Service
public class WordServiceImpl extends ServiceImpl<WordsMapper,Words> implements WordService{

	@Autowired WordsMapper fs;
	
	 


	@Override
	public IPage<Words> listword(int cur, int uid) {
		Page page1=new Page(cur, 12); 
		  IPage iPage=fs.listword(page1,cur, uid);
		  return iPage; 
	}

}
