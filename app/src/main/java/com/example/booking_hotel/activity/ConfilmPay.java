package com.example.booking_hotel.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking_hotel.Home;
import com.example.booking_hotel.Login;
import com.example.booking_hotel.R;
import com.example.lib.Data.Model.BookingModel;
import com.example.lib.Data.Remote.ApiUtils;
import com.example.lib.Data.Remote.Method;
import com.example.lib.Data.ResultModel.PostBooking;
import com.example.lib.Data.ResultModel.PostBookingDetail;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import vn.zalopay.sdk.Environment;
//import vn.zalopay.sdk.ZaloPayError;
//import vn.zalopay.sdk.ZaloPaySDK;
//import vn.zalopay.sdk.listeners.PayOrderListener;

public class ConfilmPay extends AppCompatActivity {
ImageView imageView;
    String amount = "1000";
    AppCompatButton btn_THanhToan;
    FirebaseStorage storage = FirebaseStorage.getInstance();
EditText post_liquidation_name,Giasp1,post_liquidation_desc;
    TextView date_start,date_end;
    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confilm_pay);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        post_liquidation_name=findViewById(R.id.post_liquidation_name);
        post_liquidation_name.setText(ChiTietPhong.namehotel);
        date_start = findViewById(R.id.date_start);
        post_liquidation_desc=findViewById(R.id.post_liquidation_desc);
        post_liquidation_desc.setText(ChiTietPhong.mota);
        date_end = findViewById(R.id.date_end);
        Giasp1=findViewById(R.id.Giasp1);
        Giasp1.setText(ChiTietPhong.giahotel);

        date_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ConfilmPay.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String ngay = "";
                        String thang = "";
                        if (day < 10) {
                            ngay = "0" + day;
                        } else {
                            ngay = String.valueOf(day);
                        }
                        if (month < 10) {
                            thang = "0" + (month + 1);
                        } else {
                            thang = String.valueOf(month + 1);
                        }
                        String date = ngay + "/" + thang + "/" + year;

                        date_start.setText(date);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        date_end.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ConfilmPay.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String ngay = "";
                        String thang = "";
                        if (day < 10) {
                            ngay = "0" + day;
                        } else {
                            ngay = String.valueOf(day);
                        }
                        if (month < 10) {
                            thang = "0" + (month + 1);
                        } else {
                            thang = String.valueOf(month + 1);
                        }
                        String date_end1 = ngay + "/" + thang + "/" + year;

                        date_end.setText(date_end1);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        imageView=findViewById(R.id.IMGSP);
        btn_THanhToan=findViewById(R.id.post_liquidation_btn);
        imageView.setImageBitmap(ChiTietPhong.im);
        StorageReference storageRef = storage.getReferenceFromUrl("gs://thanh-l-c.appspot.com");

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

      //  ZaloPaySDK.init(AppInfo.APP_ID, Environment.SANDBOX);
        btn_THanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateOrder orderApi = new CreateOrder();
                try {
                    JSONObject data1 = orderApi.createOrder(amount);
                    String code = data1.getString("returncode");

                    if (code.equals("1")) {

                        String token = data1.getString("zptranstoken");
//                        ZaloPaySDK.getInstance().payOrder(ConfilmPay.this, token, "demozpdk://app", new PayOrderListener() {
//                            @Override
//                            public void onPaymentSucceeded(final String transactionId, final String transToken, final String appTransID) {
//                                Toast.makeText(ConfilmPay.this, "Thanh toán thành công", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onPaymentCanceled(String zpTransToken, String appTransID) {
//                                Toast.makeText(ConfilmPay.this, "Thanh toán bị hủy", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onPaymentError(ZaloPayError zaloPayError, String zpTransToken, String appTransID) {
//                                Toast.makeText(ConfilmPay.this, "Thanh toán thất bại", Toast.LENGTH_SHORT).show();
//                            }
//
//                        });
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
                                    bookingModel.setIdcustomer(Login.idCustomer);

                                    bookingModel.setIqr(String.valueOf(downloadUri));
                                    methods.InsertBooking(bookingModel).enqueue(new Callback<PostBooking>() {
                                        @Override
                                        public void onResponse(Call<PostBooking> call, Response<PostBooking> response) {

                                            Log.v("id", response.body().getId());
                                            methods.PostBookingDetail(date_start.getText().toString(), date_end.getText().toString(), response.body().getId(), ChiTietPhong.idroom1).enqueue(new Callback<PostBookingDetail>() {
                                                @Override
                                                public void onResponse(Call<PostBookingDetail> call, Response<PostBookingDetail> response) {
                                                    Log.v("status", response.body().getStatus().toString());
                                                    Intent intent = new Intent(ConfilmPay.this, Home.class);
                                                    startActivity(intent);
                                                }

                                                @Override
                                                public void onFailure(Call<PostBookingDetail> call, Throwable t) {

                                                }
                                            });
                                        }

                                        @Override
                                        public void onFailure(Call<PostBooking> call, Throwable t) {

                                        }
                                    });


                                } else {
                                    // Handle failures
                                    // ...
                                }

                            }


                        });
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
       //ZaloPaySDK.getInstance().onResult(intent);
    }
}