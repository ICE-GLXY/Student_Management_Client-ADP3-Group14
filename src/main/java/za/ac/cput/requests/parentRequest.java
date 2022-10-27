package za.ac.cput.requests;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.domain.parent;
import za.ac.cput.factory.parentFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class parentRequest
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
    
    public static void deleteParent(String parentCode)
    {
        try
        {
            final String deleteURL = "http://localhost:8080/Student_Management-ADP3-Group14/parent/deleteParent/" + parentCode;
            delete(deleteURL);
            String responseBody = get(deleteURL);
            JOptionPane.showMessageDialog(null, "successfully Deleted");
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
    }
    
    public static List<parent> getAll()
    {
        List<parent>parentList = new ArrayList<>();
        try
        {
            final String getURL = "http://localhost:8080/Student_Management-ADP3-Group14/parent/readAllParents";
            String responseBody = get(getURL);
            JSONArray parents = new JSONArray(responseBody);
            
            for(int i = 0; i < parents.length(); i++)
            {
                JSONObject parent = parents.getJSONObject(i);
                Gson get = new Gson();
                parent c = get.fromJson(parent.toString(), parent.class);
                parentList.add(c);
                System.out.println(c);
            }
            
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return parentList;
    }
    
    public static void save_parent(String parentCode, String name, String email,
                                   String mobileNo, String address, String username,
                                   String password)
    {
        try
        {
            final String postURL = "http://localhost:8080/Student_Management-ADP3-Group14/parent/save_parent";
            parent parent = parentFactory.createParent(parentCode, name, email,
                    mobileNo, address, username,
                    password);
            Gson post = new Gson();
            String jsonString = post.toJson(parent);
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
