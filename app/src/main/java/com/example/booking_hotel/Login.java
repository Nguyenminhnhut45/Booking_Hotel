package com.example.booking_hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.example.booking_hotel.activity.QuenMatKhau;
import com.example.lib.Data.Model.CustomerModel;
import com.example.lib.Data.Model.StatusModel;
import com.example.lib.Data.Model.UserModelPost;
import com.example.lib.Data.Remote.ApiUtils;
import com.example.lib.Data.Remote.Method;
import com.example.lib.Data.ResultModel.PostCustomer;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.example.booking_hotel.activity.test_login;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends Activity {
    CallbackManager callbackManager = CallbackManager.Factory.create();
    ImageView sun, dayland, nightland, moon;
    View daysky, nightsky;
    DayNightSwitch dayNightSwitch;
public static String idCustomer;
    TextView btn_login, btn_dangky, btn_quenmk;
    TextInputEditText txt_taikhoan, txt_matkhau, txt_taikhoandk, txt_matkhaudk, txt_hotendk, txt_emaildk;
    Button btn_login1;
    LinearLayout formlogin, formlogup;
    TextView dangnhap, dangky;
    GoogleSignInClient mGoogleSignInClient;
public  static  String FacebookName;
    public  static  String ImgName;
    public  static  String FacebookID;
    public  static  String NameCustomer;
    private Method method;
    private CustomerModel customerModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActionBar().hide();
        //getSupportActionBar().hide();
        //FacebookSdk.sdkInitialize(getApplicationContext());
        //AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);
        Profile profile = Profile.getCurrentProfile();
        method = ApiUtils.getSOService();

        txt_taikhoan = findViewById(R.id.txt_taikhoan);
        txt_matkhau = findViewById(R.id.txt_matkhau);
        txt_taikhoandk = findViewById(R.id.txt_taikhoandk);
        txt_matkhaudk = findViewById(R.id.txt_matkhaudk);
        txt_hotendk = findViewById(R.id.txt_hotendk);
        txt_emaildk = findViewById(R.id.txt_emaildk);
        btn_quenmk = findViewById(R.id.btn_forgot_password);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        SignInButton signInButton = findViewById(R.id.sign_in_button);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        sun = findViewById(R.id.sun);
        moon = findViewById(R.id.moon);
        dayland = findViewById(R.id.day_landscape);
        nightland = findViewById(R.id.night_landscape);
        daysky = findViewById(R.id.bg_day);
        nightsky = findViewById(R.id.bg_night);
        dayNightSwitch = findViewById(R.id.day_night_switch);
//        btn_login = findViewById(R.id.btn_login);
//        btn_dangky = findViewById(R.id.btn_dangky);
//        btn_quenmk = findViewById(R.id.btn_quenmk);
        btn_login1 = findViewById(R.id.btn_login1);
        dangky = findViewById(R.id.dangKy1);
        dangnhap = findViewById(R.id.login1);
        formlogin = findViewById(R.id.layoutLogin);
        formlogup = findViewById(R.id.layoutLoginUp);
        TextView btn_forgot_password = findViewById(R.id.btn_forgot_password);
        btn_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change forgot password
            }
        });


        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        btn_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingInUser();
            }
        });

        // If using in a fragment
        //   loginButton.setFragment(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Intent intent = new Intent(Login.this, Home.class);
                       Login.FacebookName =profile.getName();
                       Login.FacebookID=loginResult.getAccessToken().getUserId();
                       String img= "https://graph.facebook.com/"+ loginResult.getAccessToken().getUserId()+"/picture?return_ssl_resources=1";
                        Login.ImgName=img;
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
            }


        });
        // Callback registration


        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Intent intent = new Intent(Login.this, Home.class);
                        Login.FacebookName =profile.getName();
                        Login.FacebookID=loginResult.getAccessToken().getUserId();
                        String img= "https://graph.facebook.com/"+ loginResult.getAccessToken().getUserId()+"/picture?return_ssl_resources=1";
                        Login.ImgName=img;
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();


        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        printHashKey(Login.this);
        //
        sun.setTranslationY(-110);
        moon.setTranslationY(-110);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night) {
                    //mặt trời lặn
                    sun.animate().translationY(2000).setDuration(1000);
                    dayland.animate().alpha(0).setDuration(1300);
                    daysky.animate().alpha(0).setDuration(1300);
                    //mặt trăng mọc
                    moon.animate().translationY(-2590).setDuration(1000);
                    dayland.animate().alpha(0).setDuration(1300);
                    daysky.animate().alpha(0).setDuration(1300);
                } else {
                    //mặt trời mọc
                    sun.animate().translationY(-110).setDuration(1000);
                    dayland.animate().alpha(1).setDuration(1300);
                    daysky.animate().alpha(1).setDuration(1300);
                    //mặt trặng lặn
                    moon.animate().translationY(2000).setDuration(1000);
                    dayland.animate().alpha(1).setDuration(1300);
                    daysky.animate().alpha(1).setDuration(1300);
                }
            }
        });


        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formlogin.setVisibility(View.GONE);
                formlogup.setVisibility(View.VISIBLE);
                btn_login1.setText("Đăng ký");
                btn_login1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SingUpUser();

                    }
                });
            }
        });
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formlogin.setVisibility(View.VISIBLE);
                formlogup.setVisibility(View.GONE);
                btn_login1.setText("Đăng nhập");
                btn_login1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SingInUser();
                    }
                });
            }
        });
        //
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login.this, Home.class);
//                startActivity(intent);
//            }
//        });
//
//        btn_dangky.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
        btn_quenmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, QuenMatKhau.class);
                startActivity(intent);
            }
        });
    }

    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("TAG", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("TAG", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("TAG", "printHashKey()", e);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }


    private void SingInUser() {
        String username = txt_taikhoan.getEditableText().toString().trim();
        String password = txt_matkhau.getEditableText().toString().trim();

        if(username.isEmpty() && password.isEmpty()){
            Toast.makeText(Login.this, "Vui lòng điền thông tin để đăng nhập", Toast.LENGTH_SHORT).show();
            return;
        }
        method.getUserLogin(username, password).enqueue(new Callback<StatusModel>() {
            @Override
            public void onResponse(Call<StatusModel> call, Response<StatusModel> response) {

                if (response.body().getStatusCode() == true) {

                   // Log.v("idCustomer", response.body().getUsers().getIduser());

                    Toast.makeText(Login.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Home.class);


                    method.GetCustomerByIdUser(response.body().getUsers().getIduser()).enqueue(new Callback<CustomerModel>() {
                       @Override
                       public void onResponse(Call<CustomerModel> call, Response<CustomerModel> response) {
                           Login.idCustomer=response.body().getIdcustomer();
                           Login.NameCustomer=response.body().getCustomerName();
                           Log.v("idCustomer", idCustomer);

                       }

                       @Override
                       public void onFailure(Call<CustomerModel> call, Throwable t) {

                       }
                   });
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Vui lòng kiểm tra lại thông tin đăng nhập!", Toast.LENGTH_SHORT).show();
                }
                Log.v("status", "ok");
            }

            @Override
            public void onFailure(Call<StatusModel> call, Throwable t) {
                Log.v("status", "loi");
                Toast.makeText(Login.this, "Mất kết nối máy chủ!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void SingUpUser() {

        if (!validateUsername() | !validatePass() | !validateName() | validateEmail()) {
            return;
        }
        String usernameSingUp = txt_taikhoandk.getEditableText().toString();
        String passwordSingUp = txt_matkhaudk.getEditableText().toString();
        String emailSingUp = txt_emaildk.getEditableText().toString();
        String fullNameSingUp = txt_hotendk.getEditableText().toString();
        UserModelPost user = new UserModelPost(emailSingUp, fullNameSingUp, usernameSingUp, passwordSingUp);

        method.InsertUser(user).enqueue(new Callback<UserModelPost>() {
            @Override
            public void onResponse(Call<UserModelPost> call, Response<UserModelPost> response) {
                Toast.makeText(Login.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserModelPost> call, Throwable t) {
                Toast.makeText(Login.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Validate SingUp
    //==================================
    private boolean validateEmail() {
        String emailInput = txt_emaildk.getEditableText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (emailInput.isEmpty()) {
            txt_emaildk.setError("Vui long nhập Email");
            return false;
        } else if (!emailInput.matches(emailPattern)) {
            txt_emaildk.setError("Email không đúng định dạng");
            return false;
        } else {
            txt_emaildk.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String emailInput = txt_hotendk.getEditableText().toString().trim();
        if (emailInput.isEmpty()) {
            txt_hotendk.setError("Vui lòng nhập họ tên");
            return false;
        } else {
            txt_hotendk.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String username = txt_taikhoandk.getEditableText().toString();
        String noWhileSpace = "\\A\\w{4,20}\\z]";
       // String noWhileSpace = "(?=\\S+$)";
        if (username.isEmpty()) {
            txt_taikhoandk.setError("Vui lòng nhập tên tài khoản");
            return false;
        } else if (username.length() >= 20) {
            txt_taikhoandk.setError("Tên tài khoản quá dài");
            return true;
        } else if (!username.matches(noWhileSpace)) {
            txt_taikhoan.setError("Tên đăng nhập không được có khoảng trắng");
            return false;
        } else {
            txt_emaildk.setError(null);
            return true;
        }
    }

    private boolean validatePass() {
        String pass = txt_matkhaudk.getEditableText().toString().trim();
        String passwordVal = "^" +
               // "(?=.*[0-9])" +
                //"(?=.*[a-z])" +
                //"(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&*+=])" +
                "(?=\\S+$)" +
                ".{4,}" +
                "$";
        if (pass.isEmpty()) {
            txt_matkhaudk.setError("Vui lòng nhập mật khẩu");
            return false;
        } else if (!pass.matches(passwordVal)) {
            txt_matkhaudk.setError("Mật khẩu bao gồm chữ và kí tự đặc biệt. Không khoảng trắng");
            return false;
        }
        {
            txt_matkhaudk.setError(null);
            return true;
        }
    }
    //====================================

    //Login google
    // =========================
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1);
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            GoogleSignInAccount s = GoogleSignIn.getLastSignedInAccount(this);
            if(s!=null){
                String persionName = s.getDisplayName();
                Log.v("Username: ", persionName);
                Log.v("Username: ", s.getId());
                Log.v("Username: ", s.getEmail());
                Log.v("Username: ", String.valueOf(s.getPhotoUrl()));
                CustomerModel customerModel = new CustomerModel();
                customerModel.setEmail(s.getEmail());
                customerModel.setCustomerName(s.getDisplayName());
                customerModel.setAvatar(String.valueOf(s.getPhotoUrl()));
                customerModel.setIdgoogle(s.getId());
                CreateCustomer(customerModel);
                Intent intent= new Intent(Login.this, Home.class);
                intent.putExtra("idCustomer", customerModel.getIdcustomer());
                intent.putExtra("CustomerName", customerModel.getCustomerName());
                intent.putExtra("avatar", customerModel.getAvatar());
                intent.putExtra("Email", customerModel.getEmail());
                intent.putExtra("Birthday", customerModel.getBrithday());

                startActivity(intent);
            }
            // updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.v("test", "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }
    //====================================
    private void CreateCustomer(CustomerModel customer){
        method.InsertCustomer(customer).enqueue(new Callback<PostCustomer>() {
            @Override
            public void onResponse(Call<PostCustomer> call, Response<PostCustomer> response) {

                if(response.body().getStatusCode().equals("true")){
                    customerModel =(CustomerModel) response.body().getCustomer1();
                    Log.v("customermodel",customer.getCustomerName());
                    Log.v("customermodel","Success");
                    Toast.makeText(Login.this, "Đăng nhập thành công với tài khoản google"+ customer.getCustomerName()
                            ,Toast.LENGTH_SHORT).show();
                }
                else {
                    method.GetCustomer(customer.getIdgoogle()).enqueue(new Callback<CustomerModel>() {
                        @Override
                        public void onResponse(Call<CustomerModel> call, Response<CustomerModel> response) {
                            Toast.makeText(Login.this, "Đăng nhập thành công với tài khoản google "+ customer.getCustomerName()
                                    ,Toast.LENGTH_SHORT).show();
                            customerModel = response.body();
                            Log.v("test",customer.getCustomerName());
                        }

                        @Override
                        public void onFailure(Call<CustomerModel> call, Throwable t) {
                            Toast.makeText(Login.this, "Mất kết nói server",Toast.LENGTH_SHORT).show();
                            Log.v("test","loi");
                        }
                    });

                }

            }

            @Override
            public void onFailure(Call<PostCustomer> call, Throwable t) {
                Toast.makeText(Login.this, "Mất kết nói server", Toast.LENGTH_SHORT).show();
            }
        });


    }

}