package za.ac.cput.requests;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.domain.school;
import za.ac.cput.factory.schoolFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class schoolRequest
{
    private static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static  String get(String getURL) throws IOException
    {
        Request request = new Request.Builder()
                .url(getURL)
                .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                .build();
        try (Response response = client.newCall(request).execute())
        {
            return response.body().string();
        }
    }
    
    private static String post(final String postURL, String json) throws IOException
    {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(postURL)
                .post(body)
                .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                .build();
        try (Response response = client.newCall(request).execute())
        {
            return response.body().string();
        }
    }
    
    private static String delete(final String deleteURL) throws IOException
    {
        Request request = new Request.Builder()
                .url(deleteURL)
                .delete()
                .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                .build();
        
        try (Response response = client.newCall(request).execute())
        {
            return response.body().string();
        }
    }
    
    public static void deleteSchool(String schoolCode)
    {
        try
        {
            final String deleteURL = "http://localhost:8080/Student_Management-ADP3-Group14/school/deleteSchool/" + schoolCode;
            delete(deleteURL);
            String responseBody = get(deleteURL);
            JOptionPane.showMessageDialog(null, "successfully Deleted");
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
    }
    
    public static List<school> getAll()
    {
        List<school>schoolList = new ArrayList<>();
        try
        {
            final String getURL = "http://localhost:8080/Student_Management-ADP3-Group14/school/readAllSchool";
            String responseBody = get(getURL);
            JSONArray schools = new JSONArray(responseBody);
            
            for(int i = 0; i < schools.length(); i++)
            {
                JSONObject school = schools.getJSONObject(i);
                Gson get = new Gson();
                school c = get.fromJson(school.toString(), school.class);
                schoolList.add(c);
                System.out.println(c);
            }
            
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return schoolList;
    }
    
    public static void save_school(String schoolCode, String schoolName)
    {
        try
        {
            final String postURL = "http://localhost:8080/Student_Management-ADP3-Group14/school/save_school";
            school school = schoolFactory.createSchool(schoolCode, schoolName);
            Gson post = new Gson();
            String jsonString = post.toJson(school);
            String c = post(postURL, jsonString);
            if (c != null)
                JOptionPane.showMessageDialog(null, "successfully saved");
            else
                JOptionPane.showMessageDialog(null, "Error - Could not Save");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
