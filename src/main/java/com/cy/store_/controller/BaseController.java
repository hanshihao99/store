package com.cy.store_.controller;

import com.cy.store_.controller.ex.FileIOException;
import com.cy.store_.controller.ex.FileUploadException;
import com.cy.store_.service.ProductService;
import com.cy.store_.service.ex.*;
import com.cy.store_.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/10/01:28
 */
public class BaseController {

    public static final Integer SUC = 200;

    // 请求处理方法，这个方法的返回值就是需要传递给前端的数据
    // 自动将异常对象传递给此方法的参数列表上
    // 当前项目中产生异常，被统一拦截到此方法中，这个方法就充当了请求处理方法
    @ExceptionHandler({ServiceException.class, FileUploadException.class}) // 用于统一处理抛出的异常
    public JsonResult<Void> handleException(Exception e){
        JsonResult<Void> result = new JsonResult<>(SUC);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用的异常");
        } else if (e instanceof UsernameNotFoundException) {
            result.setState(4001);
            result.setMessage(e.getMessage());
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage(e.getMessage());
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生异常");
        }else if(e instanceof UpdateException){
            result.setState(5001);
            result.setMessage(e.getMessage());
        }else if(e instanceof FileIOException){
            result.setState(6001);
            result.setMessage(e.getMessage());
        }else if(e instanceof AddressCountLimitException){
            result.setState(7001);
            result.setMessage(e.getMessage());
        }else if(e instanceof AccessDeniedException){
            result.setState(8001);
            result.setMessage(e.getMessage());
        }else if(e instanceof AddressNotFoundException){
            result.setState(7002);
            result.setMessage(e.getMessage());
        }else if(e instanceof DeleteException){
            result.setState(7003);
            result.setMessage(e.getMessage());
        } else if (e instanceof ProductNotFoundException) {
            result.setState(9001);
            result.setMessage(e.getMessage());
        } else if (e instanceof CartNotFountException) {
            result.setState(9002);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 获取当前登录的uid
     * @param session session对象
     * @return 当前用户登录的uid
     */
    public final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    /**
     * 获取当前登录的username
     * @param session session对象
     * @return 当前登录的用户名
     */
    public final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
