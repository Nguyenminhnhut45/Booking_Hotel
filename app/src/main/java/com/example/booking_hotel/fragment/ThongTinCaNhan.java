package com.example.booking_hotel.fragment;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking_hotel.Login;
import com.example.booking_hotel.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;


public class ThongTinCaNhan extends Fragment {
    TextInputEditText edit_name;
    private static final int RESULT_OK =-1 ;
    TextView profile_fullname,profile_username,btn_update;
ImageView img_profile;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final int SELECT_PICTURE = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thong_tin_ca_nhan, container, false);
        profile_fullname=view.findViewById(R.id.profile_fullname);
        profile_fullname.setText(Login.NameCustomer);
        edit_name=view.findViewById(R.id.edit_name);
        edit_name.setText(Login.NameCustomer);

        img_profile=view.findViewById(R.id.img_profile);
        btn_update=view.findViewById(R.id.btn_update);
        profile_username=view.findViewById(R.id.profile_username);
        profile_username.setText(Login.mail);
        StorageReference storageRef = storage.getReferenceFromUrl("gs://thanh-l-c.appspot.com");

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                        StorageReference mountainsRef = storageRef.child("imgae" + calendar.getTimeInMillis() + ".png");

                        img_profile.setDrawingCacheEnabled(true);
                img_profile.buildDrawingCache();
                        Bitmap bitmap = ((BitmapDrawable) img_profile.getDrawable()).getBitmap();
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


                                // ạnh nhựt code update cái user  chỗ này nhé muốn lấy hình thì String.valueof(downloadUri)


                                } else {
                                    // Handle failures
                                    // ...
                                }

                            }


                        });
            }
        });
img_profile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, SELECT_PICTURE);
    }
});
        return view;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getApplicationContext().getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                img_profile.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }
        }
    }

}