package com.bianxing.bianxing.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.bianxing.bianxing.common.constant.CommonConstant;

/**
 * 常量初始化
 * @author：BShuai
 * @since：2015-9-24 下午2:20:42
 * @version:
 */
public class InitConstantListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Value("${file_storage_path}")
	public String fileStoragePath;
	
	@Value("${resource_server}")
	public String resourceServer;

	@Value("${switch_xiu}")
	public String switchXiu;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		CommonConstant.FILE_STORAGE_PATH = this.fileStoragePath;
		CommonConstant.RESOURCE_SERVER = this.resourceServer;
		
		CommonConstant.SWITCH_XIU = this.switchXiu;
	}

}
