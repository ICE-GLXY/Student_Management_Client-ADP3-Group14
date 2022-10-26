package za.ac.cput.requests;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.domain.user;
import za.ac.cput.factory.userFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class userRequest
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

    public static void deleteUser(String emailAddress)
    {
        try
        {
            final String deleteURL = "http://localhost:8080/Student_Management-ADP3-Group14/user/deleteUser/" + emailAddress;
            delete(deleteURL);
            String responseBody = get(deleteURL);
                JOptionPane.showMessageDialog(null, "successfully Deleted");
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
    }

    public static List<user> getAll()
    {
        List<user>userList = new ArrayList<>();
        try
        {
            final String getURL = "http://localhost:8080/Student_Management-ADP3-Group14/user/readAllUsers";
            String responseBody = get(getURL);
            JSONArray users = new JSONArray(responseBody);

            for(int i = 0; i < users.length(); i++)
            {
                JSONObject user = users.getJSONObject(i);
                Gson get = new Gson();
                user c = get.fromJson(user.toString(), user.class);
                userList.add(c);
                System.out.println(c);
            }

        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return userList;
    }

    public static void save_user(String emailAddress, String password, String passwordConfirmation, int grade, String userType)
    {
        try
        {
            final String postURL = "http://localhost:8080/Student_Management-ADP3-Group14/user/save_user";
            user user = userFactory.createUser(emailAddress, password, passwordConfirmation, grade, userType);
            Gson post = new Gson();
            String jsonString = post.toJson(user);
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
