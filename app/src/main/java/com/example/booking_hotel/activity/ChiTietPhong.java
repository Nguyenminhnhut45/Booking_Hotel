package com.example.booking_hotel.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.booking_hotel.R;
import com.example.booking_hotel.adapter.photoViewpager2Adapter;
import com.example.booking_hotel.loadimg.photo;
import com.google.zxing.WriterException;

import java.util.ArrayList;
import java.util.List;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import me.relex.circleindicator.CircleIndicator3;

public class ChiTietPhong extends AppCompatActivity {
TextView CT_Gia,address,Hotelname,Mota;
    private ViewPager2 mViewPager2;
    private CircleIndicator3 mCircleIndicator3;
    private List<photo> mListPhoto;
    Button btn_datphong;
    public static Bitmap im;
    public static String idroom1;
    Bitmap bitmap;

    QRGEncoder qrgEncoder;

    private static String img;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int currentPosition = mViewPager2.getCurrentItem();
            if (currentPosition == mListPhoto.size() - 1){
                mViewPager2.setCurrentItem(0);
            }else {
                mViewPager2.setCurrentItem(currentPosition + 1);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_chi_tiet_phong);
        btn_datphong=findViewById(R.id.btn_datphong);
        mViewPager2 = findViewById(R.id.viewpager2);
        mCircleIndicator3 = findViewById(R.id.circle_indicator3);
        CT_Gia=findViewById(R.id.CTP_gia);
        address=findViewById(R.id.Txt_address);
        Hotelname=findViewById(R.id.CTP_title);
        Mota=findViewById(R.id.txt_mota);
        mListPhoto = getListPhoto();
        Intent intent= getIntent();
        ChiTietPhong.idroom1=intent.getStringExtra("idroom");
        photoViewpager2Adapter adapter = new photoViewpager2Adapter(mListPhoto);
        mViewPager2.setAdapter(adapter);
        mCircleIndicator3.setViewPager(mViewPager2);
loaddataFromAdapter();
btn_datphong.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        // below line is for getting
        // the windowmanager service.
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

        // initializing a variable for default display.
        Display display = manager.getDefaultDisplay();

        // creating a variable for point which
        // is to be displayed in QR Code.
        Point point = new Point();
        display.getSize(point);

        // getting width and
        // height of a point
        int width = point.x;
        int height = point.y;

        // generating dimension from width and height.
        int dimen = width < height ? width : height;
        dimen = dimen * 3 / 4;
        String test ="hellooo";
        // setting this dimensions inside our qr code
        // encoder to generate our qr code.
        qrgEncoder = new QRGEncoder("Tên Khách sạn"+Hotelname.getText().toString()+"\n"+"Địa chỉ"+CT_Gia.getText().toString()+"\n", null, QRGContents.Type.TEXT, dimen);
        try {
            // getting our qrcode in the form of bitmap.
            bitmap = qrgEncoder.encodeAsBitmap();
            // the bitmap is set inside our image
            // view using .setimagebitmap method.
          //  qrCodeIV.setImageBitmap(bitmap);
            Intent intent= new Intent(ChiTietPhong.this,ConfilmPay.class);
            //   intent.putExtra("img",bitmap);
            ChiTietPhong.im=bitmap;
            startActivity(intent);
        } catch (WriterException e) {
            // this method is called for
            // exception handling.
            Log.e("Tag", e.toString());
        }
    }
});
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable,3000);
            }
        });
    }
    private List<photo> getListPhoto(){
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.viewhomestay));
        list.add(new photo(R.drawable.viewhomestay1));
        list.add(new photo(R.drawable.viewhomestay2));
        list.add(new photo(R.drawable.viewhomestay3));
        list.add(new photo(R.drawable.viewhomestay4));
        list.add(new photo(R.drawable.viewhomestay5));

        return list;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable,2000);
    }
    private void loaddataFromAdapter()
    {
        Intent intent= getIntent();
        CT_Gia.setText(intent.getStringExtra("gia")+"/VNĐ");
                address.setText(intent.getStringExtra("diachi"));
        Hotelname.setText(intent.getStringExtra("tenks"));
                Mota.setText(intent.getStringExtra("mota"));
                img=intent.getStringExtra("hinh");
              //  ChiTietPhong.idroom1=intent.getStringExtra("idroom");
    }
}