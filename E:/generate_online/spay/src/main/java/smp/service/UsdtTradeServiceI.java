package .smp.service;
import .smp.entity.UsdtTradeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface UsdtTradeServiceI extends CommonService{
	
 	public void delete(UsdtTradeEntity entity) throws Exception;
 	
 	public Serializable save(UsdtTradeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(UsdtTradeEntity entity) throws Exception;
 	
}
