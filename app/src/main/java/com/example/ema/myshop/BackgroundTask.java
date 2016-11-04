package com.example.ema.myshop;

    import android.app.Activity;
    import android.app.AlertDialog;
    import android.content.Context;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.graphics.Bitmap;
    import android.os.AsyncTask;
    import android.widget.EditText;
    import android.widget.Toast;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.io.OutputStreamWriter;
    import java.net.HttpURLConnection;
    import java.net.MalformedURLException;
    import java.net.URL;
    import java.net.URLEncoder;

    /**
     * Created by EMA on 13/06/2016.
     */
    public class BackgroundTask extends AsyncTask<String,Void,String> {

        Context ctx;
        AlertDialog alertDialog;
        Activity activity;

        BackgroundTask(Context ctx){
            this.ctx=ctx;
            this.activity= (Activity) ctx;
        }

        @Override
        protected String doInBackground(String... params) {
            String url_shop="http://192.168.1.66/webapp/register_shop.php";
            String url_user="http://192.168.1.66/webapp/register_user.php";
            String url_product="http://192.168.1.66/webapp/register_product.php";
            String login_url="http://192.168.1.66/webapp/login.php";
            String method=params[0];
            if(method.equals("shop_register")){

                String shop_username=params[1];
                String shop_pass=params[2];
                String shop_Name=params[3];
                String shop_Phone=params[4];
                String shop_Latitude=params[5];
                String shop_Longitude=params[6];

                String ID="70";
                try {
                    URL url=new URL(url_shop);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream os=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                    String data= URLEncoder.encode("shop_id","UTF-8")+"="+URLEncoder.encode(ID,"UTF-8")+"&"+
                            URLEncoder.encode("shop_username","UTF-8")+"="+URLEncoder.encode(shop_username,"UTF-8")+"&"+
                            URLEncoder.encode("shop_pass","UTF-8")+"="+URLEncoder.encode(shop_pass,"UTF-8")+"&"+
                            URLEncoder.encode("shop_Name","UTF-8")+"="+URLEncoder.encode(shop_Name,"UTF-8")+"&"+
                            URLEncoder.encode("shop_Phone","UTF-8")+"="+URLEncoder.encode(shop_Phone,"UTF-8")+"&"+
                            URLEncoder.encode("shop_Latitude","UTF-8")+"="+URLEncoder.encode(shop_Latitude,"UTF-8")+"&"+
                            URLEncoder.encode("shop_Longitude","UTF-8")+"="+URLEncoder.encode(shop_Longitude,"UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();
                    InputStream is=httpURLConnection.getInputStream();
                    is.close();
                    httpURLConnection.disconnect();
                    return "Registration Shop Success...";
                } catch (MalformedURLException e) {
                    return e.getMessage();
                } catch (IOException e) {
                    return e.getMessage();
                }
            }
            else if(method.equals("user_register")){

                String user_Name=params[1];
                String user_pass=params[2];
                String user_Phone=params[3];
                String user_Latitude=params[4];
                String user_Longitude=params[5];

                String ID="70";
                try {
                    URL url=new URL(url_user);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream os=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                    String data= URLEncoder.encode("user_id","UTF-8")+"="+URLEncoder.encode("1","UTF-8")+"&"+
                            URLEncoder.encode("user_pass","UTF-8")+"="+URLEncoder.encode(user_pass,"UTF-8")+"&"+
                            URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_Name,"UTF-8")+"&"+
                            URLEncoder.encode("user_phone","UTF-8")+"="+URLEncoder.encode(user_Phone,"UTF-8")+"&"+
                            URLEncoder.encode("shop_Latitude","UTF-8")+"="+URLEncoder.encode(user_Latitude,"UTF-8")+"&"+
                            URLEncoder.encode("shop_Longitude","UTF-8")+"="+URLEncoder.encode(user_Longitude,"UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();
                    InputStream is=httpURLConnection.getInputStream();
                    is.close();
                    httpURLConnection.disconnect();
                    return "Registration user Success...";
                } catch (MalformedURLException e) {
                    return e.getMessage();
                } catch (IOException e) {
                    return e.getMessage();
                }
            }
            else if(method.equals("product_register")){

                String user_Name=params[1];
                String user_pass=params[2];
                String user_Phone=params[3];
                String user_Latitude=params[4];
                String user_Longitude=params[5];

                String ID="70";
                try {
                    URL url=new URL(url_user);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream os=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                    String data= URLEncoder.encode("user_id","UTF-8")+"="+URLEncoder.encode("1","UTF-8")+"&"+
                            URLEncoder.encode("user_pass","UTF-8")+"="+URLEncoder.encode(user_pass,"UTF-8")+"&"+
                            URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_Name,"UTF-8")+"&"+
                            URLEncoder.encode("user_phone","UTF-8")+"="+URLEncoder.encode(user_Phone,"UTF-8")+"&"+
                            URLEncoder.encode("shop_Latitude","UTF-8")+"="+URLEncoder.encode(user_Latitude,"UTF-8")+"&"+
                            URLEncoder.encode("shop_Longitude","UTF-8")+"="+URLEncoder.encode(user_Longitude,"UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();
                    InputStream is=httpURLConnection.getInputStream();
                    is.close();
                    httpURLConnection.disconnect();
                    return "Registration Product Success...";
                } catch (MalformedURLException e) {
                    return e.getMessage();
                } catch (IOException e) {
                    return e.getMessage();
                }
            }
            else if (method.equals("login")){
                String login_name=params[1];
                String login_pass=params[2];
                try {
                    URL url=new URL(login_url);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream os=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                    String data =URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                            URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();

                    InputStream is=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                    String response="";
                    String line="";
                    while((line=bufferedReader.readLine())!=null){
                        response+=line;
                    }
                    bufferedReader.close();
                    is.close();
                    httpURLConnection.disconnect();
                    return response;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return "Not Error";
        }
        @Override
        protected void onProgressUpdate(Void... values){
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPreExecute(){
            alertDialog = new AlertDialog.Builder(ctx).create();
            alertDialog.setTitle("Login Status");
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(String result){
            alertDialog.setMessage(result);
            alertDialog.show();
            if(!(result.equals("Not Error")||result.equals(""))) {
                Toast.makeText(activity, result, Toast.LENGTH_LONG).show();
                activity.startActivity(new Intent(activity, Seller.class));
            }

//            try {
//                Thread.sleep(1000);
//                alertDialog.dismiss();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }


    }
