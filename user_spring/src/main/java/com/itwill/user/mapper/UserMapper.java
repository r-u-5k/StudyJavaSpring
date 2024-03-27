package com.itwill.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.user.User;
@Mapper
public interface UserMapper {
	@Insert("insert into userinfo(userid,password,name,email) values(#{userId},#{password},#{name},#{email})")
	int insert(User user);
	/*
	<insert id="insert" parameterType="com.itwill.user.User">
			insert into userinfo(userid,password,name,email) 
			values(#{userId},#{password},#{name},#{email})
	</insert>
	*/
	@Update("update userinfo set password=#{password},name=#{name},email=#{email} where userid=#{userId}")
	public int update(User user);
	/*
	<update id="update" parameterType="com.itwill.user.User">
		update  userinfo set password=#{password},name=#{name},email=#{email} where userid=#{userId}
	</update>
	*/
	@Delete("delete userinfo where userid=#{userId}")
	public int delete(String userId) throws Exception;
	/*
	<delete id="delete" parameterType="java.lang.String">
		delete userinfo where userid=#{userId}
	</delete>
	 */
	@ResultType(User.class)
	@Select("select userid,password,name,email from userinfo where userid=#{userId}")
	public User findUser(String userId);

	/*
	<select id="findUser" parameterType="string" resultType="com.itwill.user.User">
		select userid,password,name,email from userinfo where userid=#{userId}
	</select>
	*/
	@ResultType(User.class)
	@Select("select userid,password,name,email from userinfo")
	public List<User> findUserList();

	/*
	<select id="findUserList" resultType="com.itwill.user.User">
		select userid,password,name,email from userinfo
	</select>
	*/
	@Select("select count(*) cnt from userinfo where userid=#{userId}")
	int countByUserId(String userId) throws Exception;
	/*
	<select id="countByUserId" 	parameterType="java.lang.String" 
								resultType="java.lang.Integer">
		select count(*) cnt from userinfo where userid=#{userId}
	</select>
	*/

}