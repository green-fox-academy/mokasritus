package com.gfa.movieapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest req,
                       HttpServletResponse res,
                       AuthenticationException authException) throws IOException, ServletException {

    ObjectMapper mapper = new ObjectMapper();
    res.setContentType("application/json;charset=UTF-8");
    res.setStatus(403);
    try {
      res.getWriter().write(String.valueOf(new JSONObject()
          .put("timestamp", new Date())
          .put("status", 403)
          .put("error", "Forbidden")
          .put("path", "/hello")
          .put("message", "Access denied")));
    } catch (JSONException e) {
      e.printStackTrace();
      //be kell húzni a json dependency-t
    }
  }
}
