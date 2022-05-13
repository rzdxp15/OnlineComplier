package z.service;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import z.pojo.L4word;
import z.pojo.Words;

public interface WordService extends IService<Words>{
	public IPage<Words> listword( int cur,@Param("uid")int uid);
}
