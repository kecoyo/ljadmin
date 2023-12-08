package com.dmkj.ljadmin.hardware.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dmkj.ljadmin.common.ResultCode;
import com.dmkj.ljadmin.common.exception.ApiException;
import com.dmkj.ljadmin.common.utils.HttpClientResult;
import com.dmkj.ljadmin.common.utils.HttpClientUtils;
import com.dmkj.ljadmin.hardware.domain.User;
import com.dmkj.ljadmin.hardware.domain.UserAddBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BaseUserService {

    @Value("${service.baseurl.userinfo}")
    private String userInfoBaseURL;

    public User getUserInfoByUserId(int userId) throws Exception {
        JSONObject params = new JSONObject();
        params.put("userId", userId);
        String url = userInfoBaseURL + "/service/user/GetUserInfoByUserId";
        log.info("[getUserInfoByUserId][url: {}]", url);
        log.info("[getUserInfoByUserId][params: {}]", params);
        HttpClientResult result = HttpClientUtils.sendPost(url, params);
        log.info("[getUserInfoByUserId][result: {}]", result);
        if (result.getCode() == 200) {
            JSONObject json = result.getJson();
            if (json.getIntValue("result") == 0) {
                JSONObject data = json.getJSONObject("data");
                if (data != null && data.getIntValue("userId") > 0) {
                    User user = new User();
                    user.setUserId(data.getIntValue("userId"));
                    user.setName(data.getString("name"));
                    user.setPhone(data.getString("phoneNumber"));
                    return user; // 成功，返回用户信息
                }
                return null; // 用户不存在
            }
            log.error("[getUserInfoByUserId][result: {}]", json);
            throw new ApiException(ResultCode.SERVICE_CALL_FAIL.getCode(), json.getString("msg"));
        }
        log.error("[getUserInfoByUserId][result: {}]", result);
        throw new ApiException(ResultCode.SERVICE_CALL_ERROR.getCode(), "用户服务调用异常");
    }

    public User getUserInfoByPhone(String phoneNum) throws Exception {
        JSONObject params = new JSONObject();
        params.put("phoneNumber", phoneNum);
        String url = userInfoBaseURL + "/service/user/GetUserInfoByPhone";

        System.out.println("==> " + url);
        System.out.println("==> " + params);
        HttpClientResult result = HttpClientUtils.sendPost(url, params);
        System.out.println("<== " + result);

        if (result.getCode() == 200) {
            JSONObject json = result.getJson();
            if (json.getIntValue("result") == 0) {
                JSONObject data = json.getJSONObject("data");
                if (data != null && data.getIntValue("userId") > 0) {
                    User user = new User();
                    user.setUserId(data.getIntValue("userId"));
                    user.setName(data.getString("name"));
                    user.setPhone(data.getString("phoneNumber"));
                    return user;
                }
                return null;
            }
            log.error("[getUserInfoByPhone][result: {}]", json);
            throw new ApiException(ResultCode.SERVICE_CALL_FAIL.getCode(), json.getString("msg"));
        }
        log.error("[getUserInfoByPhone][result: {}]", result);
        throw new ApiException(ResultCode.SERVICE_CALL_ERROR.getCode(), "用户服务调用异常");
    }

    public User addUserInfo(UserAddBody userBody) throws Exception {
        JSONObject params = new JSONObject();
        params.put("name", userBody.getName());
        params.put("phone", userBody.getPhone());
        params.put("isThirdParty", 0);
        params.put("gender", 0);
        params.put("ip", "ljadmin");
        String url = userInfoBaseURL + "/service/user/AddUserInfo";

        log.info("[addUserInfo][url: {}]", url);
        log.info("[addUserInfo][params: {}]", params);

        HttpClientResult result = HttpClientUtils.sendPost(url, params);

        log.info("[addUserInfo][result: {}]", result);

        if (result.getCode() == 200) {
            JSONObject json = result.getJson();
            if (json.getIntValue("result") == 0) {
                JSONObject data = json.getJSONObject("data");
                if (data != null && data.getIntValue("userId") > 0) {
                    User user = new User();
                    user.setUserId(data.getIntValue("userId"));
                    user.setName(data.getString("name"));
                    user.setPhone(data.getString("phoneNumber"));
                    return user;
                }
                return null;
            }
            log.error("[addUserInfo][result: {}]", json);
            throw new ApiException(ResultCode.SERVICE_CALL_FAIL.getCode(), json.getString("msg"));
        }
        log.error("[addUserInfo][result: {}]", result);
        throw new ApiException(ResultCode.SERVICE_CALL_ERROR.getCode(), "用户服务调用异常");
    }

}
