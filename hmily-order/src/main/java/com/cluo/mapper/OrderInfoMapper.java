package com.cluo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.cluo.pojo.OrderInfo;

@Mapper
public interface OrderInfoMapper {

	@Insert({"insert into hmily_order (order_no,product_name,product_num,unit_price,total) "
			+ "values (#{orderNo,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{productNum,jdbcType=INTEGER},"
			+ "#{unitPrice,jdbcType=DECIMAL},#{total,jdbcType=DECIMAL})"})
	public int tryOrder(OrderInfo orderInfo);
	
	@Update({"update hmily_order set deleted = #{deleted} where order_no = #{orderNo}"})
	public int confirmOrder(OrderInfo orderInfo);
	
	@Update({"update hmily_order set deleted = #{deleted} where order_no = #{orderNo}"})
	public int cancelOrder(OrderInfo orderInfo);
}
