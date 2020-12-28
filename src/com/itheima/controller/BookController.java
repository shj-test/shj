package com.itheima.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.itheima.po.ResultInfo;
import com.itheima.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itheima.po.Book;
import com.itheima.po.User;
import com.itheima.service.BookService;
import com.itheima.service.UserService;

@RestController
public class BookController {
	// 依赖注入
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	@Autowired
    private TypeService typeService;

	//首页,通过类型查找并显示书籍
//	@RequestMapping(value = "/index.action")
//	public String index(Model model) {
//		List<Book> cslist=bookService.findwithtype("重生");
//		List<Book> cylist=bookService.findwithtype("穿越");
//		List<Book> dmlist=bookService.findwithtype("耽美");
//		List<Book> xxlist=bookService.findwithtype("仙侠");
//		model.addAttribute("cslist", cslist);
//		model.addAttribute("cylist", cylist);
//		model.addAttribute("dmlist", dmlist);
//		model.addAttribute("xxlist", xxlist);
//		return "index";
//	}

	//通过关键字查找书籍(前台)
	@RequestMapping("/word")
	public ResultInfo selbook(String word) {
        try {
            word=new String(word.getBytes("ISO-8859-1"),"UTF-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("不能辨别中文！");
        }
		List<Book> list=bookService.findwithname(word);
		//获取书籍数量
		String x= String.valueOf(list.size());
		return new ResultInfo(true,word,list);
	}

	//通过类型查找书籍
	@RequestMapping(value = "/type")
	public List<Book> type(String type,Model model) {
		try {
			type=new String(type.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("不能辨别中文！");
		}
		List<Book> list=bookService.findwithtype(type);
		int x=list.size();
		model.addAttribute("type", type);
		model.addAttribute("x", x);
		model.addAttribute("list", list);
		return list;
	}

	//查询所有书籍
	@RequestMapping(value = "/findBook")
	public ResultInfo findBook(@RequestParam(required = false,defaultValue = "-1") int id) {
		List<Book> list=bookService.findBook(id);
		String x= String.valueOf(list.size());
		return new ResultInfo(true,x,list);
	}

	//删除书籍（后台）
	@RequestMapping(value = "/bookdel")
	public ResultInfo bookdel(Integer id){
		int n=bookService.delbook(id);
		if(n>0){
			return new ResultInfo(true,"删除成功！");
		}else{
            return new ResultInfo(true,"删除失败！");
        }
	}

	//书籍详情
	@RequestMapping(value = "/detail")
	public ResultInfo detail(int id, @RequestParam(required = false, defaultValue = "") String uid) {
		//通过id查找书籍
		List<Book> book=bookService.findBook(id);
		//判断书籍是否在用户书架，如果在，“加入书架”按钮显示为“已在书架”
		if(uid.equals("")){
            return new ResultInfo(true,"加入书架",book);
		}else {
            int bid=id;
            User user1=userService.find(Integer.parseInt(uid), bid);
            if(user1!=null){
                return new ResultInfo(true,"已在书架",book);
            }else{
                return new ResultInfo(true,"加入书架",book);
            }
        }
	}

    //	查找书籍的评论
    @RequestMapping("/findBC")
    public ResultInfo findBC(@RequestParam(required = false,defaultValue = "-1") int id){
        List<Book> list=bookService.findBC(id);
        return new ResultInfo(true,list);
    }

	//	查找书籍的收藏者
	@RequestMapping("/findBU")
	public ResultInfo findBU(@RequestParam(required = false,defaultValue = "-1") int id){
		List<Book> list=bookService.findBU(id);
		return new ResultInfo(true,list);
	}

    //	查找书籍的章节
	@RequestMapping("/findBCh")
	public ResultInfo findBCh(@RequestParam(required = false,defaultValue = "-1") int id){
		List<Book> list=bookService.findBCh(id);
		return new ResultInfo(true,list);
	}

    /*
    查询书籍信息
    修改书籍信息,获取原书籍信息，将信息显示在相应表单域
    */
    @RequestMapping(value = "/updbook")
    public ResultInfo tobookupd(Integer id){
        //通过id查找书籍
        List<Book> book=bookService.findBook(id);
        return new ResultInfo(true,book);
    }

	//获取修改后的书籍信息
	@RequestMapping(value = "/bookupd")
	public ResultInfo bookupd(int bid,String name, String type,String image,String blurb) {
        try {
            name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
            type=new String(type.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int tid=typeService.findName(type);
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("bid", bid);
        map.put("name", name);
        map.put("tid", tid);
        map.put("image", image);
        map.put("blurb", blurb);
		int n=bookService.updbook(map);
		if(n>0){
			//修改成功
			return new ResultInfo(true,"修改成功");
		}
		return null;
	}

//	// 添加书籍
//    @RequestMapping(value = "/bookadd")
//    public ResultInfo bookadd(String name,int uid,String type,String image,String blurb) {
//        try {
//            name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
//            type=new String(type.getBytes("ISO-8859-1"),"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        int tid=typeService.findName(type);
//        HashMap<String,Object> map = new HashMap<String, Object>();
//        map.put("name", name);
//        map.put("uid", uid);
//        map.put("tid", tid);
//        map.put("image", image);
//        map.put("blurb", blurb);
//        int n=bookService.addbook(map);
//        if(n>0){
//            //添加成功
//            return new ResultInfo(true,"ok",bookService.findwithname(name));
//        }
//        return null;
//    }


    // 添加书籍
    @RequestMapping(value = "/bookadd")
    public ResultInfo bookadd(@RequestParam("image") MultipartFile image,String name,int uid,String type,
                               String blurb,HttpServletRequest request) {
        System.out.println(name+","+uid+","+type+","+","+image+","+blurb);
        String image_name = null;
        // 判断所上传文件是否存在
        if (!image.isEmpty()) {
            // 获取上传文件的原始名称
            String iname = image.getOriginalFilename();
            // 设置上传文件的保存地址目录
            String dirPath =
                    request.getServletContext().getRealPath("/images/");
            File filePath = new File(dirPath);
            // 如果保存文件的地址不存在，就先创建目录
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                // 使用MultipartFile接口的方法完成文件上传到指定位置
                image.transferTo(new File(dirPath +"/"+ iname));
                image_name="images/"+iname;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("1.出错了...");
                return new ResultInfo(false,"error");
            }
        }else{
            System.out.println("2.出错了...");
            return new ResultInfo(false,"error");

        }


//        try {
//            name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
//            type=new String(type.getBytes("ISO-8859-1"),"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        int tid=typeService.findName(type);
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("uid", uid);
        map.put("tid", tid);
        map.put("image", image_name);
        map.put("blurb", blurb);
        int n=bookService.addbook(map);
        if(n>0){
            //添加成功
            return new ResultInfo(true,"ok",bookService.findwithname(name));
        }
        return new ResultInfo(false,"error");
    }

    //    //添加书籍（后台）
//    @RequestMapping(value = "/bookadd.action", method = RequestMethod.POST)
//    public String bookadd(String name,String author,String type,@RequestParam("image_path") MultipartFile image_path,String blurb,
//                          Model model,HttpServletRequest request) {
//        String image_name = null;
//        // 判断所上传文件是否存在
//        if (!image_path.isEmpty()) {
//            // 获取上传文件的原始名称
//            String iname = image_path.getOriginalFilename();
//            // 设置上传文件的保存地址目录
//            String dirPath =
//                    request.getServletContext().getRealPath("/images/");
//            File filePath = new File(dirPath);
//            // 如果保存文件的地址不存在，就先创建目录
//            if (!filePath.exists()) {
//                filePath.mkdirs();
//            }
//            try {
//                // 使用MultipartFile接口的方法完成文件上传到指定位置
//                image_path.transferTo(new File(dirPath +"/"+ iname));
//                image_name="images/"+iname;
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("出错了...");
//                return"error";
//            }
//        }
//
//        //创建书籍对象
//        Book book=new Book(name,author,type,image_name,blurb);
//        //将书籍添加到相应表中
//        int n=bookService.addbook(book);
//        if(n>0){
//            //添加成功
//            model.addAttribute("addmessage", "新增成功！");
//            return "bookadd";
//        }
//        return null;
//    }



//    //修改书籍（后台）
//    @RequestMapping(value = "/bookupd.action", method = RequestMethod.POST)
//    public String bookupd(Integer id,Model model,String name,String author,
//                          String type,@RequestParam("image_path") MultipartFile image_path,String blurb,
//                          HttpServletRequest request) {
//        String image_name = null;
//        // 鍒ゆ柇鎵�涓婁紶鏂囦欢鏄惁瀛樺湪
//        if (!image_path.isEmpty()) {
//            //寰幆杈撳嚭涓婁紶鐨勬枃浠�
//
//            // 鑾峰彇涓婁紶鏂囦欢鐨勫師濮嬪悕绉�
//            String iname = image_path.getOriginalFilename();
//            // 璁剧疆涓婁紶鏂囦欢鐨勪繚瀛樺湴鍧�鐩綍
//            String dirPath =
//                    request.getServletContext().getRealPath("/images/");
//            File filePath = new File(dirPath);
//            // 濡傛灉淇濆瓨鏂囦欢鐨勫湴鍧�涓嶅瓨鍦紝灏卞厛鍒涘缓鐩綍
//            if (!filePath.exists()) {
//                filePath.mkdirs();
//            }
//            try {
//                // 浣跨敤MultipartFile鎺ュ彛鐨勬柟娉曞畬鎴愭枃浠朵笂浼犲埌鎸囧畾浣嶇疆
//                image_path.transferTo(new File(dirPath +"/"+ iname));
//                image_name="images/"+iname;
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("出错了...");
//                return"error";
//            }
//        }
//        //生成新书籍对象
//        Book book=new Book(id,name,author,type,image_name,blurb);
//        //修改书籍信息
//        int n=bookService.updbook(book);
//        if(n>0){
//            //修改成功
//            model.addAttribute("book", book);
//            model.addAttribute("updmessage", "修改成功！");
//            return "bookupd";
//        }
//        return null;
//    }
//
//
//    @RequestMapping("/download.action")
//    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,
//                                               String filename) throws Exception{
//        try {
//            filename=new String(filename.getBytes("ISO-8859-1"),"UTF-8");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println("不能辨别中文！");
//        }
//        // 指定要下载的文件所在路径
//        String path = request.getServletContext().getRealPath("/");
//        // 创建该文件对象
//        File file = new File(path+ File.separator+filename);
//        // 设置响应头
//        HttpHeaders headers = new HttpHeaders();
//        //通知浏览器以下载的方式打开文件
//        headers.setContentDispositionFormData("attachment", filename);
//        //定义以流的形式下载返回文件数据
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        //使用SringMVC框架的ResponseEntity对象封装返回下载数据
//        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
//                headers, HttpStatus.OK);
//    }
}