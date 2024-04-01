package com.techno.springbootdasar.util

import com.techno.springbootdasar.domain.dto.request.ReqEncodeJWTDto
import com.techno.springbootdasar.domain.dto.request.ReqLoginDto
import com.techno.springbootdasar.domain.dto.request.ReqLoginJwtDto
import com.techno.springbootdasar.domain.dto.request.ReqProfileDto
import com.techno.springbootdasar.domain.dto.response.ResProfileDto
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.Date
import javax.crypto.spec.SecretKeySpec

class JWTGenerator {
    companion object{
        private const val SECRET_KEY = "YOUR_SECRET_KEY_THAT_HAS_256_LONG"
        private val instance: JWTGenerator = JWTGenerator()
    }
    fun loginJWT(req: ReqLoginJwtDto): String{
        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
        val nowMillis: Long = System.currentTimeMillis()
        val now = Date(nowMillis)

        val apiKeySecretBytes = SECRET_KEY.toByteArray()
        val signInKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)

        val builder: JwtBuilder = Jwts.builder().setSubject(req.id.toString())
            .claim("id", req.id)
            .claim("name", req.name)
            .claim("username", req.username)
            .claim("email", req.email)
            .setIssuer("technocenter")
            .setAudience("technocenter")
            .signWith(signInKey, signatureAlgorithm)

        val expMillis = nowMillis + 3600000L
        val exp = Date(expMillis)
        builder.setExpiration(exp)

        return builder.compact()
    }
    fun createJWT(req: ReqEncodeJWTDto): String{
        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
        val nowMillis: Long = System.currentTimeMillis()
        val now = Date(nowMillis)

        val apiKeySecretBytes = SECRET_KEY.toByteArray()
        val signInKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)

        val builder: JwtBuilder = Jwts.builder().setSubject(req.id)
            .claim("id", req.id)
            .claim("role", req.role)
            .claim("email", req.email)
            .claim("password", req.password)
            .setIssuer("technocenter")
            .setAudience("technocenter")
            .signWith(signInKey, signatureAlgorithm)

//        val builder: JwtBuilder = Jwts.builder().setId(id)
//            .setIssuedAt(now)
//            .setSubject(subject)
//            .setIssuer("technocenter")
//            .setAudience("technocenter")
//            .signWith(signInKey, signatureAlgorithm)

        val expMillis = nowMillis + 3600000L
        val exp = Date(expMillis)
        builder.setExpiration(exp)

        return builder.compact()
    }
    fun decodeJWT(jwt: String): Claims{
        try {
            val claims: Claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.toByteArray())
                .build()
                .parseClaimsJws(jwt).body
            return claims
        }catch (e: JwtException){
            e.printStackTrace()
            throw RuntimeException("Invalid token")
        }
    }
}

