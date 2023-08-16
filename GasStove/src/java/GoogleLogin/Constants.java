/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GoogleLogin;

/**
 *
 * @author Lenovo
 */
//Dùng để lưu client_id, client_secret, redirect_uri của ứng dung JSPServet-AccessGoogle
    public class Constants {
  public static String GOOGLE_CLIENT_ID = "285513587704-bfomf8qlc0kijp8167fpar8co8lp3s8n.apps.googleusercontent.com";
  public static String GOOGLE_CLIENT_SECRET = "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";
  public static String GOOGLE_REDIRECT_URI = "http://localhost:9999/GasStove/login-google";
  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
  public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
    

