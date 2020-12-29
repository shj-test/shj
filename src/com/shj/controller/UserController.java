package com.shj.controller;

import javax.servlet.http.HttpSession;

import com.shj.po.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shj.po.User;
import com.shj.service.UserService;

import java.util.List;

@RestController
public class UserController {
	// 依赖注入
		@Autowired
		private UserService userService;

        // 通过账号和密码查询用户
		@RequestMapping(value = "/log")
		public ResultInfo login(String name, String pwd, HttpSession session) {
			User user = userService.findUser(name,pwd);
			if(user != null){		
				// 将用户对象添加到Session
				session.setAttribute("loginuser", user);
				session.setMaxInactiveInterval(30*60);
				user.setStatus("1");// 标记为已登录状态
				return new ResultInfo(true,"登录成功",user);
			}
			return new ResultInfo(false,"账号或密码错误，请重新输入！");
		}
		

		//注册：插入用户信息
		@RequestMapping(value = "/register")
		public ResultInfo register(String name, String pwd,String repwd) {
			//判断用户是否已存在
			List<User> list = userService.findname(name);
			if(list.size()>=1) {
                System.out.print("user2");
				return new ResultInfo(false,"该账号已存在，请重新注册！");
			}
			//用户注册
			if(pwd.equals(repwd)&&pwd!=null&&repwd!=null){
				/*//若phone为空，设值为“待完善”
				if(phone==null||phone.equals("")){
					phone="待完善";
				}
				//若email为空，设值为“待完善”
				if(email==null||email.equals("")){
					email="待完善";
				}*/
				// 创建用户对象
				User user = new User(name,pwd);
				// 注册用户
				int n = userService.register(user);
				if (n>0) {
					// 注册成功
					return new ResultInfo(true,"注册成功",user);
				} else {
					//注册失败
					return new ResultInfo(false,"注册失败");
				}
			}
			//两次密码不同
            return new ResultInfo(false,"密码错误，请重新输入！");
		}

        //新增用户(后台)
        @RequestMapping(value = "/useradd")
        public ResultInfo useradd(String name,String pwd,String nickname,String pseudonym) {
            //创建用户对象
            User user=new User(name,pwd,nickname,pseudonym);
            //判断用户是否已存在
            List<User> list = userService.findname(name);
            if(list.size()>=1) {
                System.out.print("user2");
                return new ResultInfo(false,"该账号已存在，请重新注册！");
            }
            //添加用户
            int n=userService.useradd(user);
            if(n>0){
                //添加成功
                return new ResultInfo(true,"新增成功!",user);
            }
            return null;
        }

        //通过id查找用户
        @RequestMapping(value = "/findid")
        public User toUserupd(Integer id) {
            System.out.println("findid");
            User user=userService.findwithid(id);
            return user;
        }

		/**
		 * 退出登录
		 */
		@RequestMapping(value = "/logout")
		public String logout(int id,HttpSession session) {
		    // 清除Session
		    session.invalidate();
            User user = userService.findwithid(id);
            user.setStatus("0");// 标记为未登录状态
		    return null;
		}

		//查询all用户
		@RequestMapping(value = "/user")
		public ResultInfo str() {
			List<User> listuser=userService.findall();
			String msg= String.valueOf(listuser.size());
			return new ResultInfo(true,msg,listuser);
		}

		//通过关键字查找用户
		@RequestMapping(value = "/usersel")
		public ResultInfo usersel(String name) {
			List<User> list=userService.findwithname(name);
			//用户数量
			String x= String.valueOf(list.size());
			return new ResultInfo(true,x,list);
		}

		//通过id删除用户（后台）
		@RequestMapping(value = "/userdel")
		public ResultInfo userdel(Integer id) {
			int n=userService.userdel(id);
			if(n>0) {
				return new ResultInfo(false,"删除成功！");
			}
			return new ResultInfo(false,"删除失败！");
		}

        //通过id删除用户(前台)
        @RequestMapping(value = "/usercancel")
        public ResultInfo cancel(int id,HttpSession session) {
            int n=userService.userdel(id);
            if(n>0){
                //删除成功
                //销毁session
                session.invalidate();
                return new ResultInfo(true,"已注销！");
            }
            return null;
        }


    //删除书架中的书籍
    // ERROR
        @RequestMapping(value = "/delbc")
        public ResultInfo delbc(int uid,int bid) {
            int n=userService.delbc(uid,bid);
            System.out.println("n="+n);
            if(n>0){
                //删除成功
                return new ResultInfo(true,"删除成功！");
            }
            return new ResultInfo(false,"未知错误！");
        }

        //将书籍加入书架
        @RequestMapping(value = "/addbc")
        public ResultInfo addbc(int uid, int bid) {
            int n=userService.addbc(uid, bid);
            if(n>0){
                return new ResultInfo(true,"添加成功！");
            }else {
                return new ResultInfo(false,"添加失败！");
            }
        }

        //获取修改后的用户信息，显示在表单（后台）
		@RequestMapping(value = "/userupd")
		public ResultInfo userupd(Integer id,String name,String pwd,String nickname,String pseudonym) {
			//创建新用户对象
			User user=new User(id,name,pwd,nickname,pseudonym);
			//修改用户信息
			int n=userService.userupd(user);
			if(n>0){
				//修改成功
				return new ResultInfo(true,"修改成功！",user);
			}
			return null;
		}


		//修改用户信息(前台)
		@RequestMapping(value = "/usermanager")
		public ResultInfo userphone(int uid,int nid,String nickname,String pseudonym,String pwd,String repwd) {
			//获取用户对象
//			User user=(User) session.getAttribute("loginuser");

            User user=userService.findwithid(uid);
			//标识符为1，修改用户手机号
			if(nid==1){
				user.setNickname(nickname);
				int n=userService.userupd(user);
				if(n>0){
					//修改成功
					return new ResultInfo(true,"修改成功");
				}
				return null;
			}
			//标识符为2，修改用户邮箱
			if(nid==2){
				user.setPseudonym(pseudonym);
				int n=userService.userupd(user);
				if(n>0){
                    //修改成功
                    return new ResultInfo(true,"修改成功");
				}
				return null;
			}
			//标识符为3，修改用户密码
			if(nid==3){
				if(pwd.equals(repwd)){
					user.setPassword(repwd);
					//修改密码
					int n=userService.userupd(user);
					if(n>0){
                        //修改成功
                        return new ResultInfo(true,"修改成功");
					}
					return null;
				}
                return new ResultInfo(false,"密码错误");
			}
			return null;
		}

	// 查询账户明细
	@RequestMapping("/findUA")
	public ResultInfo findUA(@RequestParam(required = false,defaultValue = "-1") int id){
		List<User> list=userService.findUA(id);
		return new ResultInfo(true,list);
	}

	// 查询收藏列表（书籍）
	@RequestMapping("/findUB")
	public ResultInfo findUB(@RequestParam(required = false,defaultValue = "-1") int id){
		List<User> list=userService.findUB(id);
		return new ResultInfo(true,list);
	}

	// 查询收藏列表（作者）
	@RequestMapping("/findUU")
	public ResultInfo findUU(@RequestParam(required = false,defaultValue = "-1") int id){
		List<User> list=userService.findUU(id);
		return new ResultInfo(true,list);
	}

	// 查询评论
    @RequestMapping("/findUC")
    public ResultInfo findUC(@RequestParam(required = false,defaultValue = "-1") int id){
        List<User> list=userService.findUC(id);
        return new ResultInfo(true,list);
    }

}