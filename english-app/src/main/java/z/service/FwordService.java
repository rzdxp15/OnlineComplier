package z.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import z.mapper.FwordMapper;
import z.pojo.L4word;
import z.pojo.Words;

public interface FwordService extends IService<L4word>{

	 public IPage<L4word> listword(int cur,@Param("uid")int uid); 
}
