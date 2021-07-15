package com.sojson.core.tags;

import com.sojson.common.model.UPermission;
import com.sojson.core.shiro.token.manager.TokenManager;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Set;

public class AuthorizeTag extends BodyTagSupport {
    private String buttonUrl;
    private String buttonMethod;

    public String getButtonUrl() {
        return buttonUrl;
    }

    public void setButtonUrl(String buttonUrl) {
        this.buttonUrl = buttonUrl;
    }

    public String getButtonMethod() {
        return buttonMethod;
    }

    public void setButtonMethod(String buttonMethod) {
        this.buttonMethod = buttonMethod;
    }

    @SuppressWarnings("static-access")
    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        boolean mark=false;
        String username= TokenManager.getNickname();
        Set<UPermission> set=(Set<UPermission>)TokenManager.getVal2Session("permSet");
        for (UPermission upermission:set) {
            if(buttonUrl.equals(upermission.getUrl())&&(upermission.getType().equals("ALL")||upermission.getType().equals(buttonMethod))){
                mark=true;
                break;
            }
        }
        if (mark){
            //显示
            return EVAL_BODY_INCLUDE;
        }else {
            //不显示
            return this.SKIP_BODY;
        }
    }
}
