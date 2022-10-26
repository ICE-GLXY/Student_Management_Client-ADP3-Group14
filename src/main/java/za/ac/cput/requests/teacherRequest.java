package za.ac.cput.requests;
/*
 * Author Lelihle Gazi - (214258041)
 * teacherRequest.java
 * Capstone Project
 * 2022
 */
import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.domain.teacher;
import za.ac.cput.factory.teacherFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class teacherRequest {

    private static OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static String get(String getURL) throws IOException {
        Request request = new Request.Builder()
                .url(getURL)
                .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();

        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return getURL;
    }

    private static String post(final String postUrl, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();

        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return postUrl;
    }
    private static String delete(final String deleteUrl) throws IOException {
        Request request = new Request.Builder()
                .url(deleteUrl)
                .delete()
                .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return deleteUrl;
    }

    public static void deleteTeacher(String teacherId)
    {
        try
        {
            final String deleteURL = "http://localhost:8080/Student_Management-ADP3-Group14/teacher/deleteTeacher/" + teacherId;
            delete(deleteURL);
            String responseBody = get(deleteURL);
            JOptionPane.showMessageDialog(null, "successfully Deleted");
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
    }

    public static List<teacher> getAll()
    {
        List<teacher>teacherList = new ArrayList<>();
        try
        {
            final String getUrl = "http://localhost:8080/Student_Management-ADP3-Group14/teacher/readAllTeachers";
            String responseBody = get(getUrl);
            JSONArray teachers = new JSONArray(responseBody);

            for(int i = 0; i < teachers.length(); i++)
            {
                JSONObject teacher = teachers.getJSONObject(i);
                Gson get = new Gson();
                teacher c = get.fromJson(teacher.toString(), teacher.class);
                teacherList.add(c);
                System.out.println(c);
            }

        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return teacherList;
    }

    public static void save_teacher(String teacherID, String username, String password, int i, String email)
    {
        try
        {
            final String postUrl = "http://localhost:8080/Student_Management-ADP3-Group14/teacher/save_teacher";
            teacher teacher = teacherFactory.createTeacher("t1", "teacher1", "123456", "teacher1@gmail.com");
            Gson post = new Gson();
            String jsonString = post.toJson(teacher);
            String c = post(postUrl, jsonString);
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

