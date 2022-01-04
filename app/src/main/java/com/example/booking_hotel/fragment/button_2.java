package com.example.booking_hotel.fragment;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.booking_hotel.MainActivity;
import com.example.booking_hotel.R;
import com.example.booking_hotel.adapter.Recyclerview_Search;
import com.example.booking_hotel.adapter.RoomAdapter;
import com.example.lib.Data.Model.Room;
import com.example.lib.Data.Remote.ApiUtils;
import com.example.lib.Data.Remote.Method;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link button_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class button_2 extends Fragment {
    RecyclerView lv_list;
    EditText editText;
    private  static final int RC=1;
    public static final int RESULT_OK = -1;
    ArrayList<Room> list;
    ImageView button;

    Recyclerview_Search recyclerview_search;
    RoomAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public button_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment button_2.
     */
    // TODO: Rename and change types and number of parameters
    public static button_2 newInstance(String param1, String param2) {
        button_2 fragment = new button_2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button_2,container,false);
        lv_list=view.findViewById(R.id.listimkiem);
        editText=view.findViewById(R.id.testimkiem);

        button=view.findViewById(R.id.mic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"");
                try{
                    startActivityForResult(intent,RC);
                    editText.setText("");
                }catch( ActivityNotFoundException e)
                {
                    Toast.makeText(getApplicationContext(), "không hỗ trợ", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                recyclerview_search.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        getRoom();
        return view;
    }
    private void getRoom () {
        Method method = ApiUtils.getSOService();
        list = new ArrayList<>();
        method.getRoom().enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                list = (ArrayList<Room>) response.body();
                lv_list.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerview_search = new Recyclerview_Search(getContext(), list);
                lv_list.setLayoutManager(layoutManager);

                lv_list.setAdapter(recyclerview_search);
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {

            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode)
        {
            case RC:
                if(resultCode == RESULT_OK && data !=null)
                {

                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    editText.setText(text.get(0));
                }
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);

    }
}