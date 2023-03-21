package com.song.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.song.Entity.User;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TokenResult<T> {
    private Integer code;
    private String msg;
    private T data;
    private int token;

    public static TokenResult success(Integer code,Object data,String msg,int token) {
        TokenResult result = new TokenResult();
      result.setData(data);
      result.setToken(token);
      result.setMsg(msg);
      result.setCode(code);
        return result;
    }

    public static TokenResult<User> errorResult(int code, String msg) {
        TokenResult result = new TokenResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
