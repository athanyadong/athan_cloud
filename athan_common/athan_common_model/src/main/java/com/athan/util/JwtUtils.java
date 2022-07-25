package com.athan.util;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSON;
import com.athan.model.constant.TokenConstants;
import com.athan.user.model.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @aurhor yyh
 * @description token工具类
 * @date 2022/7/13 14:28
 */
public class JwtUtils {

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public static String creatToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.ES512, TokenConstants.SECRET).compact();
    }


    /**
     * 从令牌中获取数据声明  ==验签，获取信息
     */
    public static Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(TokenConstants.SECRET).parseClaimsJws(token).getBody();
    }

    /**
     * 解析
     *
     * @param claims 身份信息
     * @param key    键
     * @return 值
     */
    public static String getValue(Claims claims, String key) {
        return Convert.toStr(claims.get(key), "");
    }

}
