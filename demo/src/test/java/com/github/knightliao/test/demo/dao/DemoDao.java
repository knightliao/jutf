package com.github.knightliao.test.demo.dao;

import com.github.knightliao.test.demo.entity.Demo;

/**
 * @author zhugongrui
 * @date 2016年6月30日上午11:33:55
 */
public interface DemoDao {
	Demo selectByPrimaryKey(Long id);
	int updateByPrimaryKeySelective(Demo demo);
}
