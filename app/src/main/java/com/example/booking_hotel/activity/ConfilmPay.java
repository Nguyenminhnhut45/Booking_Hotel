package com.example.booking_hotel.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.booking_hotel.Login;
import com.example.booking_hotel.R;
import com.example.lib.Data.Model.BookingModel;
import com.example.lib.Data.Remote.ApiUtils;
import com.example.lib.Data.Remote.Method;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfilmPay extends AppCompatActivity {
ImageView imageView;
    AppCompatButton btn_THanhToan;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confilm_pay);
        imageView=findViewById(R.id.IMGSP);
        btn_THanhToan=findViewById(R.id.post_liquidation_btn);
        imageView.setImageBitmap(ChiTietPhong.im);
        StorageReference storageRef = storage.getReferenceFromUrl("gs://thanh-l-c.appspot.com");


        btn_THanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                StorageReference mountainsRef = storageRef.child("imgae" + calendar.getTimeInMillis() + ".png");

                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }

                        // Continue with the task to get the download URL
                        return mountainsRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downloadUri = task.getResult();
                            Toast.makeText(getApplicationContext(), "Thành Công"+String.valueOf(downloadUri), Toast.LENGTH_SHORT).show();
                            Log.d("AAAA",String.valueOf(downloadUri)+"");

                        //    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

                            Method methods = ApiUtils.getSOService();
                            BookingModel bookingModel= new BookingModel();
                            bookingModel.setIdcustomer("3f1f9d81-13fa-4dee-ad79-bd09b1fac178");
                            methods.InsertBooking(bookingModel).enqueue(new Callback<BookingModel>() {
                                @Override
                                public void onResponse(Call<BookingModel> call, Response<BookingModel> response) {
                                    Toast.makeText(getApplicationContext(), "Thành Công", Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void onFailure(Call<BookingModel> call, Throwable t) {

                                }
                            });




                        } else {
                            // Handle failures
                            // ...
                        }

                    }


                });

            }
        });
    }
}