package com.firelord.component.security._1_auth._2_token.jwt;

import com.firelord.component.date.DateUtilsEx;
import com.firelord.component.security._1_auth._2_token.jwt.vo.TokenJWTVo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Demo: <br>
 * String strToken = TokenJWTUtilsEx.getInstance().generateToken("xxxx", 60 * 60
 * * 1000, "secret"); <br>
 * String strRes = TokenJWTUtilsEx.getInstance().parseToken(strToken, "secret");
 * <br>
 * boolean isValid = TokenJWTUtilsEx.getInstance().isValid(strToken, "secret");
 * <br>
 */
public class TokenJWTUtilsEx {
	// #region Construction

	public static TokenJWTUtilsEx getInstance() {
		return new TokenJWTUtilsEx();
	}

	// #endregion

	// #region generateToken

	public String generateToken(TokenJWTVo oTokenJWTVo) {
		String strJWT = Jwts.builder().setSubject(oTokenJWTVo.getUser())
				.setExpiration(DateUtilsEx.addMs(Integer.parseInt(oTokenJWTVo.getExpireMs()), DateUtilsEx.TIMEZONE_0))
				.signWith(SignatureAlgorithm.HS512, oTokenJWTVo.getSecretKey()).compact();
		return strJWT;
	}

	// #endregion

	// #region parseToken

	public String parseToken(String strToken, String strSecretKey) {
		String strRes = Jwts.parser().setSigningKey(strSecretKey).parseClaimsJws(strToken).getBody().getSubject();
		return strRes;
	}

	// #endregion

	// #region isValid

	public boolean isValid(String strToken, String strSecretKey) {
		try {
			Jwts.parser().setSigningKey(strSecretKey).parseClaimsJws(strToken);
			return true;
		} catch (Exception ex) {
			// 潜规则：Jwt的API设计成这样，此处try-catch内部消化
			return false;
		}
	}

	// #endregion
}
